package com.bitsco.vks.repository;

import com.bitsco.vks.dto.SppRegisterSearchDTO;
import com.bitsco.vks.entity.SppCase;
import com.bitsco.vks.entity.SppRegister;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppRegisterRepository {
//    List<SppRegister> search(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode,
//                             String usefor, String sppid);
    List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode,
                                          String usefor, String sppid);
    String insertUpdate(SppRegister ac, SppCase ca, String sppId, String userId);
    String delete(String regicode);
    String checkRegisterable(String casecode, String usefor, String sppid);
}
