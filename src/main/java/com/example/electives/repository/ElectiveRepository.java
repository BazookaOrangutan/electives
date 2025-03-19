package com.example.electives.repository;

import com.example.electives.model.Elective;
import com.example.electives.model.Lecturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface ElectiveRepository extends JpaRepository<Elective, UUID> {
    @Query("SELECT e FROM Elective e WHERE e.title LIKE %:title% AND e.author.name LIKE %:authorName%")
    List<Elective> findByTitleAndAuthorName(@Param("authorName") String authorName, @Param("title") String title);
}
