package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstResolveSearchDTO;
import com.bitsco.vks.models.LstResolveRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstResolveService {
    List<LstResolveSearchDTO> search(LstResolveRequest lstResolveRequest, Pageable pageable);

    String save(LstResolveRequest req, String username);
    String delete(String resolid);
}
