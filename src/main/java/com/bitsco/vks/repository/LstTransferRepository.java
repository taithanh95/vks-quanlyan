package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.LstTransferRequest;

import java.util.List;

public interface LstTransferRepository {
    List<LstTransferSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String transid, String transname);

    String save(String action, String transid, String transname, String fromto, String username);

    String delete(String transid);
}
