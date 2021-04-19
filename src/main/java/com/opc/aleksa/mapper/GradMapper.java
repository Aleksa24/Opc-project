package com.opc.aleksa.mapper;

import com.opc.aleksa.dto.GradDto;
import com.opc.aleksa.model.Grad;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GradMapper {
    GradDto toDto(Grad grad);

    @InheritInverseConfiguration
    Grad toEntity(GradDto gradDto);

    List<GradDto> toDtoList(List<Grad> list);

    @InheritInverseConfiguration
    List<Grad> toEntityList(List<GradDto> list);
}
