package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SettlementDecision;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SettlementDecisionRepository extends JpaRepository<SettlementDecision, Long> ,SettlementDecisionRepositoryCustom{

}
