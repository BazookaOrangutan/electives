package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class ScienceInterest {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    @ManyToMany
    @JoinTable(name="lecturer-science_interest",
               joinColumns = @JoinColumn(name="science_interest_id", referencedColumnName="id"),
                inverseJoinColumns = @JoinColumn(name="lecturer_id", referencedColumnName = "id"))
    private List<Lecturer> lecturers = new ArrayList<>();
}
