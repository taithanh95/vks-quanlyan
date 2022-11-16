package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstReasonSearchDTO;
import com.bitsco.vks.entity.LstReason;

import java.util.List;

public interface LstReasonRepository {
    List<LstReasonSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String reasonId,String reasonName, String deciId);

    List<LstReason> loadLstReason(String usefor, String applyfor, String deciid);

    String save(String action, String reasonid, String reasonname, String deciid, String username);

    String delete(String reasonid);
}
