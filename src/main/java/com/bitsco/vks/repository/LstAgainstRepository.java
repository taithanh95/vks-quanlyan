package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstAgainstSearchDTO;
import com.bitsco.vks.models.LstAgainstRequest;

import java.util.List;

public interface LstAgainstRepository {
    List<LstAgainstSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String againstid, String againstname, String applyfor, String setunit, String thoihan_tu, String thoihan_den);

    String save(LstAgainstRequest req, String username);

    String delete(String againstid);
}
