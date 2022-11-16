package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.SppSppSendSaveRequest;
import com.bitsco.vks.models.SppSppSendSearchRequest;
import com.bitsco.vks.repository.SppSppSendRepository;
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
public class SppSppSendRepositoryImpl implements SppSppSendRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, SppSppSendSearchRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", Utils.StringIsNullOrEmpty(req.sortField) ? null : req.sortField)
                .addValue("p_sortordel", "ASC".equals(req.sortOrder) ? "ASC" : "DESC")
                .addValue("p_casecode", Utils.StringIsNullOrEmpty(req.casecode) ? null : req.casecode)
                .addValue("p_casename", Utils.StringIsNullOrEmpty(req.casename) ? null : req.casename)
                .addValue("p_transdate_from", DateCommon.convertUtilDateToSqlDate(req.fromdate))
                .addValue("p_transdate_to", DateCommon.convertUtilDateToSqlDate(req.todate))
                .addValue("p_fullname", null)
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(req.sppid) ? null : req.sppid)
                .addValue("p_sppname", Utils.StringIsNullOrEmpty(req.sppname) ? null : req.sppname)
                .addValue("p_action", Utils.StringIsNullOrEmpty(req.sendtype) ? null : req.sendtype);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);

    }

    @Override
    public List<LstSPP> getListSpp(String transid, String sppid, String casecode, String query, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_get_spp");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_transid", transid)
                .addValue("p_sppid", sppid)
                .addValue("p_casecode", casecode)
                .addValue("p_query", query)
                .addValue("p_usefor", userfor);

        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public String update(SppSppSendSaveRequest req, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_insert_update");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", Utils.StringIsNullOrEmpty(req.action) ? null : req.action)
                .addValue("p_transcode", Utils.StringIsNullOrEmpty(req.transcode) ? null : req.transcode)
                .addValue("p_regicode", Utils.StringIsNullOrEmpty(req.regicode) ? null : req.regicode)
                .addValue("p_casecode", Utils.StringIsNullOrEmpty(req.casecode) ? null : req.casecode)
                .addValue("p_transdate", DateCommon.convertUtilDateToSqlDate(req.transdate))
                .addValue("p_sppidf", Utils.StringIsNullOrEmpty(req.sppidf) ? null : req.sppidf)
                .addValue("p_sppidt", Utils.StringIsNullOrEmpty(req.sppidt) ? null : req.sppidt)
                .addValue("p_sender", Utils.StringIsNullOrEmpty(req.sender) ? null : req.sender)
                .addValue("p_receipter", Utils.StringIsNullOrEmpty(req.receipter) ? null : req.receipter)
                .addValue("p_userfor", Utils.StringIsNullOrEmpty(req.userfor) ? null : req.userfor)
                .addValue("p_remark", Utils.StringIsNullOrEmpty(req.remark) ? null : req.remark)
                .addValue("p_transid", Utils.StringIsNullOrEmpty(req.transid) ? null : req.transid)
                .addValue("p_crtuser", userid)
                .addValue("p_decicode", Utils.StringIsNullOrEmpty(req.decicode) ? null : req.decicode);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public List<LstTransferSearchDTO> getListTransfer(String userforregis, String userfor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_get_lst_transfer");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_userfor_regis", userforregis)
                .addValue("p_userfor", userfor)
                .addValue("p_sppid", sppid);

        return jdbcCall.executeFunction((Class<List<LstTransferSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchRequest(int rowIndex, int pageSize, SppSppSendSearchRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_search_request");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", Utils.StringIsNullOrEmpty(req.sortField) ? null : req.sortField)
                .addValue("p_sortordel", "ASC".equals(req.sortOrder) ? "ASC" : "DESC")
                .addValue("p_casecode", Utils.StringIsNullOrEmpty(req.casecode) ? null : req.casecode)
                .addValue("p_casename", Utils.StringIsNullOrEmpty(req.casename) ? null : req.casename)
                .addValue("p_transdate_from", DateCommon.convertUtilDateToSqlDate(req.fromdate))
                .addValue("p_transdate_to", DateCommon.convertUtilDateToSqlDate(req.todate))
                .addValue("p_fullname", null)
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(req.sppid) ? null : req.sppid)
                .addValue("p_sppname", Utils.StringIsNullOrEmpty(req.sppname) ? null : req.sppname)
                .addValue("p_action", Utils.StringIsNullOrEmpty(req.sendtype) ? null : req.sendtype);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public String insertRequest(String regicode, String centcode, String status, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_insert_request");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_centcode", centcode)
                .addValue("p_regicode", regicode)
                .addValue("p_status", status)
                .addValue("p_crtuser", sppid);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public List<LstSPP> getListSppTinh(String req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_get_spp_tinh");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", req);

        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPP> getListSppHuyen(String req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPP_SEND") //package name
                .withFunctionName("fn_get_spp_huyen");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", req);

        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }
}
