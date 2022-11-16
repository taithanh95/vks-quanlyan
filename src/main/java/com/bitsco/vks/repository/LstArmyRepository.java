package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.entity.LstArmyEntity;

import java.util.List;

public interface LstArmyRepository {
    List<LstArmySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String armyid, String name, String addr, String tel, String fax, String sppid);
    List<LstArmyEntity> autocomplete(String query, Integer level, int limit);
    String insert(LstArmyEntity ls, String userId);
    String update(LstArmyEntity ls, String userId);
    String delete(LstArmyEntity _spp);
    String getid(String sppid, Integer spplevel);
    List<LstArmySearchDTO> getFnFindTreeData(String id, String level, String sppid);
    List<LstArmySearchDTO> getArmyBySppId(String sppid);
}
