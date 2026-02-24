package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long bookingId;
    private Long slotId;
    private String candidateName;
    private String interviewerName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String status;
}