package com.bitsco.vks.repository;

import com.bitsco.vks.dto.ComboBoxDTO;

import java.util.List;

public interface LstPolAndPoliceRepository {

    List<ComboBoxDTO> searchByName(String name);

}
