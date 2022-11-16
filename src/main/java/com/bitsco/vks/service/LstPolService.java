package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstPolSearchDTO;
import com.bitsco.vks.entity.LstPol;
import com.bitsco.vks.models.LstPolRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LstPolService {
    List<LstPolSearchDTO> search(LstPolRequest lstPolRequest, Pageable pageable);

    List<LstPolSearchDTO> getAll();

    String insertUpdate(LstPol req, String username);
    String delete(LstPol req);
}
