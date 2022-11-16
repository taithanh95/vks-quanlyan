package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.ReportAppeal;
import com.bitsco.vks.repository.ReportAppealRepository;
import com.bitsco.vks.service.ReportAppealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 10:28 AM
 */
@Service
public class ReportAppealServiceImpl implements ReportAppealService {
    @Autowired
    ReportAppealRepository reportAppealRepository;

    @Override
    public List<ReportAppeal> search(ReportAppeal reportAppeal) {
        return reportAppealRepository.search(reportAppeal);
    }

    @Override
    public String insertOrUpdate(ReportAppeal reportAppeal, String username) {
        return reportAppealRepository.insertOrUpdate(reportAppeal, username);
    }

    @Override
    public String delete(Long id) {
        return reportAppealRepository.delete(id);
    }
}
