package com.example.electives.repository;

import com.example.electives.model.Elective;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ElectiveRepository extends JpaRepository<Elective, UUID> {
}
