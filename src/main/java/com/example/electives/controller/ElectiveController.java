package com.example.electives.controller;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.response.ElectiveResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

public interface ElectiveController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    ElectiveResponse createElective(@RequestBody ElectiveRequest electiveRequest);

    @GetMapping("{id}")
    ElectiveResponse getElectiveById(@PathVariable UUID id);

    @GetMapping
    List<ElectiveResponse> getAllElectives();

    @PutMapping("{id}")
    ElectiveResponse updateElective(@PathVariable UUID id, @RequestBody ElectiveRequest electiveRequest);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteElective(@PathVariable UUID id);

    @GetMapping("search")
    List<ElectiveResponse> searchElective(@RequestParam String author, @RequestParam String elective);
}
