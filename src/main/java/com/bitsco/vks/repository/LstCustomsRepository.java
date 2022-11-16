package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstParty;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;

public interface LstCustomsRepository {
    List<LstCustomsSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String sppid, String name, String addr, String tel, String fax, String spcid);
    List<LstCustoms> autocomplete(String query, Integer level, int limit);

    String insert(LstCustoms req, String username);

    String update(LstCustoms req, String username);

    String getid(String sppid, Integer spplevel);

    String delete(LstCustoms req);

    List<LstCustomsSearchDTO> getFnFindTreeData(String cumstoid, String level, String sppid);

    List<LstCustomsSearchDTO> getCustomsBySppId(String sppid);

}
