package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SppJoinSaveRequest;
import com.bitsco.vks.models.SppJoinSearchRequest;
import com.bitsco.vks.repository.SppJoinRepository;
import com.bitsco.vks.service.SppJoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppJoinServiceImpl implements SppJoinService {

    @Autowired
    private SppJoinRepository sppJoinRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> getList(SppJoinSearchRequest req) {
        return sppJoinRepository.getList(req);
    }

    @Override
    public String save(SppJoinSaveRequest req) {
        return sppJoinRepository.save(req);
    }
}
