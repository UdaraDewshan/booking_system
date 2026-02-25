package edu.icet.service;

import edu.icet.model.dto.InterviewSlotDTO;
import edu.icet.model.dto.InterviewerDTO;

import java.util.List;

public interface InterviewerService {
    InterviewerDTO addInterviewer(InterviewerDTO interviewerDTO);
    List<InterviewerDTO> getAllInterviewers();


}
