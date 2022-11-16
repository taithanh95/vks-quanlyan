package com.bitsco.vks.service;

import com.bitsco.vks.entity.SppAppeal;
import com.bitsco.vks.models.*;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface SppAppealService {
    List<SppAppeal> searchByRegicode(SppAppealSearchRequest request, Pageable pageable);
    List<SppAppeal> searchByCase(SppAppealSearchCaseRequest request, Pageable pageable);

    SppAppealSaveResponse insertUpdate(SppAppealSaveRequest request, String userid);

    String delete(String code);

    List<SppAppeal> lstAppeals(String query);

    List<SppAppeal> getAppealAcc(String appecode);
}
