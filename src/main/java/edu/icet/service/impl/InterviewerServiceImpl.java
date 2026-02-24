package edu.icet.service.impl;

import edu.icet.model.dto.InterviewerDTO;
import edu.icet.model.entity.Interviewer;
import edu.icet.repository.IntertviewerRepository;
import edu.icet.service.InterviewerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class InterviewerServiceImpl implements InterviewerService {

    private final IntertviewerRepository interviewerRepository;

    @Override
    public InterviewerDTO addInterviewer(InterviewerDTO interviewerDTO) {
        Interviewer interviewer = new Interviewer();
        BeanUtils.copyProperties(interviewerDTO, interviewer);

        Interviewer savedInterviewer = interviewerRepository.save(interviewer);

        InterviewerDTO savedDto = new InterviewerDTO();
        BeanUtils.copyProperties(savedInterviewer, savedDto);

        return savedDto;
    }

    @Override
    public List<InterviewerDTO> getAllInterviewers() {
        List<Interviewer> interviewers = interviewerRepository.findAll();

        return interviewers.stream().map(interviewer -> {
            InterviewerDTO dto = new InterviewerDTO();
            BeanUtils.copyProperties(interviewer, dto);
            return dto;
        }).collect(Collectors.toList());
    }
}
