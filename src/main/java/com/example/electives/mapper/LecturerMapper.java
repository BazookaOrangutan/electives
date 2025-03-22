package com.example.electives.mapper;

import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.dto.response.LecturerResponse;
import com.example.electives.model.*;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.Optional;

@Component
@Mapper(componentModel = "spring")
public interface LecturerMapper {

    default LecturerResponse toResponse(Lecturer lecturer){

        return LecturerResponse.builder()
                .id(lecturer.getId())
                .name(lecturer.getName())
                .photo(lecturer.getPhoto())
                .scientificDegree(lecturer.getScientificDegree())
                .academicTitle(lecturer.getAcademicTitle())
                .experience(lecturer.getExperience())
                .specialtyExperience(lecturer.getSpecialtyExperience())
                .email(lecturer.getEmail())
                .phone(lecturer.getPhone())
                .address(lecturer.getAddress())
                .educations(lecturer.getEducations().stream().map(Education::getDescription).toList())
                .jobTitles(lecturer.getJobTitles().stream().map(JobTitle::getTitle).toList())
                .jobsInUniversity(lecturer.getJobsInUniversity().stream().map(JobInUniversity::getDescription).toList())
                .disciplines(lecturer.getDisciplines().stream().map(Discipline::getName).toList())
                .profTrainings(lecturer.getProfTrainings().stream().map(ProfTraining::getDescription).toList())
                .scienceInterests(lecturer.getScienceInterests().stream().map(ScienceInterest::getName).toList())
                .profExperience(lecturer.getProfExperience().stream().map(ProfExperience::getDescription).toList())
                .scientificWorks(lecturer.getScientificWorks().stream().map(ScientificWork::getDescription).toList())
                .build();
    }

    default Lecturer fromRequest(LecturerRequest lecturerRequest){

        return Lecturer.builder()
                .name(lecturerRequest.getName())
                .photo(lecturerRequest.getPhoto())
                .scientificDegree(lecturerRequest.getScientificDegree())
                .academicTitle(lecturerRequest.getAcademicTitle())
                .experience(lecturerRequest.getExperience())
                .specialtyExperience(lecturerRequest.getSpecialtyExperience())
                .email(lecturerRequest.getEmail())
                .phone(lecturerRequest.getPhone())
                .address(lecturerRequest.getAddress())
                .disciplines(Optional.ofNullable(lecturerRequest.getDisciplines())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> Discipline.builder().name(el).build())
                        .toList())
                .educations(Optional.ofNullable(lecturerRequest.getEducations())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> Education.builder().description(el).build())
                        .toList())
                .jobsInUniversity(Optional.ofNullable(lecturerRequest.getJobsInUniversity())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> JobInUniversity.builder().description(el).build())
                        .toList())
                .jobTitles(Optional.ofNullable(lecturerRequest.getJobTitles())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> JobTitle.builder().title(el).build())
                        .toList())
                .profExperience(Optional.ofNullable(lecturerRequest.getProfExperience())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> ProfExperience.builder().description(el).build())
                        .toList())
                .profTrainings(Optional.ofNullable(lecturerRequest.getProfTrainings())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> ProfTraining.builder().description(el).build())
                        .toList())
                .scienceInterests(Optional.ofNullable(lecturerRequest.getScienceInterests())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> ScienceInterest.builder().name(el).build())
                        .toList())
                .scientificWorks(Optional.ofNullable(lecturerRequest.getScientificWorks())
                        .orElse(Collections.emptyList())
                        .stream().map(el -> ScientificWork.builder().description(el).build())
                        .toList())
                .build();
    };

//    @AfterMapping
//    default void setLecturerFields(@MappingTarget Lecturer lecturer, LecturerRequest lecturerRequest) {
//        lecturer.setDisciplines(lecturerRequest.getDisciplines().stream().map(el -> Discipline.builder().name(el).build()).toList());
//        lecturer.setEducations(lecturerRequest.getEducations().stream().map(el -> Education.builder().description(el).build()).toList());
//        lecturer.setJobsInUniversity(lecturerRequest.getJobsInUniversity().stream().map(el -> JobInUniversity.builder().description(el).build()).toList());
//        lecturer.setJobTitles(lecturerRequest.getJobTitles().stream().map(el -> JobTitle.builder().title(el).build()).toList());
//        lecturer.setProfExperience(lecturerRequest.getProfExperience().stream().map(el -> ProfExperience.builder().description(el).build()).toList());
//        lecturer.setProfTrainings(lecturerRequest.getProfTrainings().stream().map(el -> ProfTraining.builder().description(el).build()).toList());
//        lecturer.setScienceInterests(lecturerRequest.getScienceInterests().stream().map(el -> ScienceInterest.builder().name(el).build()).toList());
//        lecturer.setScientificWorks(lecturerRequest.getScientificWorks().stream().map(el -> ScientificWork.builder().description(el).build()).toList());
//    }

//    @BeforeMapping
//    default void setResponseFields(@MappingTarget LecturerResponse lecturerResponse, Lecturer lecturer) {

//        lecturerResponse.setDisciplines(lecturer.getDisciplines().stream().map(Discipline::getName).toList());
//        lecturerResponse.setEducations(lecturer.getEducations().stream().map(Education::getDescription).toList());
//        lecturerResponse.setJobsInUniversity(lecturer.getJobsInUniversity().stream().map(JobInUniversity::getDescription).toList());
//        lecturerResponse.setJobTitles(lecturer.getJobTitles().stream().map(JobTitle::getTitle).toList());
//        lecturerResponse.setProfExperience(lecturer.getProfExperience().stream().map(ProfExperience::getDescription).toList());
//        lecturerResponse.setProfTrainings(lecturer.getProfTrainings().stream().map(ProfTraining::getDescription).toList());
//        lecturerResponse.setScienceInterests(lecturer.getScienceInterests().stream().map(ScienceInterest::getName).toList());
//        lecturerResponse.setScientificWorks(lecturer.getScientificWorks().stream().map(ScientificWork::getDescription).toList());
//    }
}
