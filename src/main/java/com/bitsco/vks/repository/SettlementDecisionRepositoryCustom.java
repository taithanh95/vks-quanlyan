package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SettlementDecision;

import java.util.List;
import java.util.Optional;

public interface SettlementDecisionRepositoryCustom {
    Optional<List<SettlementDecision>> findByIdCustom(Long id);
}
