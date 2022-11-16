package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.models.LstCodeRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:34 PM
 */
public interface LstCodeService {
    List<LstCodeDTO> search(LstCodeRequest lstCodeRequest, Pageable pageable);

    String insertUpdate(LstCode req, String username);

    String delete(LstCode req);

    List<LstCode> autocomplete(String query);
}
