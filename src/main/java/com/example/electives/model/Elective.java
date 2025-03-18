package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Data
@Entity
public class Elective {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;
    private String place;
    private String controlType;
    private String format;
    private String intensity;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Lecturer author;
}
