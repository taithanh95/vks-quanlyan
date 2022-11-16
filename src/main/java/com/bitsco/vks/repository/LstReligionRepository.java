package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstReligionSearchDTO;

import java.util.List;

public interface LstReligionRepository {
    List<LstReligionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String name, String note);

    String save(String action, String religionid, String religioname, String religionote, String username);

    String delete(String religionid);
}
