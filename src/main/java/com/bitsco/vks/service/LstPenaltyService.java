package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstPenaltyDTO;
import com.bitsco.vks.entity.LstPenalty;
import com.bitsco.vks.models.LstPenaltyRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 9:58 AM
 */
public interface LstPenaltyService {
    List<LstPenaltyDTO> search(LstPenaltyRequest lstPenaltyRequest, Pageable pageable);

    String insertUpdate(LstPenalty req, String username);

    String delete(LstPenalty req);

    List<LstPenalty> getListPenalty(String query);
}
