package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.LookupRequest;
import com.bitsco.vks.repository.LookupRepository;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public class LookupRepositoryImpl implements LookupRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SppRegister> searchRegister(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_2022") //package name
                .withFunctionName("fn_lookup_register");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_userfor", request.getUserfor())
                .addValue("p_setnum", request.getSetnum())
                .addValue("p_indatef", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_indatet", Utils.getSqlDate(request.getTodate()))
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppRegister>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppRegister> lookupRegister(String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_2022") //package name
                .withFunctionName("fn_get_register");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode);
        //First parameter is function output parameter type.
        return (jdbcCall.executeFunction((Class<List<SppRegister>>) (Class) List.class, paramMap));
    }

    @Override
    public List<SppDecision> searchDecision(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_2022") //package name
                .withFunctionName("fn_lookup_decision");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_decicode", !StringCommon.isNullOrBlank(request.getDecicode()) ? request.getDecicode() : null)
                .addValue("p_deciname", !StringCommon.isNullOrBlank(request.getDeciname()) ? request.getDeciname() : null)
                .addValue("p_setnum", request.getSetnum())
                .addValue("p_indatef", Utils.getSqlDate(request.getFromdatedeci()))
                .addValue("p_indatet", Utils.getSqlDate(request.getTodatedeci()))
                .addValue("p_userfor", request.getUserfor())
                .addValue("p_deciid", request.getDeciid())
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_applyfor", !StringCommon.isNullOrBlank(request.getApplyfor()) ? request.getApplyfor() : null)
                .addValue("p_regidatef", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_regidatet", Utils.getSqlDate(request.getTodate()))
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppDecision>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppDecision> lookupDecision(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_2022") //package name
                .withFunctionName("fn_decision_detail");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_regicode", request.getRegicode())
                .addValue("p_userfor", request.getUserfor());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppDecision>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAgainst> searchAgainst(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_MONITOR_AGAINST_2022") //package name
                .withFunctionName("fn_lookup_against");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                .addValue("p_fdateregi", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_tdateregi", Utils.getSqlDate(request.getTodate()))
                .addValue("p_sppspc", request.getSppspc())
                .addValue("p_usefor", request.getUsefor())
                .addValue("p_fdateag", Utils.getSqlDate(request.getFromdateagainst()))
                .addValue("p_tdateag", Utils.getSqlDate(request.getTodateagainst()))
                .addValue("p_setnum", request.getSetnum());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAgainst> lookupAgainst(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_MONITOR_AGAINST_2022") //package name
                .withFunctionName("fn_against_detail");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder())
                .addValue("p_casecode", request.getCasecode())
                .addValue("p_regicode", request.getRegicode())
                .addValue("p_usefor", request.getUserfor());
        //First parameter is function output parameter type.
        List<SppAgainst> res = jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
        return res;
    }

    @Override
    public List<SppAppeal> searchAppeal(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_MONITOR_APPEAL_2022") //package name
                .withFunctionName("fn_lookup_appeal");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                .addValue("p_fdateregi", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_tdateregi", Utils.getSqlDate(request.getTodate()))
                .addValue("p_fdateag", Utils.getSqlDate(request.getFromdateappeal()))
                .addValue("p_tdateag", Utils.getSqlDate(request.getTodateappeal()))
                .addValue("p_appealid", request.getAppealid())
                .addValue("p_appealname", request.getAppealname())

                .addValue("p_setnum", request.getSetnum());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAppeal> lookupAppeal(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_MONITOR_APPEAL_2022") //package name
                .withFunctionName("fn_appeal_detail");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder())
                .addValue("p_casecode", request.getCasecode())
                .addValue("p_regicode", request.getRegicode())
                .addValue("p_usefor", request.getUserfor());
        //First parameter is function output parameter type.
        List<SppAppeal> res = jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
        return res;
    }

    @Override
    public List<SppAccused> searchAccused(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_NEW") //package name
                .withFunctionName("fn_lookup_accused_2022");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                .addValue("p_fromdate", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(request.getTodate()))
                .addValue("p_fullname", !StringCommon.isNullOrBlank(request.getFullname()) ? request.getFullname() : null)
                .addValue("p_identify", !StringCommon.isNullOrBlank(request.getIdentify()) ? request.getIdentify() : null)
                .addValue("p_fromdateBirth", Utils.getSqlDate(request.getBirthdayfrom()))
                .addValue("p_todateBirth", Utils.getSqlDate(request.getBirthdayto()))
                .addValue("p_locaid", request.getLocaid())
                .addValue("p_address", request.getAddress())
                .addValue("p_natiid", request.getNatiid())
                .addValue("p_counid", request.getCounid())
                .addValue("p_sex", request.getSex())
                .addValue("p_conviction", request.getConviction())
                .addValue("p_offence", request.getOffence())
                .addValue("p_law_id", request.getLawid())
                .addValue("p_item", request.getItem())
                .addValue("p_point", request.getPoint())
                .addValue("p_partyid_arr", StringCommon.isNullOrBlank(request.getPartyid()) ? null : request.getPartyid())
                .addValue("p_officeid_arr", StringCommon.isNullOrBlank(request.getOfficeid()) ? null : request.getOfficeid())
                .addValue("p_occuid", request.getOccuid());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAccused>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAccused> lookupAccused(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_NEW") //package name
                .withFunctionName("fn_lookup_accused_detail");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder())
                .addValue("p_regicode", request.getRegicode())
                .addValue("p_userfor", request.getUserfor());
        //First parameter is function output parameter type.
        List<SppAccused> res = jdbcCall.executeFunction((Class<List<SppAccused>>) (Class) List.class, paramMap);
        return res;
    }

    @Override
    public List<LstLaw> searchLaw(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_LOOKUP_LAW);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", request.getSppIdList())
                    .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                    .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                    .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                    .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                    .addValue("p_fromdate", Utils.getSqlDate(request.getFromdate()))
                    .addValue("p_todate", Utils.getSqlDate(request.getTodate()))
                    .addValue("p_userfor", !StringCommon.isNullOrBlank(request.getUserfor()) ? request.getUserfor() : null)
                    .addValue("p_codeid", !StringCommon.isNullOrBlank(request.getCodeid()) ? request.getCodeid() : null)
                    .addValue("p_fromdateCen", Utils.getSqlDate(request.getFromdatecen()))
                    .addValue("p_todateCen", Utils.getSqlDate(request.getTodatecen()))
                    .addValue("p_lawid", request.getLawid())
                    .addValue("p_item", request.getItem())
                    .addValue("p_point", request.getPoint())
                    .addValue("p_setnum", request.getSetnum())
                    .addValue("p_corrup", Boolean.TRUE.equals(request.getBooCorrup()) ? "Y" : "N");
            List<LstLaw> res = jdbcCall.executeFunction((Class<List<LstLaw>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<LstInspector> lookupInspector(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_LOOKUP_INSPECTOR_DETAILS);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_regicode", request.getRegicode());
            //First parameter is function output parameter type.
            List<LstInspector> res = jdbcCall.executeFunction((Class<List<LstInspector>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    public List<SppPenalty> searchPenalty(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_NEW") //package name
                .withFunctionName("fn_lookup_penalty");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                .addValue("p_fromdate", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(request.getTodate()))
                .addValue("p_userfor", request.getUserfor())
                .addValue("p_penaltyid", !StringCommon.isNullOrBlank(request.getPenaltyid()) ? request.getPenaltyid() : null)
                .addValue("p_fromdateCen", Utils.getSqlDate(request.getFromdatecen()))
                .addValue("p_todateCen", Utils.getSqlDate(request.getTodatecen()))
                .addValue("p_setnum", request.getSetnum());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppPenalty>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppSpcPol> searchTransfer(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_NEW") //package name
                .withFunctionName("fn_lookup_transfer");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_sppid", request.getSppIdList())
                .addValue("p_underlevel", Boolean.TRUE.equals(request.getUnderlevel()) ? "Y" : "N")
                .addValue("p_casecode", !StringCommon.isNullOrBlank(request.getCasecode()) ? request.getCasecode() : null)
                .addValue("p_casename", !StringCommon.isNullOrBlank(request.getCasename()) ? request.getCasename() : null)
                .addValue("p_casetype", !StringCommon.isNullOrBlank(request.getCasetype()) ? request.getCasetype() : null)
                .addValue("p_fromdate", Utils.getSqlDate(request.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(request.getTodate()))
                .addValue("p_transfrom", !StringCommon.isNullOrBlank(request.getTransfrom()) ? request.getTransfrom() : null)
                .addValue("p_transto", !StringCommon.isNullOrBlank(request.getTransto()) ? request.getTransto() : null)
                .addValue("p_fromdatetrans", Utils.getSqlDate(request.getFromdatetrans()))
                .addValue("p_todatetrans", Utils.getSqlDate(request.getTodatetrans()))
                .addValue("p_select", request.getSelect());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppSpcPol>>) (Class) List.class, paramMap);
    }

    public List<SppCentence> lookupCentence(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_LOOKUP_CENTENCE_DETAILS);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_regicode", request.getRegicode());
            //First parameter is function output parameter type.
            List<SppCentence> res = jdbcCall.executeFunction((Class<List<SppCentence>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<SppCentence> listCentence(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_CENTENCE_LISTCENTENCE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_centcode", request.getCentcode());
            //First parameter is function output parameter type.
            List<SppCentence> res = jdbcCall.executeFunction((Class<List<SppCentence>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<SppSpcPol> lookupTransfer(LookupRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LOOKUP_NEW") //package name
                .withFunctionName("fn_lookup_transfer_details");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder())
                .addValue("p_casecode", request.getCasecode())
                .addValue("p_select", request.getSelect());
        //First parameter is function output parameter type.
        List<SppSpcPol> res = jdbcCall.executeFunction((Class<List<SppSpcPol>>) (Class) List.class, paramMap);
        return res;
    }

    public List<LstLaw> listCentLaw(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_CENTENCE_LISTCENTLAW);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_centcode", request.getCentcode());
            //First parameter is function output parameter type.
            List<LstLaw> res = jdbcCall.executeFunction((Class<List<LstLaw>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<SppStatistica> listStatistica(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_CENTENCE_LISTSTATISTICC);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_centcode", request.getCentcode());
            //First parameter is function output parameter type.
            List<SppStatistica> res = jdbcCall.executeFunction((Class<List<SppStatistica>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<SppStatisticc> listStatisticc(LookupRequest request) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LOOKUP_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_CENTENCE_LISTSTATISTICA);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_rowindex", request.getRowIndex())
                    .addValue("p_pagesize", request.getPageSize())
                    .addValue("p_sortcol", request.getSortField())
                    .addValue("p_sortorder", request.getSortOrder())
                    .addValue("p_centcode", request.getCentcode());
            //First parameter is function output parameter type.
            List<SppStatisticc> res = jdbcCall.executeFunction((Class<List<SppStatisticc>>) (Class) List.class, paramMap);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }
}
