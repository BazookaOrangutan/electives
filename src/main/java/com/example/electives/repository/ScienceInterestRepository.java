package com.example.electives.repository;

import com.example.electives.model.ScienceInterest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ScienceInterestRepository extends JpaRepository<ScienceInterest, UUID> {
}
