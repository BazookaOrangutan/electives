package com.example.electives.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class ProfTrainingRepository {

    private final JdbcTemplate jdbcTemplate;

    public void deleteAllByLecturerId(UUID lecturerId) {
        jdbcTemplate.update("DELETE FROM prof_training WHERE lecturer_id = ?", lecturerId);
    }
}
