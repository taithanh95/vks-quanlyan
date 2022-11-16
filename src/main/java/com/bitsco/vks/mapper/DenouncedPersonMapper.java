package com.bitsco.vks.mapper;

import com.bitsco.vks.dto.DenouncedPersonDTO;
import com.bitsco.vks.dto.DenouncementDTO;
import com.bitsco.vks.entity.DenouncedPerson;
import com.bitsco.vks.entity.Denouncement;
import com.bitsco.vks.mapper.annotation.FullMapping;
import com.bitsco.vks.mapper.annotation.PureMapping;
import java.util.List;

import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class DenouncedPersonMapper {

    @PureMapping
    public abstract DenouncedPersonDTO entityToDto(
        DenouncedPerson denouncedPerson);

    @PureMapping
    public abstract DenouncedPerson dtoToEntity(DenouncedPersonDTO denouncedPerson);

    @PureMapping
    public abstract List<DenouncedPersonDTO> entityToDtoList(
        List<DenouncedPerson> denouncedPersonList);

    @PureMapping
    public abstract List<DenouncedPerson> dtoToEntityList(
        List<DenouncedPersonDTO> denouncedPersonList);

    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<DenouncedPersonDTO> entityToDtoListFetchAll(
            List<DenouncedPerson> denouncedPersonList);
}
