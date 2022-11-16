package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.LstAgainstResultSearchDTO;
import com.bitsco.vks.models.LstAgainstResultRequest;
import com.bitsco.vks.repository.LstAgainstResultRepository;
import com.bitsco.vks.service.LstAgainstResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LstAgainstResultServiceImpl implements LstAgainstResultService {
    @Autowired
    private LstAgainstResultRepository lstAgainstResultRepository;

    @Override
    @Transactional(readOnly = true)
    public List<LstAgainstResultSearchDTO> search(LstAgainstResultRequest lstAgainstResultRequest, Pageable pageable) {
        return lstAgainstResultRepository.search(pageable.getPageNumber(),
                pageable.getPageSize(),
                lstAgainstResultRequest.getSortField(),
                lstAgainstResultRequest.getSortOrder(),
                lstAgainstResultRequest.getResultid(),
                lstAgainstResultRequest.getResultname());
    }

    @Override
    public String save(LstAgainstResultRequest req, String username) {
        return lstAgainstResultRepository.save(req.getAction(), req.getResultid(), req.getResultname(), username);
    }

    @Override
    public String delete(String resultid) {
        return lstAgainstResultRepository.delete(resultid);
    }
}
