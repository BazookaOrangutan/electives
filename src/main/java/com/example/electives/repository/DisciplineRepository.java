package com.example.electives.repository;

import com.example.electives.model.Discipline;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DisciplineRepository extends JpaRepository<Discipline, UUID> {
}
