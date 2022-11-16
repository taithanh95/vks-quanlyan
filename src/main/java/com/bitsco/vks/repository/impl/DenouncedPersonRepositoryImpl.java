package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.DenouncedPerson;
import com.bitsco.vks.repository.DenouncedPersonRepositoryCustom;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@Repository
public class DenouncedPersonRepositoryImpl implements DenouncedPersonRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Optional<List<DenouncedPerson>> findByIdCustom(Long id) {
        String queryStr = "SELECT d FROM DenouncedPerson d where d.denouncementId= ?1 and d.status = 1";
        TypedQuery<DenouncedPerson> denouncementPersonTypedQuery =
                this.em.createQuery(queryStr, DenouncedPerson.class);
        List<DenouncedPerson> denouncedPerson = denouncementPersonTypedQuery.setParameter(1,id).getResultList();
        return Optional.of(denouncedPerson);
    }
}
