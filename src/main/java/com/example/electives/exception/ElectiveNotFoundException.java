package com.example.electives.exception;

import java.util.UUID;

public class ElectiveNotFoundException extends RuntimeException {
    public ElectiveNotFoundException(UUID id) {
        super("Elective not found with id " + id);
    }
}
