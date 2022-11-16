package com.bitsco.vks.repository;

import com.bitsco.vks.entity.VerificationInvestigation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationInvestigationRepository extends JpaRepository<VerificationInvestigation, Long>,VerificationInvestigationRepositoryCustom {

}
