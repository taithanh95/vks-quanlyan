package com.bitsco.vks.mapper;

import com.bitsco.vks.dto.SettlementDecisionDTO;
import com.bitsco.vks.entity.SettlementDecision;
import com.bitsco.vks.mapper.annotation.FullMapping;
import com.bitsco.vks.mapper.annotation.PureMapping;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class SettlementDecisionMapper {

    @PureMapping
    public abstract SettlementDecisionDTO entityToDto(SettlementDecision settlementDecision);

    @PureMapping
    public abstract SettlementDecision dtoToEntity(SettlementDecisionDTO settlementDecision);

    @PureMapping
    public abstract List<SettlementDecisionDTO> entityToDtoList(
        List<SettlementDecision> settlementDecisionList);

    @PureMapping
    public abstract List<SettlementDecision> dtoToEntityList(
        List<SettlementDecisionDTO> settlementDecisionList);

    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<SettlementDecisionDTO> entityToDtoListFetchAll(
            List<SettlementDecision> settlementDecisionList);
}
