package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.RegisterDecisionListResponse;
import com.bitsco.vks.exception.CommonException;
import com.bitsco.vks.models.RegisterDecisionResponse;
import com.bitsco.vks.repository.RegisterDecisionRepository;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.service.RegisterDecisionService;
import com.bitsco.vks.validate.ValidateCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterDecisionServiceImpl implements RegisterDecisionService {

    @Autowired
    private RegisterDecisionRepository registerDecisionRepository;

    @Override
    public List<RegisterDecisionListResponse> findAllByCaseCodeAndSppId(RegisterDecisionCaseRequest request) {
        return registerDecisionRepository.findAllByCaseCodeAndSppId(request);
    }

    @Override
    public RegisterDecisionResponse findById(Long id) {
        ValidateCommon.validateNullObject(id, "id");
        return registerDecisionRepository.findById(id);
    }

    @Override
    public int deleteById(Long id, String mdfuser) throws Exception {
        ValidateCommon.validateNullObject(id, "id");
        ValidateCommon.validateNullObject(mdfuser, "mdfuser");
        if (!"admin".equalsIgnoreCase(mdfuser)) {
            throw new Exception("Bạn không có quyền thực hiện chức năng này!");
        }
        return registerDecisionRepository.deleteById(id, mdfuser);
    }

    @Override
    public List<RegisterDecisionListResponse> findAll(RegisterDecisionCaseRequest request) {
        return registerDecisionRepository.findAll(request);
    }
}
