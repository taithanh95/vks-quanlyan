package com.bitsco.vks.mapper;

import com.bitsco.vks.dto.VerificationInvestigationDTO;
import com.bitsco.vks.entity.VerificationInvestigation;
import com.bitsco.vks.mapper.annotation.FullMapping;
import com.bitsco.vks.mapper.annotation.PureMapping;
import java.util.List;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public abstract class VerificationInvestigationMapper {

    @PureMapping
    public abstract VerificationInvestigationDTO entityToDto(
        VerificationInvestigation verificationInvestigation);

    @PureMapping
    public abstract VerificationInvestigation dtoToEntity(
        VerificationInvestigationDTO verificationInvestigation);

    @PureMapping
    public abstract List<VerificationInvestigationDTO> entityToDtoList(
        List<VerificationInvestigation> verificationInvestigationList);

    @PureMapping
    public abstract List<VerificationInvestigation> dtoToEntityList(
        List<VerificationInvestigationDTO> verificationInvestigationList);

    @IterableMapping(qualifiedBy = {FullMapping.class})
    public abstract List<VerificationInvestigationDTO> entityToDtoListFetchAll(
            List<VerificationInvestigation> verificationInvestigations);
}
