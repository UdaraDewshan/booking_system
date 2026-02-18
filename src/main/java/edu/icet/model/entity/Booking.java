package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String candidateName;
    private String candidateEmail;

    private LocalDateTime bookedAt;

    @OneToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "id")
    private InterviewSlot interviewSlot;
}