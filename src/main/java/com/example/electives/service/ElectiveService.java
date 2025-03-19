package com.example.electives.service;

import com.example.electives.model.Elective;

import java.util.List;
import java.util.UUID;

public interface ElectiveService {

    Elective createElective(Elective elective);

    Elective getElective(UUID id);

    List<Elective> getAllElectives();

    Elective updateElective(UUID id, Elective elective);

    void deleteElective(UUID id);

    List<Elective> getAllElectivesByAuthorAndName(String author, String name);
}
