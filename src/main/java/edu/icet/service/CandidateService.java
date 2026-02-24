package edu.icet.service;

import edu.icet.model.dto.CandidateDTO;

import java.util.List;

public interface CandidateService {
    CandidateDTO addCandidate(CandidateDTO candidateDTO);
    List<CandidateDTO> getAllCandidates();
}
