package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstDecitypeSearchDTO;
import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.entity.LstDecitype;

import java.util.List;

public interface LstDecitypeRepository {
    List<LstDecitypeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String decitypeId, String name);

    List<LstDecitype> searchDecitypeAccu(String usefor);

    String save(String action, String decitypeid, String name, String username);

    String delete(String decitypeid);

    List<LstDecitype> getLstDecitype();
}
