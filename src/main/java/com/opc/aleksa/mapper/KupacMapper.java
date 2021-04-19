package com.opc.aleksa.mapper;

import com.opc.aleksa.dto.KupacDto;
import com.opc.aleksa.model.Kupac;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {GradMapper.class,KarticaMapper.class})
public interface KupacMapper {
    KupacDto toDto(Kupac kupac);

    @InheritInverseConfiguration
    Kupac toEntity(KupacDto kupacDto);

    List<KupacDto> toDtoList(List<Kupac> list);

    @InheritInverseConfiguration
    List<Kupac> toEntityList(List<KupacDto> list);
}
