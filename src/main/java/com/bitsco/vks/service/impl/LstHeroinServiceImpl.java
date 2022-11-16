package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstHeroin;
import com.bitsco.vks.repository.LstHeroinRepository;
import com.bitsco.vks.service.LstHeroinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LstHeroinServiceImpl implements LstHeroinService {
    @Autowired
    private LstHeroinRepository lstHeroinRepository;

    @Override
    public List<LstHeroin> getall() {
        return lstHeroinRepository.getall();
    }
}
