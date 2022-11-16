package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstSPC;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:23 PM
 */
public interface LstCodeRepository {
    List<LstCodeDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String codeid, String codename);

    String insertUpdate(LstCode req, String username);

    String delete(LstCode req);

    List<LstCode> autocomplete(String query, Integer limit);
}
