package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstLawPenaltyDTO;
import com.bitsco.vks.entity.LstLawPenalty;
import com.bitsco.vks.models.LstLawPenaltyRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 2:03 PM
 */
public interface LstLawPenaltyService {
    List<LstLawPenaltyDTO> search(LstLawPenaltyRequest lstLawPenaltyRequest, Pageable pageable);

    String insertUpdate(LstLawPenalty req);

    String delete(LstLawPenalty req);
}
