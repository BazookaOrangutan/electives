package com.example.electives.service.impl;

import com.example.electives.exception.ElectiveNotFoundException;
import com.example.electives.model.Elective;
import com.example.electives.repository.ElectiveRepository;
import com.example.electives.service.ElectiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ElectiveServiceImpl implements ElectiveService {

    private final ElectiveRepository electiveRepository;

    @Override
    public Elective createElective(Elective elective) {
        return electiveRepository.save(elective);
    }

    @Override
    public Elective getElective(UUID id) {

        return electiveRepository.findById(id).orElseThrow(
                () -> new ElectiveNotFoundException(id)
        );
    }

    @Override
    public List<Elective> getAllElectives() {
        return electiveRepository.findAll();
    }

    @Override
    public Elective updateElective(UUID id, Elective elective) {

        if(!electiveRepository.existsById(id)){
            throw new ElectiveNotFoundException(id);
        }

        elective.setId(id);

        return electiveRepository.save(elective);
    }

    @Override
    public void deleteElective(UUID id) {
        electiveRepository.deleteById(id);
    }

    @Override
    public List<Elective> getAllElectivesByAuthorAndName(String author, String name) {
        return electiveRepository.findByTitleAndAuthorName(author, name);
    }

    @Override
    public void updateActiveStatus(UUID id, Boolean active) {

        Elective elective = getElective(id);
        elective.setActive(active);
        electiveRepository.save(elective);
    }
}
