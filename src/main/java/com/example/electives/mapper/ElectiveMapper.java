package com.example.electives.mapper;

import com.example.electives.dto.request.ElectiveRequest;
import com.example.electives.model.Elective;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface ElectiveMapper {

    Elective fromRequest(ElectiveRequest request);
}
