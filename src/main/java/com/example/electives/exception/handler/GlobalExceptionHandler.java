package com.example.electives.exception.handler;

import com.example.electives.exception.ElectiveNotFoundException;
import com.example.electives.exception.LecturerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ElectiveNotFoundException.class})
    public ResponseEntity<String> handleElectiveNotFoundException(ElectiveNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler({LecturerNotFoundException.class})
    public ResponseEntity<String> handleLecturerNotFoundException(LecturerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }
}
