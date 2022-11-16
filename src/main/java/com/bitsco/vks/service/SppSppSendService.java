package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchNameRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppSendService {
    List<LinkedCaseInsensitiveMap> search(SppSppSendSearchRequest req);

    List<LinkedCaseInsensitiveMap> searchRequest(SppSppSendSearchRequest req);

    List<LstSPP> getListSpp(SppSppSendSearchNameRequest req);

    String update(SppSppSendSaveRequest req, String userid);

    List<LstTransferSearchDTO> getListTransfer(String userforregis, String userfor, String sppid);

    String insertRequest(String regicode, String centcode, String status, String sppid);

    List<LstSPP> getListSppTinh(String req);

    List<LstSPP> getListSppHuyen(String req);
}
