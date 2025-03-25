package com.example.electives.controller;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.response.ElectiveResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Tag(name = "Elective Controller", description = "Контроллер для управления элективами")
public interface ElectiveController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создание электива", description = "Позволяет создать электив с предоставленными данными")
    ElectiveResponse createElective(@io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные о элективе для создания",
            required = true,
            content = @Content(schema = @Schema(implementation = ElectiveRequest.class))
    ) @Valid @RequestBody ElectiveRequest electiveRequest);

    @GetMapping("{id}")
    @Operation(summary = "Получение электива", description = "Позволяет получить электив по его уникальному идентификатору")
    ElectiveResponse getElectiveById(@Parameter(description = "Уникальный идентификатор электива", required = true)
                                     @PathVariable UUID id);

    @GetMapping
    @Operation(summary = "Получение всех элективов", description = "Позволяет получить список всех элективов")
    List<ElectiveResponse> getAllElectives();

    @PutMapping("{id}")
    @Operation(summary = "Обновление электива", description = "Позволяет обновить электив")
    ElectiveResponse updateElective(@Parameter(description = "Уникальный идентификатор электива", required = true)
                                    @PathVariable UUID id,
                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                            description = "Данные о элективе для создания",
                                            required = true,
                                            content = @Content(schema = @Schema(implementation = ElectiveRequest.class))
                                    ) @Valid @RequestBody ElectiveRequest electiveRequest);

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Удаление электива", description = "Позволяет удалить электив по его уникальному идентификатору")
    void deleteElective(@Parameter(description = "Уникальный идентификатор электива", required = true)
                        @PathVariable UUID id);

    @GetMapping("search")
    @Operation(summary = "Поиск элективов", description = "Позволяет получить элективы по их названию и фио автора ")
    List<ElectiveResponse> searchElective(@Parameter(description = "ФИО автора", required = true)
                                          @RequestParam String author,
                                          @Parameter(description = "Название электива", required = true)
                                          @RequestParam String elective);

    @PatchMapping("{id}/active")
    @Operation(summary = "Изменение активности электива", description = "Позволяет выбрать активен ли в данный момент электив или нет ")
    void updateElectiveActiveStatus(@Parameter(description = "Уникальный идентификатор электива", required = true)
                                    @PathVariable UUID id,
                                    @io.swagger.v3.oas.annotations.parameters.RequestBody(
                                            description = "JSON вида {active : true/false}",
                                            required = true
                                    ) @RequestBody Map<String, Boolean> status);
}
