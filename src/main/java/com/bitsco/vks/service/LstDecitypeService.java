package com.bitsco.vks.service;


import com.bitsco.vks.dto.LstDecitypeSearchDTO;
import com.bitsco.vks.entity.LstDecitype;
import com.bitsco.vks.models.LstDecitypeRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstDecitypeService {
    List<LstDecitypeSearchDTO> search(LstDecitypeRequest lstDecitypeRequest, Pageable pageable);

    List<LstDecitype> searchDecitypeAccu(String usefor);

    String save(LstDecitypeRequest req, String username);

    String delete(String decitypeid);

    List<LstDecitype> getLst();

}
