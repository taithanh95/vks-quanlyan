package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstAgainstSearchDTO;
import com.bitsco.vks.models.LstAgainstRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstAgainstService {
    List<LstAgainstSearchDTO> search(LstAgainstRequest lstAgainstRequest, Pageable pageable);

    String save(LstAgainstRequest req, String username);

    String delete(String againstid);
}
