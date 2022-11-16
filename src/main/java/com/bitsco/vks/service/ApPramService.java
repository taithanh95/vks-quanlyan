package com.bitsco.vks.service;

import com.bitsco.vks.dto.ApParamDTO;
import com.bitsco.vks.entity.ApParam;

import java.util.List;

public interface ApPramService {

    List<ApParamDTO> findApParamsByParamCodeAndStatus(String code);

}
