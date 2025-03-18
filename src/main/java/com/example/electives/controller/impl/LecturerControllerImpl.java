package com.example.electives.controller.impl;

import com.example.electives.controller.LecturerController;
import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.dto.response.LecturerResponse;
import com.example.electives.mapper.LecturerMapper;
import com.example.electives.model.Discipline;
import com.example.electives.model.Lecturer;
import com.example.electives.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.example.electives.constant.EndpointConstants.URL_LECTURERS_API;

@RestController
@RequestMapping(URL_LECTURERS_API)
@RequiredArgsConstructor
public class LecturerControllerImpl implements LecturerController {

    private final LecturerService lecturerService;
    private final LecturerMapper lecturerMapper;

    @Override
    public LecturerResponse createLecturer(LecturerRequest lecturerRequest) {

        Lecturer lecturer = lecturerMapper.fromRequest(lecturerRequest);

        return lecturerMapper.toResponse(lecturerService.createLecturer(lecturer));
    }

    @Override
    public LecturerResponse getLecturerById(UUID id) {
        return lecturerMapper.toResponse(lecturerService.getLecturerById(id));
    }

    @Override
    public List<LecturerResponse> getAllLecturers() {
        return lecturerService.getAllLecturers().stream().map(lecturerMapper::toResponse).toList();
    }

    @Override
    public LecturerResponse updateLecturer(UUID id, LecturerRequest lecturerRequest) {

        Lecturer lecturer = lecturerMapper.fromRequest(lecturerRequest);

        Lecturer updatedLecturer = lecturerService.updateLecturer(id, lecturer);

        return lecturerMapper.toResponse(updatedLecturer);
    }

    @Override
    public void deleteLecturer(UUID id) {
        lecturerService.deleteLecturer(id);
    }

}
