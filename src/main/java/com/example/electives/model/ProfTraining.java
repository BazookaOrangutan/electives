package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ProfTraining {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private int year;
    private String university;
    private String specialization;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
}
