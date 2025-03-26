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

    @Column(length = 3000)
    private String description;
    private String place;
    private String controlType;
    private String format;
    private String intensity;
    private Boolean active;
    private Integer sortOrder;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Lecturer author;
}

