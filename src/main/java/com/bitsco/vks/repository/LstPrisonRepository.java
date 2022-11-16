package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstPrisonSearchDTO;
import com.bitsco.vks.entity.LstPrison;

import java.util.List;

public interface LstPrisonRepository {
    List<LstPrisonSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String prisonid, String name, String addr, String ptype, String sppid);
    String insertUpdate(LstPrison req, String username);
    String delete(LstPrison req);
}
