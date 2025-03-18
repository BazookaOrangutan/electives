package com.example.electives.controller.impl;

import com.example.electives.controller.ElectiveController;
import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.response.ElectiveResponse;
import com.example.electives.dto.response.LecturerResponse;
import com.example.electives.mapper.ElectiveMapper;
import com.example.electives.mapper.LecturerMapper;
import com.example.electives.model.Elective;
import com.example.electives.model.Lecturer;
import com.example.electives.service.ElectiveService;
import com.example.electives.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.example.electives.constant.EndpointConstants.URL_ELECTIVES_API;

@RestController
@RequestMapping(URL_ELECTIVES_API)
@RequiredArgsConstructor
public class ElectiveControllerImpl implements ElectiveController {

    private final ElectiveService electiveService;
    private final ElectiveMapper electiveMapper;
    private final LecturerService lecturerService;
    private final LecturerMapper lecturerMapper;

    @Override
    public ElectiveResponse createElective(ElectiveRequest electiveRequest) {

        Elective elective = electiveMapper.fromRequest(electiveRequest);

        Lecturer lecturer = lecturerService.getLecturerById(electiveRequest.getAuthorId());
        elective.setAuthor(lecturer);

        LecturerResponse lecturerResponse = lecturerMapper.toResponse(lecturer);

        ElectiveResponse electiveResponse = electiveMapper.toResponse(electiveService.createElective(elective));
        electiveResponse.setLecturer(lecturerResponse);

        return electiveResponse;
    }

    @Override
    public ElectiveResponse getElectiveById(UUID id) {

        Elective elective = electiveService.getElective(id);

        LecturerResponse lecturerResponse = lecturerMapper.toResponse(elective.getAuthor());

        ElectiveResponse electiveResponse = electiveMapper.toResponse(elective);
        electiveResponse.setLecturer(lecturerResponse);

        return electiveResponse;
    }

    @Override
    public List<ElectiveResponse> getAllElectives() {
        return electiveService.getAllElectives().stream().map(elective -> {
            LecturerResponse lecturerResponse = lecturerMapper.toResponse(elective.getAuthor());
            ElectiveResponse electiveResponse = electiveMapper.toResponse(elective);
            electiveResponse.setLecturer(lecturerResponse);
            return electiveResponse;
        }).toList();
    }

    @Override
    public ElectiveResponse updateElective(UUID id, ElectiveRequest electiveRequest) {

        Elective elective = electiveMapper.fromRequest(electiveRequest);

        elective.setAuthor(lecturerService.getLecturerById(electiveRequest.getAuthorId()));

        LecturerResponse lecturerResponse = lecturerMapper.toResponse(elective.getAuthor());

        ElectiveResponse electiveResponse = electiveMapper.toResponse(electiveService.updateElective(id, elective));
        electiveResponse.setLecturer(lecturerResponse);

        return electiveResponse;
    }

    @Override
    public void deleteElective(UUID id) {
        electiveService.deleteElective(id);
    }
}
