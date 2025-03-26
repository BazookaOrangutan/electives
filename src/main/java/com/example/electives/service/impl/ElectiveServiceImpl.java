package com.example.electives.service.impl;

import com.example.electives.exception.ElectiveNotFoundException;
import com.example.electives.model.Elective;
import com.example.electives.repository.ElectiveRepository;
import com.example.electives.service.ElectiveService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ElectiveServiceImpl implements ElectiveService {

    private final ElectiveRepository electiveRepository;

    @Override
    public Elective createElective(Elective elective) {

        Integer maxOrder = electiveRepository.findMaxSortOrder();
        elective.setSortOrder(maxOrder != null ? maxOrder + 1 : 0);

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
        return electiveRepository.findAllByOrderBySortOrderAsc();
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
    @Transactional
    public void deleteElective(UUID id) {

        electiveRepository.deleteById(id);

        reorderElectives(electiveRepository.findAll().stream().map(Elective::getId).toList());
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

    @Override
    public void reorderElectives(List<UUID> newOrder) {
        List<Elective> electives = electiveRepository.findAll();

        Map<UUID, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < newOrder.size(); i++) {
            orderMap.put(newOrder.get(i), i);
        }

        electives.forEach(elective -> {
            Integer newSortOrder = orderMap.get(elective.getId());
            if (newSortOrder != null) {
                elective.setSortOrder(newSortOrder);
            }
        });

        electiveRepository.saveAll(electives);
    }

    @Override
    public void initSortOrder() {
        List<Elective> electives = electiveRepository.findAll();
        if (electives.stream().anyMatch(e -> e.getSortOrder() == null)) {
            for (int i = 0; i < electives.size(); i++) {
                electives.get(i).setSortOrder(i);
            }
            electiveRepository.saveAll(electives);
        }
    }
}
