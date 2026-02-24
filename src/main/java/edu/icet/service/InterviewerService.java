package edu.icet.service;

import edu.icet.model.dto.InterviewerDTO;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface InterviewerService {
    InterviewerDTO addInterviewer(InterviewerDTO interviewerDTO);

    @Nullable List<InterviewerDTO> getAllInterviewers();
}
