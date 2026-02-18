package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class InterviewSlot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String interviewerName;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    // Status: AVAILABLE, BOOKED
    private String status;

}