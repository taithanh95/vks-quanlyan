package com.bitsco.vks.repository.impl;

import com.bitsco.vks.models.UpdateInfoG6SearchRequest;
import com.bitsco.vks.repository.SppExecutaJudgmentRepository;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Repository
public class SppExecutaJudgmentRepositoryImp implements SppExecutaJudgmentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, UpdateInfoG6SearchRequest _obj){
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_QLA_HS") //package name
                    .withFunctionName("fn_search_forregister_g6_v2");

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", rowIndex)
                    .addValue("p_pagesize", pageSize)
                    .addValue("p_casecode", StringCommon.isNullOrBlank(_obj.caseCode) ? null : _obj.caseCode.trim())
                    .addValue("p_casename", StringCommon.isNullOrBlank(_obj.caseName) ? null : _obj.caseName.trim())
                    .addValue("p_crimdate_from", Utils.getSqlDate(_obj.fromDate))
                    .addValue("p_crimdate_to", Utils.getSqlDate(_obj.toDate))
                    .addValue("p_fullname", StringCommon.isNullOrBlank(_obj.accuName) ? null : _obj.accuName.trim())
                    .addValue("p_sppid", StringCommon.isNullOrBlank(_obj.sppid) ? null : _obj.sppid)
                    .addValue("p_action", _obj.acceptType)
                    .addValue("p_regicode", StringCommon.isNullOrBlank(_obj.regiCode) ? null : _obj.regiCode.trim())
                    .addValue("p_userfor", StringCommon.isNullOrBlank(_obj.userfor) ? null : _obj.userfor)
                    .addValue("p_centSpp", StringCommon.isNullOrBlank(_obj.sppCentence) ? null : _obj.sppCentence)
                    .addValue("p_sortcol", _obj.sortField)
                    .addValue("p_sortorder", StringCommon.isNullOrBlank(_obj.sortOrder) ? "DESC" : _obj.sortOrder)
                    .addValue("p_actionTHA", StringCommon.isNullOrBlank(_obj.status) ? null : _obj.status);
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction(List.class, paramMap);
        }catch (Exception ex) {
            throw ex;
        }
    }
}