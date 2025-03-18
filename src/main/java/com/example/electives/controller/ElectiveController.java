package com.example.electives.controller;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.model.Elective;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ElectiveController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Elective createElective(@RequestBody ElectiveRequest electiveRequest);

    @GetMapping("{id}")
    Elective getElectiveById(@PathVariable UUID id);

    @GetMapping
    List<Elective> getAllElectives();

    @PutMapping("{id}")
    Elective updateElective(@PathVariable UUID id, @RequestBody ElectiveRequest electiveRequest);

    @DeleteMapping("{id}")
    void deleteElective(@PathVariable UUID id);
}
