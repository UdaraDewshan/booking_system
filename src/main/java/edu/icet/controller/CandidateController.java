package edu.icet.controller;

import edu.icet.model.dto.CandidateDTO;
import edu.icet.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
@RequiredArgsConstructor
@CrossOrigin
public class CandidateController {

    final private CandidateService candidateService;

    @PostMapping("/add")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO candidateDTO){
        CandidateDTO saveCandidate = candidateService.addCandidate(candidateDTO);
        return ResponseEntity.ok(saveCandidate);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateDTO>> getAllCandidates(){
        return ResponseEntity.ok(candidateService.getAllCandidates());
    }



}
