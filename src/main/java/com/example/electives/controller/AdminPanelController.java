package com.example.electives.controller;

import com.example.electives.service.ElectiveService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import static com.example.electives.constant.EndpointConstants.URL_ADMIN_PANEL_API;

@Controller
@RequestMapping(URL_ADMIN_PANEL_API)
@RequiredArgsConstructor
public class AdminPanelController {

    private final ElectiveService electiveService;

    @GetMapping("/electives")
    public String electives(Model model) {
        model.addAttribute("electives", electiveService.getAllElectives());
        return "admin/electives";
    }



}
