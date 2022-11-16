package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.RequestReport;
import com.bitsco.vks.repository.RequestReportRepository;
import com.bitsco.vks.service.RequestReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 29/12/2021
 * Time: 2:13 PM
 */
@Service
public class RequestReportServiceImpl implements RequestReportService {
    @Autowired
    RequestReportRepository requestReportRepository;

    @Override
    public List<RequestReport> search(RequestReport requestReport) {
        return requestReportRepository.search(requestReport);
    }

    @Override
    public String insertOrUpdate(RequestReport requestReport, String username) {
        return requestReportRepository.insertOrUpdate(requestReport, username);
    }

    @Override
    public String delete(Long id) {
        return requestReportRepository.delete(id);
    }
}
