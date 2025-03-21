package com.example.electives.controller;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.model.Lecturer;
import com.example.electives.service.ElectiveService;
import com.example.electives.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static com.example.electives.constant.EndpointConstants.URL_ADMIN_PANEL_API;

@Controller
@RequestMapping(URL_ADMIN_PANEL_API)
@RequiredArgsConstructor
public class AdminPanelController {

    private final ElectiveService electiveService;
    private final LecturerService lecturerService;
    private final ElectiveController electiveController;

    @GetMapping("/electives")
    public String electives(Model model) {
        model.addAttribute("electives", electiveService.getAllElectives());
        return "admin/electives";
    }

    @GetMapping("/lecturers")
    public String lecturers(Model model) {
        model.addAttribute("lecturers", lecturerService.getAllLecturers());
        model.addAttribute("service", electiveService);
        return "admin/lecturers";
    }

    @GetMapping("/electives/new")
    public String showElectiveCreateForm(Model model) {
        // Передаем пустой объект ElectiveRequest в форму
        model.addAttribute("electiveRequest", new ElectiveRequest());

        // Получаем список лекторов и передаем его в форму
        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        model.addAttribute("lecturers", lecturers);

        return "admin/add-elective"; // Имя шаблона
    }

    @GetMapping("/lecturer/new")
    public String showLecturerCreateForm(Model model) {
        return "admin/add-lecturer"; // Имя шаблона
    }

}
