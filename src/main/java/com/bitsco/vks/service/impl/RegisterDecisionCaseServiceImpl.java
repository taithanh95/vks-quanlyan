package com.bitsco.vks.service.impl;

import com.bitsco.vks.constant.MessageContent;
import com.bitsco.vks.dto.RegisterDecisionCaseListResponse;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.models.RegisterDecisionCaseSearchRequest;
import com.bitsco.vks.repository.RegisterDecisionCaseRepository;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.request.RegisterDecisionCaseSeqRequest;
import com.bitsco.vks.request.SppRequest;
import com.bitsco.vks.response.PageResponse;
import com.bitsco.vks.response.Response;
import com.bitsco.vks.service.RegisterDecisionCaseService;
import com.bitsco.vks.utils.ArrayListCommon;
import com.bitsco.vks.utils.MapCommon;
import com.bitsco.vks.utils.MessageCommon;
import com.bitsco.vks.validate.ValidateCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class RegisterDecisionCaseServiceImpl implements RegisterDecisionCaseService {

    @Autowired
    private RegisterDecisionCaseRepository registerDecisionCaseRepository;

    @Override
    public PageResponse findAll(RegisterDecisionCaseSearchRequest request) throws Exception {
        List<RegisterDecisionCaseListResponse> responseList = registerDecisionCaseRepository.findAll(request);
        PageResponse pageResponse = new PageResponse();
        pageResponse.setPageNumber(request.getPageIndex());
        pageResponse.setPageSize(request.getPageSize());
        if (ArrayListCommon.isNullOrEmpty(responseList)) {
            pageResponse.setTotalElements(0);
            pageResponse.setTotalPages(0);
            pageResponse.setData(new ArrayList());
        } else {
            pageResponse.setTotalElements(this.count(request));
            double totalElements = pageResponse.getTotalElements();
            double totalPages = pageResponse.getPageSize();
            pageResponse.setTotalPages((int) Math.ceil(totalElements / totalPages));
            pageResponse.setData(responseList);
        }
        return pageResponse;
    }

    @Override
    public RegisterDecisionCaseListResponse findByCaseCode(String caseCode) throws Exception {
        ValidateCommon.validateNullObject(caseCode, "caseCode");
        return registerDecisionCaseRepository.findByCaseCode(caseCode);
    }

    @Override
    public long count(RegisterDecisionCaseSearchRequest request) throws Exception {
        return registerDecisionCaseRepository.count(request);
    }

    @Override
    public List<Map<String, Object>> findDeciIdAndDeciNameByDeciName(String query) throws Exception {
        return registerDecisionCaseRepository.findDeciIdAndDeciNameByDeciName(query);
    }

    @Override
    public int saveOrUpdate(RegisterDecisionCaseRequest request) throws Exception {
        ValidateCommon.validateNullObject(request.getUserFor(), "USERFOR");
        ValidateCommon.validateNullObject(request.getInDate(), "INDATE");
        ValidateCommon.validateNullObject(request.getDeciId(), "DECIID");
        ValidateCommon.validateNullObject(request.getSppId(), "SPPID");
        ValidateCommon.validateNullObject(request.getSetNumReality(), "SETNUM");
        ValidateCommon.validateNullObject(request.getCaseCode(), "CASECODE");
        if (registerDecisionCaseRepository.saveOrUpdate(request) > 0) {
            return registerDecisionCaseRepository.insertOrUpdateSeq(request);
        }
        return -1;
    }

    @Override
    public int getSequenceNumber(RegisterDecisionCaseSeqRequest request) throws Exception {
        ValidateCommon.validateNullObject(request.getDeciId(), "DECIID");
        ValidateCommon.validateNullObject(request.getSppId(), "SPPID");
        ValidateCommon.validateNullObject(request.getCaseCode(), "CASECODE");
        ValidateCommon.validateNullObject(request.getLastUpdate(), "LAST_UPDATE");
        return registerDecisionCaseRepository.getSequenceNumber(request);
    }

    @Override
    public boolean isRegisterDecisionByDeciIdAndDateExists(RegisterDecisionCaseRequest request) throws Exception {
        return registerDecisionCaseRepository.existsRegisterDecisionByCaseCodeAndSppIdAndDeciIdAndInDate(request);
    }

    @Override
    public boolean existsBySetNumAndSppIdAndCaseCodeAndInDate(RegisterDecisionCaseRequest request) throws Exception {
        ValidateCommon.validateNullObject(request.getSetNum(), "SETNUM");
        ValidateCommon.validateNullObject(request.getCaseCode(), "SPPCASE");
        ValidateCommon.validateNullObject(request.getInDate(), "INDATE");
        return registerDecisionCaseRepository.existsBySetNumAndSppIdAndCaseCodeAndInDate(request);
    }

    @Override
    public Map<String, Object> getLstSpp(SppRequest lstSpp) throws Exception {
        ValidateCommon.validateNullObject(lstSpp.getSppId(), "sppId");
        ValidateCommon.validateNullObject(lstSpp.isIsdepart(), "isdepart");
        Map<String, Object> objectMap = registerDecisionCaseRepository.getLstSpp(lstSpp);
        if (MapCommon.isNullOrEmptyMap(objectMap)) {
            throw new CommonException(Response.OBJECT_IS_NULL, MessageCommon.getMessage(MessageContent.OBJECT_NOT_FOUND, lstSpp.getSppId()));
        }
        return objectMap;
    }

    @Override
    public boolean checkStatusRegister(RegisterDecisionCaseRequest request) {
        ValidateCommon.validateNullObject(request.getCaseCode(), "caseCode");
        ValidateCommon.validateNullObject(request.getUserFor(), "userFor");
        return registerDecisionCaseRepository.checkStatusRegister(request);
    }
}
