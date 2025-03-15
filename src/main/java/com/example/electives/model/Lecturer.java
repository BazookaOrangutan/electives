package com.example.electives.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;

    private String scientificDegree;
    private String academicTitle;
    private int experience;
    private int specialtyExperience;
    private String email;
    private String phone;
    private String address;

    @ManyToMany
    @JoinTable(name="lecturer-science_interest",
            joinColumns =  @JoinColumn(name="lecturer_id", referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="science_interest_id", referencedColumnName="id")
    )
    private List<ScienceInterest> scienceInterests = new ArrayList<>();
}
