package com.example.electives.dto.response;

import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Data
@Builder
public class LecturerResponse {

    private UUID id;
    private String name;
    private String scientificDegree;
    private String academicTitle;
    private Integer experience;
    private Integer specialtyExperience;
    private String email;
    private String phone;
    private String address;
    private List<String> educations;
    private List<String> jobTitles;
    private List<String> jobsInUniversity;
    private List<String> disciplines;
    private List<String> profTrainings;
    private List<String> scienceInterests;
    private List<String> profExperience;
    private List<String> scientificWorks;

}
