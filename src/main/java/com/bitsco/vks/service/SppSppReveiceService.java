package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.*;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppReveiceService {
    List<LinkedCaseInsensitiveMap> search(SppSppReveiceSearchRequest req);

    String update(SppSppReveiceSaveRequest req, String userid);

    List<LstTransferSearchDTO> getTransferByTransId(String sppid);
}
