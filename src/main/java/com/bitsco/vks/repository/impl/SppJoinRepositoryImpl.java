package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.models.SppJoinSaveRequest;
import com.bitsco.vks.models.SppJoinSearchRequest;
import com.bitsco.vks.repository.SppJoinRepository;
import com.bitsco.vks.utils.Utils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;
import java.util.Map;

@Repository
public class SppJoinRepositoryImpl implements SppJoinRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> getList(SppJoinSearchRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_JOINCASE)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH_CASE);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex", req.getRowIndex())
                .addValue("p_pagesize", req.getPageSize())
                .addValue("p_sortcol", req.sortField)
                .addValue("p_sortorder", req.sortOrder)
                .addValue("p_sppid", req.getSppid())
                .addValue("p_casecode", req.getCasecode())
                .addValue("p_casename", req.getCasename())
                .addValue("p_setnum", req.getBegin_setnum())
                .addValue("p_fromdate", Utils.getSqlDate(req.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(req.getTodate()))
                .addValue("p_choice", req.getChoice())
                .addValue("p_cimdatef", req.getCrimdatef())
                .addValue("p_crimdatet", req.getCrimdatet());
        return jdbcCall.executeFunction(List.class,param);
    }

    @Override
    public String save(SppJoinSaveRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_JOINCASE)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_CASEACC)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_casecodeto", req.getCasecode())
                .addValue("p_casecodefrom", StringUtils.join(req.getLstCase(),","))
                .addValue("p_sppid", req.getSppid())
                .addValue("p_action", req.getAction());
        Map result = jdbcCall.execute(param);
        return (String) result.get("return");
    }
}
