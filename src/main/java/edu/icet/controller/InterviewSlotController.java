package edu.icet.controller;

import edu.icet.model.dto.InterviewSlotDTO;
import edu.icet.model.entity.InterviewSlot;
import edu.icet.service.InterviewSlotService;
import edu.icet.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/slot")
@CrossOrigin
public class InterviewSlotController {

    private final InterviewSlotService interviewSlotService;

    @PostMapping("/add")
    public ResponseEntity<String> addSlot(@RequestBody InterviewSlotDTO request){
        interviewSlotService.addSlot(request);
        return ResponseEntity.ok("Slot added successfully");
    }

    @GetMapping("available")
    public ResponseEntity<List<InterviewSlotDTO>> getAvailableSlots(){
        return ResponseEntity.ok(interviewSlotService.getAvailbleSlots());
    }

    @GetMapping("/booked")
    public ResponseEntity<List<InterviewSlotDTO>> getBookedSlots() {
        List<InterviewSlotDTO> bookedSlots = interviewSlotService.getBookedSlots();
        return ResponseEntity.ok(bookedSlots);
    }
}
