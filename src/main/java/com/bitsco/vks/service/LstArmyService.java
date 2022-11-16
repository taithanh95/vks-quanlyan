package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.entity.LstArmyEntity;
import com.bitsco.vks.models.LstArmyRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstArmyService {
    List<LstArmySearchDTO> search(LstArmyRequest lstArmyRequest, Pageable pageable);
    List<LstArmyEntity> autocomplete(String query);
    String insert(LstArmyEntity ls);
    String update(LstArmyEntity ls);
    String delete(LstArmyEntity _spp);
    String getid(String sppid,Integer spplevel);
    List<LstArmySearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstArmySearchDTO> getArmyBySppId(String sppid);
}
