package com.example.electives.mapper;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.dto.response.ElectiveResponse;
import com.example.electives.model.Elective;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ElectiveMapper {

    ElectiveResponse toResponse(Elective elective);

    Elective fromRequest(ElectiveRequest request);

    @AfterMapping
    default void setActive(@MappingTarget ElectiveResponse electiveResponse, Elective elective) {
        electiveResponse.setActive(elective.getActive());
    }
}
