package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class InterviewSlotDTO {
    private Long id;

    private Long interviewerId;

    private String interviewerName;

    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}