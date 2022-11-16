package com.bitsco.vks.repository;

import com.bitsco.vks.entity.InvestigationActivity;

import java.util.List;
import java.util.Optional;

public interface InvestigationActivityRepositoryCustom {
    Optional<List<InvestigationActivity>> findByIdCustom(Long id);
}
