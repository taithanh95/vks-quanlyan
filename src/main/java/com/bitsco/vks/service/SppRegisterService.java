package com.bitsco.vks.service;

import com.bitsco.vks.dto.SppRegisterSearchDTO;
import com.bitsco.vks.entity.SppRegister;
import com.bitsco.vks.models.GetSppRegisterRequest;
import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppRegisterSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppRegisterService {
    List<LinkedCaseInsensitiveMap> search(SppRegisterSearchRequest request, Pageable pageable);
//    SppRegister GetSppRegister(String casecode, String usefor, String sppid);
    String SaveSppRegister(SaveSppRegisterRequest request);
    String delete(String regicode);
    String checkRegisterable(String casecode, String usefor, String sppid);
}
