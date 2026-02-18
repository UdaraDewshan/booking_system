package edu.icet.model.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class BookingDTO {
    private Long id;

    private Long candidateId;
    private Long slotId;

    private String candidateName;
    private LocalDateTime bookedAt;
}