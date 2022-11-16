package com.bitsco.vks.repository;

import com.bitsco.vks.dto.RegisterDecisionListResponse;
import com.bitsco.vks.models.RegisterDecisionResponse;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;

import java.util.List;

public interface RegisterDecisionRepository {

    List<RegisterDecisionListResponse> findAllByCaseCodeAndSppId(RegisterDecisionCaseRequest request);

    RegisterDecisionResponse findById(Long id);

    int deleteById(Long id, String mdfuser);

    List<RegisterDecisionListResponse> findAll(RegisterDecisionCaseRequest request);

}
