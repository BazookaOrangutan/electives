package com.example.electives.repository;

import com.example.electives.model.Discipline;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class DisciplineRepository{

    private final JdbcTemplate jdbcTemplate;

    public void deleteAllByLecturerId(UUID lecturerId) {
        jdbcTemplate.update("DELETE FROM discipline WHERE lecturer_id = ?", lecturerId);
    }
}
