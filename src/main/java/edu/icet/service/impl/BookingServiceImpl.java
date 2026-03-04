package edu.icet.service.impl;

import edu.icet.model.dto.BookingDTO;
import edu.icet.model.entity.Booking;
import edu.icet.model.entity.Candidate;
import edu.icet.model.entity.InterviewSlot;
import edu.icet.repository.BookingRepository;
import edu.icet.repository.CandidateRepository;
import edu.icet.repository.InterviewSlotRepository;
import edu.icet.service.BookingService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final InterviewSlotRepository slotRepository;
    private final CandidateRepository candidateRepository;


    @Override
    @Transactional
    public BookingDTO bookSlot(BookingDTO request) {

        Candidate candidate = candidateRepository.findById(request.getCandidateId())
                .orElseThrow(() -> new IllegalArgumentException("Not find Candidate!"));

        InterviewSlot slot = slotRepository.findById(request.getSlotId())
                .orElseThrow(() -> new IllegalArgumentException("Not find Interview Slot!"));


        if (slot.getStartTime().isBefore(LocalDateTime.now())) {
            throw new IllegalStateException("Validation Error: Time past book!");
        }


        if (!slot.isAvailable()) {
            throw new IllegalStateException("Conflict Error: This slot use someOne!");
        }

        if (bookingRepository.existsByInterviewSlotId(slot.getId())) {
            throw new IllegalStateException("Conflict Error: This slot is has booking!");
        }

        slot.setAvailable(false);
        slotRepository.save(slot);

        Booking booking = new Booking();
        booking.setCandidate(candidate);
        booking.setInterviewSlot(slot);
        booking.setBookingTime(LocalDateTime.now());

        Booking savedBooking = bookingRepository.save(booking);


        log.info("================ EMAIL SIMULATION ================");
        log.info("To: {}", candidate.getEmail());
        log.info("Subject: Interview Booking Confirmation");
        log.info("Body: Dear {}, your interview with {} is confirmed for {}.",
                candidate.getName(), slot.getInterviewer().getName(), slot.getStartTime());
        log.info("==================================================");


        BookingDTO response = new BookingDTO();
        response.setBookingId(savedBooking.getId());
        response.setSlotId(slot.getId());
        response.setCandidateName(candidate.getName());
        response.setInterviewerName(slot.getInterviewer().getName());
        response.setStartTime(slot.getStartTime());
        response.setEndTime(slot.getEndTime());
        response.setStatus("SUCCESS");

        return response;
    }
}
