package com.example.electives.service.impl;

import com.example.electives.model.Discipline;
import com.example.electives.repository.DisciplineRepository;
import com.example.electives.service.DisciplineService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class DisciplineServiceImpl implements DisciplineService {

    private final DisciplineRepository disciplineRepository;

    @Override
    public Discipline createDiscipline(Discipline discipline) {
        return null;
    }

    @Override
    public List<Discipline> getDisciplinesByLecturerId(UUID lecturerId) {
        return null;
    }

    @Override
    public List<String> getDisciplinesNamesByLecturerId(UUID lecturerId) {
        return List.of();
    }

    @Override
    public Discipline updateDiscipline(UUID id, Discipline discipline) {

//        if(!disciplineRepository.existsById(id)) {
//
//        }
//
//        discipline.setId(id);
//
//        return disciplineRepository.save(discipline);
        return null;
    }

    @Override
    public void deleteDiscipline(UUID id) {
//        disciplineRepository.deleteById(id);
    }
}
