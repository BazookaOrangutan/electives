package com.example.electives.repository;

import com.example.electives.model.Education;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class EducationRepository{

    private final JdbcTemplate jdbcTemplate;

    public void deleteAllByLecturerId(UUID lecturerId) {
        jdbcTemplate.update("DELETE FROM education WHERE lecturer_id = ?", lecturerId);
    }
}
