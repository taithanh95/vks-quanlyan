package com.bitsco.vks.service;

import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppSpcPolSaveRequest;
import com.bitsco.vks.models.SppSpcPolSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSpcPolService {
    List<LinkedCaseInsensitiveMap> search(SppSpcPolSearchRequest request, Pageable pageable);
    String SaveSppSpcPol(SppSpcPolSaveRequest request);
}
