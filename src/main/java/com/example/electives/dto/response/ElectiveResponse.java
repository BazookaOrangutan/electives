package com.example.electives.dto.response;

import lombok.Data;

import java.util.UUID;

@Data
public class ElectiveResponse {

    private UUID id;
    private String title;
    private String description;
    private String place;
    private String controlType;
    private String format;
    private String intensity;
    private LecturerResponse lecturer;
}
