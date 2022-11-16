package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstAgainstResultSearchDTO;
import com.bitsco.vks.models.LstAgainstResultRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstAgainstResultService {
    List<LstAgainstResultSearchDTO> search(LstAgainstResultRequest lstAgainstResultRequest, Pageable pageable);

    String save(LstAgainstResultRequest req, String username);

    String delete(String resultid);

}
