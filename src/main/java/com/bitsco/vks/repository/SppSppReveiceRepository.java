package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.SppSppReveiceSaveRequest;
import com.bitsco.vks.models.SppSppReveiceSearchRequest;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppReveiceRepository {
    List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize , SppSppReveiceSearchRequest req);

    String update(SppSppReveiceSaveRequest req, String userid);

    List<LstTransferSearchDTO> getTransferByTransId(String transid);
}
