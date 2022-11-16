package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstLawPenaltyDTO;
import com.bitsco.vks.entity.LstLawPenalty;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 1:38 PM
 */
public interface LstLawPenaltyRepository {
    List<LstLawPenaltyDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder,
                                  String lawid, String item, String point, String lawname, String codeid, String groupid);

    String insertUpdate(LstLawPenalty req);

    String delete(LstLawPenalty req);
}
