package com.bitsco.vks.repository;

import com.bitsco.vks.entity.ReportAppeal;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 9:54 AM
 */
public interface ReportAppealRepository {
    List<ReportAppeal> search(ReportAppeal reportAppeal);

    String insertOrUpdate(ReportAppeal reportAppeal, String username);

    String delete(Long id);
}
