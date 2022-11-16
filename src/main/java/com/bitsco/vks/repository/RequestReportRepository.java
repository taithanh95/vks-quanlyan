package com.bitsco.vks.repository;

import com.bitsco.vks.entity.RequestReport;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 29/12/2021
 * Time: 1:42 PM
 */
public interface RequestReportRepository {
    List<RequestReport> search(RequestReport requestReport);

    String insertOrUpdate(RequestReport requestReport, String username);

    String delete(Long id);
}
