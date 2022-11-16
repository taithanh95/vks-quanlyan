package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.RequestReport;
import com.bitsco.vks.repository.RequestReportRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 29/12/2021
 * Time: 1:44 PM
 */
@Repository
public class RequestReportRepositoryImpl implements RequestReportRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RequestReport> search(RequestReport requestReport) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REQUEST_REPORT")
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_period", Utils.getSqlDate(requestReport.getPeriod()))
                .addValue("p_sppid", requestReport.getSppId())
                .addValue("p_note", requestReport.getNote())
                .addValue("p_report_code", requestReport.getReportCode())
                .addValue("p_status", requestReport.getStatus())
                .addValue("p_created_at", Utils.getSqlDate(requestReport.getCreatedAt()))
                .addValue("p_size", requestReport.getPageSize())
                .addValue("p_index", requestReport.getPageIndex());

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<RequestReport>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertOrUpdate(RequestReport requestReport, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REQUEST_REPORT")
                .withFunctionName("fn_insert_update");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_request_report_id", requestReport.getRequestReportId())
                .addValue("p_period", Utils.getSqlDate(requestReport.getPeriod()))
                .addValue("p_sppid", requestReport.getSppId())
                .addValue("p_stage", requestReport.getStage())
                .addValue("p_statistical_violation", requestReport.getStatisticalViolation())
                .addValue("p_tieu_chi_mot", requestReport.getTieuChiMot())
                .addValue("p_tieu_chi_hai", requestReport.getTieuChiHai())
                .addValue("p_note", requestReport.getNote())
                .addValue("p_status", requestReport.getStatus())
                .addValue("p_report_code", requestReport.getReportCode())
                .addValue("p_created_at", Utils.getSqlDate(requestReport.getCreatedAt()))
                .addValue("p_created_by", username)
                .addValue("p_updated_at", Utils.getSqlDate(requestReport.getUpdatedAt()))
                .addValue("p_updated_by", requestReport.getUpdatedBy())
                .addValue("p_option", requestReport.getOption());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String delete(Long id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REQUEST_REPORT")
                .withFunctionName("fn_delete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_request_report_id", id);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }
}
