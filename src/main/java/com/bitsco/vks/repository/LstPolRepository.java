package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstPolSearchDTO;
import com.bitsco.vks.entity.LstPol;

import java.util.List;

public interface LstPolRepository {
    List<LstPolSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String polId, String name, String addr,String director);
    List<LstPolSearchDTO> getAll();
    String insertUpdate(LstPol req, String username);
    String delete(LstPol req);
}
