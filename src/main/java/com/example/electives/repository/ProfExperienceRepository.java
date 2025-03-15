package com.example.electives.repository;

import com.example.electives.model.ProfExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfExperienceRepository extends JpaRepository<ProfExperience, UUID> {
}
