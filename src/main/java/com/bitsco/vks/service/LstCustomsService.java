package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.models.LstCustomsRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface LstCustomsService {
    List<LstCustomsSearchDTO> search(LstCustomsRequest lstCustomsRequest, Pageable pageable);

    List<LstCustoms> autocomplete(String query);

    String insert(LstCustoms req, String username);

    String update(LstCustoms req, String username);

    String getid(String sppid, Integer spplevel);

    String delete(LstCustoms req);

    List<LstCustomsSearchDTO> getFnFindTreeData(String cumstoid, String level, String sppid);

    List<LstCustomsSearchDTO> getCustomsBySppId(String sppid);
}
