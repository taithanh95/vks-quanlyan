package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstReasonSearchDTO;
import com.bitsco.vks.entity.LstReason;
import com.bitsco.vks.models.LstReasonRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstReasonService {
    List<LstReasonSearchDTO> search(LstReasonRequest lstReasonRequest, Pageable pageable);
    List<LstReason> loadLstReason(String usefor, String applyfor, String deciid);

    String save(LstReasonRequest req, String username);

    String delete(String reasonid);
}
