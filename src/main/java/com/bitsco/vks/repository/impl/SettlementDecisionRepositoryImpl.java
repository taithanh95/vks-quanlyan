package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.InvestigationActivity;
import com.bitsco.vks.entity.SettlementDecision;
import com.bitsco.vks.repository.SettlementDecisionRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class SettlementDecisionRepositoryImpl implements SettlementDecisionRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<List<SettlementDecision>> findByIdCustom(Long id) {
        String queryStr = "SELECT d FROM SettlementDecision d where d.denouncementId= ?1 and d.status = 1";
        TypedQuery<SettlementDecision> settlementDecisionTypedQuery =
                this.em.createQuery(queryStr, SettlementDecision.class);
        List<SettlementDecision> settlementDecisions = settlementDecisionTypedQuery.setParameter(1,id).getResultList();
        return Optional.of(settlementDecisions);
    }
}
