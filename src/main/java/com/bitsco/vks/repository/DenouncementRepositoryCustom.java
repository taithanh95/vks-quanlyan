package com.bitsco.vks.repository;

import com.bitsco.vks.dto.DenouncementDTO;

import com.bitsco.vks.entity.Denouncement;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface DenouncementRepositoryCustom {

    List<Object[]> getLstDenounce(DenouncementDTO denouncementDTO, boolean count, Pageable pageable);

    Long getDenounceCodeInYear(int year);

    Optional<Denouncement> findByIdCustom(@Param("id") Long id);

    Integer getDefaultLevelShareInfoBySppId(String sppId);
}
