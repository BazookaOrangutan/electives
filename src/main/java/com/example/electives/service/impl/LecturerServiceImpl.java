package com.example.electives.service.impl;

import com.example.electives.exception.LecturerNotFoundException;
import com.example.electives.model.Lecturer;
import com.example.electives.repository.LecturerRepository;
import com.example.electives.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class LecturerServiceImpl implements LecturerService {

    private final LecturerRepository lecturerRepository;

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

        lecturer.setId(id);

        return lecturerRepository.save(lecturer);
    }

    @Override
    public void deleteLecturer(UUID id) {
        lecturerRepository.deleteById(id);
    }
}
