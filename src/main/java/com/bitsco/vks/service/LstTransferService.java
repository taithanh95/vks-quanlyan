package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.LstTransferRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstTransferService {
    List<LstTransferSearchDTO> search(LstTransferRequest lstTransferRequest, Pageable pageable);

    String save(LstTransferRequest req, String username);

    String delete(String transid);
}
