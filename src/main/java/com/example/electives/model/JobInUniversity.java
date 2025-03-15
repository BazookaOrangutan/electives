package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class JobInUniversity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String date;
    private String title;

    @ManyToOne
    @JoinColumn(name = "lecturer_id")
    private Lecturer lecturer;
}
