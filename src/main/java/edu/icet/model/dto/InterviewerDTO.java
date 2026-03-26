package edu.icet.model.dto;
import lombok.Data;

@Data
public class InterviewerDTO {
    private Long id;
    private String name;
    private String email;
    private String specialization;
}