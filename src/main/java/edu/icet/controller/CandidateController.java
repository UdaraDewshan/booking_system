package edu.icet.controller;

import edu.icet.model.dto.CandidateDTO;
import edu.icet.service.CandidateServise;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

    private CandidateServise candidateServise;

    @PostMapping("/add")
    public ResponseEntity<CandidateDTO> addCandidate(@RequestBody CandidateDTO candidateDTO){
        CandidateDTO saveCandidate = candidateServise.addCandidate(candidateDTO);
        return ResponseEntity.ok(saveCandidate);
    }

    @GetMapping("/all")
    public ResponseEntity<List<CandidateDTO>> getAllCandidates(){
        return ResponseEntity.ok(candidateServise.getAllCandidates());
    }



}
