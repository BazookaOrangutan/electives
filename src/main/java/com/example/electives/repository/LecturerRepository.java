package com.example.electives.repository;

import com.example.electives.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LecturerRepository extends JpaRepository<Lecturer, UUID> {
}
