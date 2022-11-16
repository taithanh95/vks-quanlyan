package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppSppSendRepository {
    List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize , SppSppSendSearchRequest req);

    List<LinkedCaseInsensitiveMap> searchRequest(int rowIndex, int pageSize , SppSppSendSearchRequest req);

    List<LstSPP> getListSpp(String transid, String sppid, String casecode, String query, String userfor);

    String update(SppSppSendSaveRequest req, String userid);

    List<LstTransferSearchDTO> getListTransfer(String userforregis, String userfor, String sppid);

    String insertRequest(String regicode, String centcode, String status, String sppid);

    List<LstSPP> getListSppTinh(String req);

    List<LstSPP> getListSppHuyen(String req);
}
