package com.example.electives.repository;

import com.example.electives.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JobTitleRepository extends JpaRepository<JobTitle, UUID> {
}
