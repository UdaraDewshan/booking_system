package edu.icet.controller;

import edu.icet.model.dto.InterviewerDTO;
import edu.icet.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/interviewer")
@CrossOrigin
public class InterviewController {

    private final InterviewerService interviewerService;

    @PostMapping("/add")
    public ResponseEntity<InterviewerDTO> addInterviewer(@RequestBody InterviewerDTO interviewerDTO){
        InterviewerDTO savedInterviewer = interviewerService.addInterviewer(interviewerDTO);
        return ResponseEntity.ok(savedInterviewer);
    }

}
