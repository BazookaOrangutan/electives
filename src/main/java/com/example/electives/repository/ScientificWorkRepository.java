package com.example.electives.repository;

import com.example.electives.model.ScientificWork;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScientificWorkRepository extends JpaRepository<ScientificWork, UUID> {
}
