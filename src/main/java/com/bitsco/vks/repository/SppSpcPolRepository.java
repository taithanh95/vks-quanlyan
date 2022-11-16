package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppSpcPol;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSpcPolRepository {
    List<LinkedCaseInsensitiveMap> searchUpdateInfo(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String casecode, String userfor);
    String insertUpdate(String action, SppSpcPol ppl, String regicode, String casecode, String userid);
}
