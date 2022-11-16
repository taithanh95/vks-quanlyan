package com.bitsco.vks.mapper;

import com.bitsco.vks.dto.DenouncementDTO;
import com.bitsco.vks.entity.Denouncement;
import com.bitsco.vks.mapper.annotation.FullMapping;
import com.bitsco.vks.mapper.annotation.PureMapping;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring", uses = {DenouncedPersonMapper.class,
    InvestigationActivityMapper.class,
    SettlementDecisionMapper.class, VerificationInvestigationMapper.class})
public abstract class DenouncementMapper {

    @FullMapping
    @Mappings({
        @Mapping(target = "denouncedPeople", qualifiedBy = {PureMapping.class}),
        @Mapping(target = "investigationActivities", qualifiedBy = {PureMapping.class}),
        @Mapping(target = "settlementDecisions", qualifiedBy = {PureMapping.class}),
        @Mapping(target = "verificationInvestigations", qualifiedBy = {PureMapping.class}),
    })
    public abstract DenouncementDTO entityToDtoFetchAll(Denouncement denouncement);

    @PureMapping
    @Mappings({
        @Mapping(target = "denouncedPeople", ignore = true),
        @Mapping(target = "investigationActivities", ignore = true),
        @Mapping(target = "settlementDecisions", ignore = true),
        @Mapping(target = "verificationInvestigations", ignore = true),
    })
    public abstract DenouncementDTO entityToDtoFetchNone(Denouncement denouncement);

    public abstract Denouncement dtoToEntityFetch(DenouncementDTO denouncement);

    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<DenouncementDTO> entityToDtoListFetchAll(
        List<Denouncement> denouncementList);

    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<DenouncementDTO> entityToDtoListFetchNone(
        List<Denouncement> denouncementList);

    @IterableMapping(qualifiedBy = {PureMapping.class})
    public abstract List<Denouncement> dtoToEntityList(List<DenouncementDTO> denouncementList);
}
