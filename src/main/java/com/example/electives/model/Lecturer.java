package com.example.electives.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Lecturer {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String photo;

    private String scientificDegree;
    private String academicTitle;
    private Integer experience;
    private Integer specialtyExperience;
    private String email;
    private String phone;
    private String address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<Discipline> disciplines =  new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<Education> educations =  new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<JobInUniversity> jobsInUniversity = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<JobTitle> jobTitles = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<ProfExperience> profExperience = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<ProfTraining> profTrainings = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<ScienceInterest> scienceInterests = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "lecturer_id")
    private List<ScientificWork> scientificWorks = new ArrayList<>();

}
