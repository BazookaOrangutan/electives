package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class ProfExperience {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String years;
    private String description;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;

}
