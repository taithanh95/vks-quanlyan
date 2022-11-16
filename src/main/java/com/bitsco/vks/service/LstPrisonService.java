package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstPrisonSearchDTO;
import com.bitsco.vks.entity.LstPrison;
import com.bitsco.vks.models.LstPrisonRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstPrisonService {
    List<LstPrisonSearchDTO> search(LstPrisonRequest lstPrisonRequest, Pageable pageable);


    String insertUpdate(LstPrison req, String username);
    String delete(LstPrison req);
}
