package com.bitsco.vks.service;

import com.bitsco.vks.dto.RegisterDecisionListResponse;
import com.bitsco.vks.models.RegisterDecisionResponse;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;

import java.util.List;

public interface RegisterDecisionService {

    List<RegisterDecisionListResponse> findAllByCaseCodeAndSppId(RegisterDecisionCaseRequest request);

    RegisterDecisionResponse findById(Long id);

    int deleteById(Long id, String mdfuser) throws Exception;

    List<RegisterDecisionListResponse> findAll(RegisterDecisionCaseRequest request);
}
