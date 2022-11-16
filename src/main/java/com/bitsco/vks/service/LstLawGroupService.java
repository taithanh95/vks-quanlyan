package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.models.LstCodeRequest;
import com.bitsco.vks.models.LstLawGroupRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:30 AM
 */
public interface LstLawGroupService {
    List<LstLawGroupDTO> search(LstLawGroupRequest lstLawGroupRequest, Pageable pageable);

    String insertUpdate(LstLawGroup req, String username);

    String delete(LstLawGroup req);
}
