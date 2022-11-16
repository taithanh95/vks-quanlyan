package com.bitsco.vks.service;

import com.bitsco.vks.entity.RequestReport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 29/12/2021
 * Time: 2:10 PM
 */
public interface RequestReportService {
    List<RequestReport> search(RequestReport requestReport);

    String insertOrUpdate(RequestReport requestReport, String username);

    String delete(Long id);
}
