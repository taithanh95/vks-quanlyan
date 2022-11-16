package com.bitsco.vks.mapper;

import com.bitsco.vks.dto.InvestigationActivityDTO;
import com.bitsco.vks.entity.InvestigationActivity;
import com.bitsco.vks.mapper.annotation.FullMapping;
import com.bitsco.vks.mapper.annotation.PureMapping;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class InvestigationActivityMapper {

    @PureMapping
    public abstract InvestigationActivityDTO entityToDto(
        InvestigationActivity investigationActivity);

    @PureMapping
    public abstract InvestigationActivity dtoToEntity(
        InvestigationActivityDTO investigationActivity);

    @PureMapping
    public abstract List<InvestigationActivityDTO> entityToDtoList(
        List<InvestigationActivity> investigationActivityList);

    @PureMapping
    public abstract List<InvestigationActivity> dtoToEntityList(
        List<InvestigationActivityDTO> investigationActivityList);

    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<InvestigationActivityDTO> entityToDtoListFetchAll(
            List<InvestigationActivity> investigationActivities);
}
