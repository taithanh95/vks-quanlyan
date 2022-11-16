package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SettlementDecision;
import com.bitsco.vks.entity.VerificationInvestigation;
import com.bitsco.vks.repository.VerificationInvestigationRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class VerificationInvestigationRepositoryImpl implements VerificationInvestigationRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<List<VerificationInvestigation>> findByIdCustom(Long id) {
        String queryStr = "SELECT d FROM VerificationInvestigation d where d.denouncementId= ?1 and d.status = 1";
        TypedQuery<VerificationInvestigation> settlementDecisionTypedQuery =
                this.em.createQuery(queryStr, VerificationInvestigation.class);
        List<VerificationInvestigation> verificationInvestigations = settlementDecisionTypedQuery.setParameter(1,id).getResultList();
        return Optional.of(verificationInvestigations);
    }
}
