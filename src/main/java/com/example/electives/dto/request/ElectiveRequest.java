package com.example.electives.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.UUID;

@Data
public class ElectiveRequest {

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

    @Schema(description = "Активен на данный момент ли электив", example = "true")
    private Boolean active;

    @Schema(description = "Порядковый номер электива на странице", example = "2")
    private Integer sortOrder;

    @Schema(description = "Уникальный идетификатор автора электива", example = "165abbd4-de3e-47f3-8429-938559e3586a")
    private UUID authorId;
}
