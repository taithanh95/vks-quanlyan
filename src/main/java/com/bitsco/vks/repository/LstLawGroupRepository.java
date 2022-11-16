package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstLawGroup;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:23 AM
 */
public interface LstLawGroupRepository {
    List<LstLawGroupDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String groupid, String groupname, String codeid);

    String insertUpdate(LstLawGroup req, String username);

    String delete(LstLawGroup req);
}
