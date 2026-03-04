package edu.icet.service.impl;

import edu.icet.model.dto.InterviewSlotDTO;
import edu.icet.model.entity.InterviewSlot;
import edu.icet.model.entity.Interviewer;
import edu.icet.repository.IntertviewerRepository;
import edu.icet.repository.InterviewSlotRepository;
import edu.icet.service.InterviewSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InterviewSlotServiceImpl implements InterviewSlotService {

    private final InterviewSlotRepository interviewSlotRepository;
    private final IntertviewerRepository intertviewerRepository;

    @Override
    public void addSlot(InterviewSlotDTO request) {
        if (request.getStartTime().isBefore(LocalDateTime.now())){
            throw new IllegalArgumentException("Time not support");
        }

        Interviewer interviewer = intertviewerRepository.findById(request.getInterviewerId())
                .orElseThrow(() -> new IllegalArgumentException("Not find Interviewer"));


        InterviewSlot slot = new InterviewSlot();
        slot.setStartTime(request.getStartTime());
        slot.setEndTime(request.getEndTime());
        slot.setInterviewer(interviewer);
        slot.setAvailable(true);

        interviewSlotRepository.save(slot);
    }

    @Override
    public List<InterviewSlotDTO> getAvailbleSlots() {

        List<InterviewSlot> availableSlots = interviewSlotRepository.findByIsAvailableTrueAndStartTimeAfter(LocalDateTime.now());


        return availableSlots.stream().map(slot -> {
            InterviewSlotDTO dto = new InterviewSlotDTO();
            BeanUtils.copyProperties(slot, dto);

            dto.setSlotId(slot.getId());
            dto.setInterviewerId(slot.getInterviewer().getId());
            dto.setInterviewerName(slot.getInterviewer().getName());
            dto.setStatus("AVAILABLE");

            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<InterviewSlotDTO> getBookedSlots() {
        List<InterviewSlot> bookedSlots = interviewSlotRepository.findByIsAvailableFalse();


        List<InterviewSlotDTO> dtoList = new ArrayList<>();
        for (InterviewSlot slot : bookedSlots) {
            InterviewSlotDTO dto = new InterviewSlotDTO();

            dto.setSlotId(slot.getId());

            if (slot.getInterviewer() != null) {
                dto.setInterviewerId(slot.getInterviewer().getId());
                dto.setInterviewerName(slot.getInterviewer().getName());
            } else {
                dto.setInterviewerName("Unknown");
            }

            dto.setStartTime(slot.getStartTime());
            dto.setEndTime(slot.getEndTime());
            dto.setAvailable(slot.isAvailable());

            dto.setStatus("BOOKED");
            dtoList.add(dto);
        }
        return dtoList;
    }
}
