package com.bitsco.vks.repository;

import com.bitsco.vks.entity.SppAppeal;
import com.bitsco.vks.models.SppAppealSaveResponse;

import javax.swing.*;
import java.util.List;

public interface SppAppealRepository {
    List<SppAppeal> searchByRegicode(int rowIndex, int pageSize, String sortField, String sortOrder,
                                     String regicode, String userfor, String sppid);

    List<SppAppeal> searchByCase(int pageNumber, int pageSize, String sortField, String sortOrder, String casecode, String userfor, String sppid);

    SppAppealSaveResponse insertUpdate(String action, SppAppeal sppAppeal, String sppid, String userid);

    String delete(String code);

    List<SppAppeal> lstAppeals(String query);

    List<SppAppeal> getAppealAcc(String appecode);
}
