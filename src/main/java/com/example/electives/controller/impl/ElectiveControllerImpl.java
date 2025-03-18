package com.example.electives.controller.impl;

import com.example.electives.controller.ElectiveController;
import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.mapper.ElectiveMapper;
import com.example.electives.model.Elective;
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

    @Override
    public Elective createElective(ElectiveRequest electiveRequest) {

        Elective elective = electiveMapper.fromRequest(electiveRequest);

        elective.setAuthor(lecturerService.getLecturerById(electiveRequest.getAuthorId()));

        return electiveService.createElective(elective);
    }

    @Override
    public Elective getElectiveById(UUID id) {
        return electiveService.getElective(id);
    }

    @Override
    public List<Elective> getAllElectives() {
        return electiveService.getAllElectives();
    }

    @Override
    public Elective updateElective(UUID id, ElectiveRequest electiveRequest) {
        return null;
    }

    @Override
    public void deleteElective(UUID id) {
        electiveService.deleteElective(id);
    }
}
