package com.bitsco.vks.repository.impl;


import com.bitsco.vks.entity.DenouncedPerson;
import com.bitsco.vks.entity.InvestigationActivity;
import com.bitsco.vks.repository.InvestigationActivityRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class InvestigationActivityRepositoryImpl implements InvestigationActivityRepositoryCustom {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<List<InvestigationActivity>> findByIdCustom(Long id) {
        String queryStr = "SELECT d FROM InvestigationActivity d where d.denouncementId= ?1 and d.status = 1";
        TypedQuery<InvestigationActivity> investigationActivityTypedQuery =
                this.em.createQuery(queryStr, InvestigationActivity.class);
        List<InvestigationActivity> activities = investigationActivityTypedQuery.setParameter(1,id).getResultList();
        return Optional.of(activities);
    }
}
