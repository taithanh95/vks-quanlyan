package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.ApParamDTO;
import com.bitsco.vks.entity.ApParam;
import com.bitsco.vks.repository.ApParamRepository;
import com.bitsco.vks.service.ApPramService;
import com.bitsco.vks.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApPramServiceImpl implements ApPramService {

    @Autowired
    private ApParamRepository apParamRepository;

    @Override
    public List<ApParamDTO> findApParamsByParamCodeAndStatus(String code) {
        List<ApParamDTO> list = new ArrayList<>();
        List<ApParam> apParamList = apParamRepository.findApParamsByParamCodeAndStatus(code, Constants.STATUS_ACTIVE);
        if (apParamList != null && !apParamList.isEmpty())
            apParamList.forEach(apParam -> {
                ApParamDTO apParamDTO = new ApParamDTO();
                apParamDTO.setId(apParam.getId());
                apParamDTO.setParamCode(apParam.getParamCode());
                apParamDTO.setParamName(apParam.getParamName());
                apParamDTO.setParamValue(apParam.getParamValue());
                apParamDTO.setCreateUser(apParam.getCreateUser());
                apParamDTO.setCreateDate(apParam.getCreateDate());
                apParamDTO.setUpdateUser(apParam.getUpdateUser());
                apParamDTO.setUpdateDate(apParam.getUpdateDate());
                apParamDTO.setStatus(apParam.getStatus());

                list.add(apParamDTO);
            });
        return list;
    }
}
