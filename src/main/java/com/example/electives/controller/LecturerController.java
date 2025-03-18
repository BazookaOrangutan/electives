package com.example.electives.controller;

import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.dto.response.LecturerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface LecturerController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    LecturerResponse createLecturer(@RequestBody LecturerRequest lecturerRequest);

    @GetMapping("{id}")
    LecturerResponse getLecturerById(@PathVariable UUID id);

    @GetMapping
    List<LecturerResponse> getAllLecturers();

    @PutMapping("{id}")
    LecturerResponse updateLecturer(@PathVariable UUID id, @RequestBody LecturerRequest lecturerRequest);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteLecturer(@PathVariable UUID id);

}
