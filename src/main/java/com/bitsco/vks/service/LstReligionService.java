package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstReligionSearchDTO;
import com.bitsco.vks.models.LstReligionRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstReligionService {
    List<LstReligionSearchDTO> search(LstReligionRequest lstReligionRequest, Pageable pageable);

    String save(LstReligionRequest req, String username);
    String delete(String religionid);
}
