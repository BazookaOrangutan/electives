package com.example.electives.dto.request;

import com.example.electives.model.Lecturer;
import lombok.Data;

import java.util.UUID;

@Data
public class ElectiveRequest {

    private String title;
    private String description;
    private String place;
    private String controlType;
    private String format;
    private String intensity;
    private UUID authorId;
}
