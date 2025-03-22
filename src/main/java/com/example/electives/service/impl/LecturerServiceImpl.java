package com.example.electives.service.impl;

import com.example.electives.exception.LecturerNotFoundException;
import com.example.electives.model.Lecturer;
import com.example.electives.repository.*;
import com.example.electives.service.LecturerService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

    private final DisciplineRepository disciplineRepository;
    private final EducationRepository educationRepository;
    private final JobInUniversityRepository jobInUniversityRepository;
    private final JobTitleRepository jobTitleRepository;
    private final ProfExperienceRepository profExperienceRepository;
    private final ProfTrainingRepository profTrainingRepository;
    private final ScienceInterestRepository scienceInterestRepository;
    private final ScientificWorkRepository scientificWorkRepository;

    private final ElectiveRepository electiveRepository;

    private void deleteOldInformationForLecturer(UUID lecturerId) {

        disciplineRepository.deleteAllByLecturerId(lecturerId);
        educationRepository.deleteAllByLecturerId(lecturerId);
        jobInUniversityRepository.deleteAllByLecturerId(lecturerId);
        jobTitleRepository.deleteAllByLecturerId(lecturerId);
        profExperienceRepository.deleteAllByLecturerId(lecturerId);
        profTrainingRepository.deleteAllByLecturerId(lecturerId);
        scienceInterestRepository.deleteAllByLecturerId(lecturerId);
        scientificWorkRepository.deleteAllByLecturerId(lecturerId);
    }

    @Override
    public Lecturer createLecturer(Lecturer lecturer) {
        return lecturerRepository.save(lecturer);
    }

    @Override
    public Lecturer getLecturerById(UUID id) {

        return lecturerRepository.findById(id).orElseThrow(
                () -> new LecturerNotFoundException(id)
        );
    }

    @Override
    public List<Lecturer> getAllLecturers() {
        return lecturerRepository.findAll();
    }

    @Override
    public Lecturer updateLecturer(UUID id, Lecturer lecturer) {

        if(!lecturerRepository.existsById(id)) {
            throw new LecturerNotFoundException(id);
        }

        deleteOldInformationForLecturer(id);

        lecturer.setId(id);

        return lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteLecturer(UUID id) {
        lecturerRepository.deleteById(id);
    }

    @Override
    public boolean hasElectives(UUID id) {
        return electiveRepository.existsByAuthorId(id);
    }


    @Override
    @Transactional
    public void deleteLecturerWithElectives(UUID id) {

        electiveRepository.deleteAllByAuthorId(id);

        lecturerRepository.deleteById(id);
    }
}
