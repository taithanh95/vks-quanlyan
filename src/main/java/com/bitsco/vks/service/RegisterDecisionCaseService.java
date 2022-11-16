package com.bitsco.vks.service;

import com.bitsco.vks.dto.RegisterDecisionCaseListResponse;
import com.bitsco.vks.models.RegisterDecisionCaseSearchRequest;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.request.RegisterDecisionCaseSeqRequest;
import com.bitsco.vks.request.SppRequest;
import com.bitsco.vks.response.PageResponse;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface RegisterDecisionCaseService {

    PageResponse findAll(RegisterDecisionCaseSearchRequest request) throws Exception;

    RegisterDecisionCaseListResponse findByCaseCode(String caseCode) throws Exception;

    long count(RegisterDecisionCaseSearchRequest request) throws Exception;

    List<Map<String, Object>> findDeciIdAndDeciNameByDeciName(String query) throws Exception;

    int saveOrUpdate(RegisterDecisionCaseRequest request) throws Exception;

    int getSequenceNumber(RegisterDecisionCaseSeqRequest request) throws Exception;

    boolean isRegisterDecisionByDeciIdAndDateExists(RegisterDecisionCaseRequest request) throws Exception;

    boolean existsBySetNumAndSppIdAndCaseCodeAndInDate(RegisterDecisionCaseRequest request) throws Exception;

    Map<String, Object> getLstSpp(SppRequest sppId) throws Exception;

    boolean checkStatusRegister(RegisterDecisionCaseRequest request);
}
