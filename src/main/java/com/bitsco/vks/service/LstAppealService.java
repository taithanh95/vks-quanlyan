package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstAppealSearchDTO;
import com.bitsco.vks.models.LstAppealRequest;
import org.springframework.data.domain.Pageable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface LstAppealService {
    List<LstAppealSearchDTO> search(LstAppealRequest lstAppealRequest, Pageable pageable);

    String save(LstAppealRequest req, String username);

    String delete(String appealid);
}
