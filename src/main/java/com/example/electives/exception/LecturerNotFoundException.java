package com.example.electives.exception;

import java.util.UUID;

public class LecturerNotFoundException extends RuntimeException {
    public LecturerNotFoundException(UUID id) {
        super("Lecturer not found with id " + id);
    }
}
