package com.example.electives.service;

import com.example.electives.model.Discipline;

import java.util.List;
import java.util.UUID;

public interface DisciplineService {

    Discipline createDiscipline(Discipline discipline);

    List<Discipline> getDisciplinesByLecturerId(UUID lecturerId);

    List<String> getDisciplinesNamesByLecturerId(UUID lecturerId);

    Discipline updateDiscipline(UUID id, Discipline discipline);

    void deleteDiscipline(UUID id);
}
