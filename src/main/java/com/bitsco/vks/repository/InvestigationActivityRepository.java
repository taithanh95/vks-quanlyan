package com.bitsco.vks.repository;

import com.bitsco.vks.entity.InvestigationActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvestigationActivityRepository extends JpaRepository<InvestigationActivity, Long> ,InvestigationActivityRepositoryCustom {

}
