package com.bitsco.vks.service;

import com.bitsco.vks.dto.ComboBoxDTO;

import java.util.List;

public interface LstPolAndPoliceService {

    List<ComboBoxDTO> searchByName(String name);

}
