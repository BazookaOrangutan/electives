package com.example.electives.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class LecturerRequest {

    @NotBlank
    @Schema(description = "ФИО преподавателя", example = "Иванов Иван Иванович")
    private String name;

    @Schema(description = "Фото в формате base64", example = "/9j/4AAQSkZJRgABAQAAAQAB...")
    private String photo;

    @Schema(description = "Научная степень", example = "Кандидат экономических наук")
    private String scientificDegree;

    @Schema(description = "Ученое звание", example = "Доцент")
    private String academicTitle;

    @Schema(description = "Опыт", example = "17")
    private Integer experience;

    @Schema(description = "Опыт по специальности", example = "17")
    private Integer specialtyExperience;

    @Schema(description = "email", example = "example@mail.ru")
    private String email;

    @Schema(description = "Номер телефона", example = "+7 931 123-74-32")
    private String phone;

    @Schema(description = "Рабочий адрес", example = "Пл. Гагарина, 1, ауд. 1-256")
    private String address;

    @Schema(description = "Список образовний", example = "[\"обраование 1\", \"образование 2\"]")
    private List<String> educations;

    @Schema(description = "Список должностей", example = "[\"Начальник отдела ядерной программы \", \"Доцент кафедры медиатехнологий\"]")
    private List<String> jobTitles;

    @Schema(description = "Список различной работы с датами выполняемой в университете", example = "[\"2022 г - Начальник...\", \"2023г - ...\"]")
    private List<String> jobsInUniversity;

    @Schema(description = "Список преподаваемых дисциплин", example = "[\"Мат анализ\", \"ООП на С++\"]")
    private List<String> disciplines;

    @Schema(description = "Список данных о повышении квалификации и проф подгоотовки", example = "[\"Дата - описание\", \"Дата - описание\"]")
    private List<String> profTrainings;

    @Schema(description = "Список научных интересов", example = "[\"Стартап-проекты\", \"computer science\"]")
    private List<String> scienceInterests;

    @Schema(description = "Список данных о профессиональном опыте", example = "[\"2018-2025гг ассистент кафедры... \", \"...\"]")
    private List<String> profExperience;

    @Schema(description = "Список научных работ и публикаций", example = "[\"Навзание, дата, издание\", \"Название, дата, издание\"]")
    private List<String> scientificWorks;
}
