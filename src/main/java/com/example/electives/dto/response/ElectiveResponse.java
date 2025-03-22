package com.example.electives.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ElectiveResponse {

    @Schema(description = "Уникальный идентификатор электива", example = "3fa85f64-5717-4562-b3fc-2c963f66afa6")
    private UUID id;

    @Schema(description = "Название электива", example = "Основы веб разработки")
    private String title;

    @Schema(description = "Описание электива", example = "Эелектив представляет собой ...")
    private String description;

    @Schema(description = "Место проведения", example = "Гл Корпус, Площадь Гагарина 1")
    private String place;

    @Schema(description = "Вид контроля", example = "зачет")
    private String controlType;

    @Schema(description = "Формат проведения", example = "онлайн")
    private String format;

    @Schema(description = "Трудоемкость, ЗЕ", example = "2")
    private String intensity;

    @Schema(description = "Автор(преподаватель) электива в виде объекта")
    private LecturerResponse lecturer;
}
