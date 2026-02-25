package edu.icet.controller;

import edu.icet.model.dto.InterviewSlotDTO;
import edu.icet.model.entity.InterviewSlot;
import edu.icet.service.InterviewSlotService;
import edu.icet.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
