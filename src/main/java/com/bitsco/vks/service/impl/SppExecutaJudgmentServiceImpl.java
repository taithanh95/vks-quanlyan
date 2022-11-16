package com.bitsco.vks.service.impl;

import com.bitsco.vks.models.SaveSppRegisterRequest;
import com.bitsco.vks.models.SppRegisterSearchRequest;
import com.bitsco.vks.models.UpdateInfoG6SearchRequest;
import com.bitsco.vks.repository.SppExecutaJudgmentRepository;
import com.bitsco.vks.repository.SppRegisterRepository;
import com.bitsco.vks.service.SppExecutaJudgmentService;
import com.bitsco.vks.service.SppRegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppExecutaJudgmentServiceImpl implements SppExecutaJudgmentService {
    @Autowired
    private SppExecutaJudgmentRepository sppExecutaJudgmentRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> doSearch(UpdateInfoG6SearchRequest req) {
        return sppExecutaJudgmentRepository.search(req.rowIndex, req.pageSize , req);
    }
}
