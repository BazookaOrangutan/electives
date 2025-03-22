package com.example.electives.controller;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.mapper.LecturerMapper;
import com.example.electives.model.Elective;
import com.example.electives.model.Lecturer;
import com.example.electives.service.ElectiveService;
import com.example.electives.service.LecturerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.UUID;

import static com.example.electives.constant.EndpointConstants.URL_ADMIN_PANEL_API;

@Controller
@RequestMapping(URL_ADMIN_PANEL_API)
@RequiredArgsConstructor
public class AdminPanelController {

    private final ElectiveService electiveService;
    private final LecturerService lecturerService;

    private final LecturerMapper lecturerMapper;

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

    @GetMapping("/electives/delete/{id}")
    public String deleteElective(@PathVariable UUID id) {

        electiveService.deleteElective(id);
        return "redirect:/admin/electives"; // Перенаправление на страницу с элективами
    }

    @GetMapping("/lecturers/delete/{id}")
    public String deleteLecturer(@PathVariable UUID id, Model model) {

        if(lecturerService.hasElectives(id)){
            model.addAttribute("hasElectives", true);
            model.addAttribute("lecturerId", id);
            return "admin/confirm-delete";
        }
        lecturerService.deleteLecturer(id);
        return "redirect:/admin/lecturers"; // Перенаправление на страницу с элективами
    }

    @GetMapping("/lecturers/confirm-delete/{id}")
    public String confirmDeleteLecturer(@PathVariable UUID id) {

        lecturerService.deleteLecturerWithElectives(id);
        return "redirect:/admin/lecturers";
    }

    @GetMapping("/lecturers/edit/{id}")
    public String showLecturerEditForm(@PathVariable UUID id, Model model) {

        Lecturer lecturer = lecturerService.getLecturerById(id);
        model.addAttribute("lecturer", lecturer);

        return "admin/edit-lecturer";
    }

    @PostMapping("/lecturers/update/{id}")
    public String updateLecturer(@PathVariable UUID id, @RequestBody LecturerRequest lecturerRequest) {

        Lecturer lecturer = lecturerMapper.fromRequest(lecturerRequest);

        lecturerService.updateLecturer(id, lecturer);

        return "/admin/lecturers";
    }

    @GetMapping("/electives/edit/{id}")
    public String showElectiveEditForm(@PathVariable UUID id, Model model) {

        Elective elective = electiveService.getElective(id);
        model.addAttribute("elective", elective);

        List<Lecturer> lecturers = lecturerService.getAllLecturers();
        model.addAttribute("lecturers", lecturers);

        return "admin/edit-elective";
    }

    @PostMapping("/electives/update/{id}")
    public String updateElective(@PathVariable UUID id, @ModelAttribute Elective elective) {

        electiveService.updateElective(id, elective);

        return "redirect:/admin/electives";
    }
}
