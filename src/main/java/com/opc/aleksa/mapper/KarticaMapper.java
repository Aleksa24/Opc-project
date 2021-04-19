package com.opc.aleksa.mapper;

import com.opc.aleksa.dto.KarticaDto;
import com.opc.aleksa.model.Kartica;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {GradMapper.class})
public interface KarticaMapper {
    KarticaDto toDto(Kartica kartica);

    @InheritInverseConfiguration
    Kartica toEntity(KarticaDto karticaDto);

    List<KarticaDto> toDtoList(List<Kartica> list);

    @InheritInverseConfiguration
    List<Kartica> toEntityList(List<KarticaDto> list);
}
