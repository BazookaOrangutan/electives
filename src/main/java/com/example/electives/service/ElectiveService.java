package com.example.electives.service;

import com.example.electives.model.Elective;
import jakarta.annotation.PostConstruct;
import jakarta.transaction.Transactional;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;
import java.util.UUID;

public interface ElectiveService {

    Elective createElective(Elective elective);

    Elective getElective(UUID id);

    List<Elective> getAllElectives();

    Elective updateElective(UUID id, Elective elective);

    void deleteElective(UUID id);

    List<Elective> getAllElectivesByAuthorAndName(String author, String name);

    void updateActiveStatus(UUID id, Boolean active);

    @Transactional
    void reorderElectives(List<UUID> newOrder);

    @EventListener(ApplicationReadyEvent.class)
    void initSortOrder();
}
