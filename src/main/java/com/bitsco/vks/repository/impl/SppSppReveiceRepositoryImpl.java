package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.SppSppReveiceSaveRequest;
import com.bitsco.vks.models.SppSppReveiceSearchRequest;
import com.bitsco.vks.repository.SppSppReveiceRepository;
import com.bitsco.vks.utils.DateCommon;
import com.bitsco.vks.utils.Utils;
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
public class SppSppReveiceRepositoryImpl implements SppSppReveiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, SppSppReveiceSearchRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_RECEIVE") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", Utils.StringIsNullOrEmpty(req.sortField) ? null: req.sortField)
                .addValue("p_sortorder","ASC".equals(req.sortOrder) ? "ASC" : "DESC")
                .addValue("p_action", Utils.StringIsNullOrEmpty(req.reveicetype) ? null : req.reveicetype)
                .addValue("p_casecode", Utils.StringIsNullOrEmpty(req.casecode) ? null : req.casecode)
                .addValue("p_casename", Utils.StringIsNullOrEmpty(req.casename) ? null : req.casename)
                .addValue("p_transdate_from", DateCommon.convertUtilDateToSqlDate(req.fromdate))
                .addValue("p_transdate_to", DateCommon.convertUtilDateToSqlDate(req.todate))
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(req.sppid) ? null : req.sppid)
                .addValue("p_sppidf", Utils.StringIsNullOrEmpty(req.sppidf) ? null : req.sppidf)
                .addValue("p_transid", Utils.StringIsNullOrEmpty(req.transid) ? null : req.transid)
                .addValue("p_sppname", Utils.StringIsNullOrEmpty(req.sppname) ? null : req.sppname);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public String update(SppSppReveiceSaveRequest req, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_RECEIVE") //package name
                .withFunctionName("fn_insert_update");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", Utils.StringIsNullOrEmpty(req.action) ? null : req.action)
                .addValue("p_transcode", Utils.StringIsNullOrEmpty(req.transcode) ? null : req.transcode)
                .addValue("p_casecode", Utils.StringIsNullOrEmpty(req.casecode) ? null : req.casecode)
                .addValue("p_transdate", DateCommon.convertUtilDateToSqlDate(req.transdate))
                .addValue("p_sppidf", Utils.StringIsNullOrEmpty(req.sppidf) ? null : req.sppidf)
                .addValue("p_sppidt", Utils.StringIsNullOrEmpty(req.sppidt) ? null : req.sppidt)
                .addValue("p_sender", Utils.StringIsNullOrEmpty(req.sender) ? null : req.sender)
                .addValue("p_receipter", Utils.StringIsNullOrEmpty(req.receipter) ? null : req.receipter)
                .addValue("p_remark", Utils.StringIsNullOrEmpty(req.remark) ? null : req.remark)
                .addValue("p_transid", Utils.StringIsNullOrEmpty(req.transid) ? null : req.transid)
                .addValue("p_crtuser", userid)
                .addValue("p_regicode", Utils.StringIsNullOrEmpty(req.regicode) ? null : req.regicode)
                .addValue("p_acceptdate", DateCommon.convertUtilDateToSqlDate(req.acceptdate))
                .addValue("p_userfor", Utils.StringIsNullOrEmpty(req.userfor) ? null : req.userfor);

        Map results = jdbcCall.execute(paramMap);
        return  (String) results.get("return");
    }

    @Override
    public List<LstTransferSearchDTO> getTransferByTransId(String transid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_RECEIVE") //package name
                .withFunctionName("fn_getLstTransfer");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_transid", transid);

        return jdbcCall.executeFunction((Class<List<LstTransferSearchDTO>>) (Class) List.class, paramMap);

    }
}
