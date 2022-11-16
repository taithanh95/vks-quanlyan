package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstOfficeSearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstOfficeRequest;

import java.util.List;

public interface LstOfficeRepository {
    List<LstOfficeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String officeId, String officeName, String setLevel);

    String insertUpdate(LstOfficeRequest req, String username);

    String delete(LstOfficeRequest req);
}
