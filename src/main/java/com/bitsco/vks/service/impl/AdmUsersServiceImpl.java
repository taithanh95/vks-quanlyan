package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.repository.AdmUsersRepository;
import com.bitsco.vks.service.AdmUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdmUsersServiceImpl implements AdmUsersService {

    @Autowired
    AdmUsersRepository admUsersRepository;

    @Override
    public List<LstInspector> getLstInspectors(String sppid) {
        return admUsersRepository.getLstInspectors(sppid);
    }
}
