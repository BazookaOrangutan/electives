package com.example.electives.controller;

import com.example.electives.dto.request.LecturerRequest;
import com.example.electives.dto.response.LecturerResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Lecturer Controller", description = "Контроллер для управления преподавателями")
public interface LecturerController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание преподавателя", description = "Позволяет создать преподавателя с предоставленными данными")
    LecturerResponse createLecturer(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные о преподавателе для создания",
            required = true,
            content = @Content(schema = @Schema(implementation = LecturerRequest.class))
    ) @Valid @RequestBody LecturerRequest lecturerRequest);

    @GetMapping("{id}")
    @Operation(summary = "Получение преподавателя", description = "Позволяет получить преподавателя по его уникальному идентификатору")
    LecturerResponse getLecturerById(@Parameter(description = "Уникальный идентификатор преподавателя", required = true)
                                     @PathVariable UUID id);

    @GetMapping
    @Operation(summary = "Получение всех преподавателей", description = "Позволяет получить список всех преподавателей")
    List<LecturerResponse> getAllLecturers();

    @PutMapping("{id}")
    @Operation(summary = "Обновление преподавателя", description = "Позволяет обновить преподавателя")
    LecturerResponse updateLecturer(@Parameter(description = "Уникальный идентификатор преподавателя", required = true)
                                    @PathVariable UUID id,
                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                            description = "Данные о преподавателе для создания",
                                            required = true,
                                            content = @Content(schema = @Schema(implementation = LecturerRequest.class))
                                    ) @Valid @RequestBody LecturerRequest lecturerRequest);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление преподавателя", description = "Позволяет удалить преподавателя по еге уникальному идентификатору")
    void deleteLecturer(@Parameter(description = "Уникальный идентификатор преподавателя", required = true)
                        @PathVariable UUID id);

}
