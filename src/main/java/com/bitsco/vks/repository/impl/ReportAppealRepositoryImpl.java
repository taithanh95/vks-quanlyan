package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.ReportAppeal;
import com.bitsco.vks.repository.ReportAppealRepository;
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
 * Date: 20/01/2022
 * Time: 10:08 AM
 */
@Repository
public class ReportAppealRepositoryImpl implements ReportAppealRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<ReportAppeal> search(ReportAppeal reportAppeal) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REPORT_APPEAL")
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", reportAppeal.getCasecode())
                .addValue("p_regicode", reportAppeal.getRegicode());

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<ReportAppeal>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertOrUpdate(ReportAppeal reportAppeal, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REPORT_APPEAL")
                .withFunctionName("fn_insert_update");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_report_appeal_id", reportAppeal.getReportAppealId())
                .addValue("p_setnum", reportAppeal.getSetnum())
                .addValue("p_indate", Utils.getSqlDate(reportAppeal.getIndate()))
                .addValue("p_content", reportAppeal.getContent())
                .addValue("p_status", reportAppeal.getStatus())
                .addValue("p_casecode", reportAppeal.getCasecode())
                .addValue("p_regicode", reportAppeal.getRegicode())
                .addValue("p_created_by", reportAppeal.getCreatedBy())
                .addValue("p_updated_at", Utils.getSqlDate(reportAppeal.getUpdatedAt()))
                .addValue("p_updated_by", reportAppeal.getUpdatedBy())
                .addValue("p_option", reportAppeal.getOption());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String delete(Long id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_REPORT_APPEAL")
                .withFunctionName("fn_delete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_report_appeal_id", id);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }
}
