package com.bitsco.vks.repository;

import com.bitsco.vks.entity.VerificationInvestigation;

import java.util.List;
import java.util.Optional;

public interface VerificationInvestigationRepositoryCustom {
    Optional<List<VerificationInvestigation>> findByIdCustom(Long id);

}
