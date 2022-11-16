package com.bitsco.vks.repository;

import com.bitsco.vks.dto.RegisterDecisionCaseListResponse;
import com.bitsco.vks.models.RegisterDecisionCaseSearchRequest;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.request.RegisterDecisionCaseSeqRequest;
import com.bitsco.vks.request.SppRequest;
import com.bitsco.vks.response.PageResponse;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface RegisterDecisionCaseRepository {

    List<RegisterDecisionCaseListResponse> findAll(RegisterDecisionCaseSearchRequest request);

    RegisterDecisionCaseListResponse findByCaseCode(String caseCode);

    long count(RegisterDecisionCaseSearchRequest request) throws Exception;

    List<Map<String, Object>> findDeciIdAndDeciNameByDeciName(String query) throws Exception;

    int saveOrUpdate(RegisterDecisionCaseRequest request) throws ParseException, Exception;

    int getSequenceNumber(RegisterDecisionCaseSeqRequest request) throws ParseException, Exception;

    boolean existsRegisterDecisionByCaseCodeAndSppIdAndDeciIdAndInDate(RegisterDecisionCaseRequest request) throws ParseException, Exception;

    boolean existsBySetNumAndSppIdAndCaseCodeAndInDate(RegisterDecisionCaseRequest request) throws Exception;

    Map<String, Object> getLstSpp(SppRequest sppId);

    int insertOrUpdateSeq(RegisterDecisionCaseRequest request) throws Exception;

    boolean checkStatusRegister(RegisterDecisionCaseRequest request);
}
