package com.example.electives.service;

import com.example.electives.model.Lecturer;

import java.util.List;
import java.util.UUID;

public interface LecturerService {

    Lecturer createLecturer(Lecturer lecturer);

    Lecturer getLecturerById(UUID id);

    List<Lecturer> getAllLecturers();

    Lecturer updateLecturer(UUID id, Lecturer lecturer);

    void deleteLecturer(UUID id);

    boolean hasElectives(UUID id);

    void deleteLecturerWithElectives(UUID id);
}
