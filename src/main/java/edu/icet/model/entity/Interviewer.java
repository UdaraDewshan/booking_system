package edu.icet.model.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Interviewer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String specialization;
}

