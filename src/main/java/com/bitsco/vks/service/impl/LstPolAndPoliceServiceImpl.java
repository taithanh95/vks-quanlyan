package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.ComboBoxDTO;
import com.bitsco.vks.repository.LstPolAndPoliceRepository;
import com.bitsco.vks.service.LstPolAndPoliceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstPolAndPoliceServiceImpl implements LstPolAndPoliceService {

    @Autowired
    LstPolAndPoliceRepository lstPolAndPoliceRepository;

    @Override
    public List<ComboBoxDTO> searchByName(String name) {
        return lstPolAndPoliceRepository.searchByName(name);
    }
}
