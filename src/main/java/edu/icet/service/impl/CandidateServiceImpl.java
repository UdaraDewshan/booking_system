package edu.icet.service.impl;

import edu.icet.model.entity.Candidate;
import edu.icet.model.dto.CandidateDTO;
import edu.icet.repository.CandidateRepository;
import edu.icet.service.CandidateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateRepository candidateRepository;

    @Override
    public CandidateDTO addCandidate(CandidateDTO candidateDTO) {

        Candidate candidate = new Candidate();
        BeanUtils.copyProperties(candidateDTO, candidate);

        Candidate savedCandidate = candidateRepository.save(candidate);

        CandidateDTO savedDto = new CandidateDTO();
        BeanUtils.copyProperties(savedCandidate, savedDto);

        return savedDto;
    }

    @Override
    public List<CandidateDTO> getAllCandidates() {
        List<Candidate> candidates = candidateRepository.findAll();

        return candidates.stream().map(candidate -> {
            CandidateDTO dto = new CandidateDTO();
            BeanUtils.copyProperties(candidate, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}