package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.RequestSaveSplitDTO;
import com.bitsco.vks.dto.RequestSearchSplitDTO;
import com.bitsco.vks.repository.SppSppSplitRepository;
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
public class SppSppSplitRepositoryImpl implements SppSppSplitRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> searchCase(RequestSearchSplitDTO req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH_CASE);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex",req.getRowIndex())
                .addValue("p_pagesize",req.getPageSize())
                .addValue("p_sortcol",req.sortField)
                .addValue("p_sortorder",req.sortOrder)
                .addValue("p_casecode",req.getCasecode())
                .addValue("p_casename",req.getCasename())
                .addValue("p_crimdatef",req.getCrimdatef())
                .addValue("p_crimdatet",req.getCrimdatet())
                .addValue("p_accuname",req.getFullname())
                .addValue("p_sppid",req.getSppid());
        return jdbcCall.executeFunction(List.class, param);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCase1(RequestSearchSplitDTO req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH_CASE1);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex",req.getRowIndex())
                .addValue("p_pagesize",req.getPageSize())
                .addValue("p_sortcol",req.sortField)
                .addValue("p_sortorder",req.sortOrder)
                .addValue("p_casecode",req.getCasecode())
                .addValue("p_casename",req.getCasename())
                .addValue("p_crimdatef", Utils.getSqlDate(req.getCrimdatef()))
                .addValue("p_crimdatet",Utils.getSqlDate(req.getCrimdatef()))
                .addValue("p_accuname",req.getFullname())
                .addValue("p_sppid",req.getSppid())
                .addValue("p_casecodeout",req.getCasecodeout());
        return jdbcCall.executeFunction(List.class, param);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCaseSplit(RequestSearchSplitDTO req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_SEARCHCASESPLIT);
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex",req.getRowIndex())
                .addValue("p_pagesize",req.getPageSize())
                .addValue("p_sortcol",req.sortField)
                .addValue("p_sortorder",req.sortOrder)
                .addValue("p_sppid",req.getSppid())
                .addValue("p_casecode",req.getCasecode())
                .addValue("p_casename",req.getCasename())
                .addValue("p_choice",req.getChoice());

        return jdbcCall.executeFunction(List.class,param);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchSplit(RequestSearchSplitDTO req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH_SPLIT);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex",req.getRowIndex())
                .addValue("p_pagesize",req.getPageSize())
                .addValue("p_sortcol",req.sortField)
                .addValue("p_sortorder",req.sortOrder)
                .addValue("p_sppid",req.getSppid())
                .addValue("p_casecode",req.getCasecode())
                .addValue("p_casename",req.getCasename())
                .addValue("p_accuname",req.getFullname())
                .addValue("p_splitdate",null)
                .addValue("p_identify",req.getIdentify())
                .addValue("p_localid",req.getAtxtLocaid())
                .addValue("p_addressid",req.getAtxtAddressid())
                .addValue("p_natiid",req.getAtxtNatiid())
                .addValue("p_counid",req.getAtxtCounid())
                .addValue("p_levelid",req.getAtxtLevelid());

        return jdbcCall.executeFunction(List.class, param);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchAccuSplit(RequestSearchSplitDTO req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH1);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex",req.getRowIndex())
                .addValue("p_pagesize",req.getPageSize())
                .addValue("p_sortcol",req.sortField)
                .addValue("p_sortorder",req.sortOrder)
                .addValue("p_sppid",req.getSppid())
                .addValue("p_casecode",req.getCasecode())
                .addValue("p_casename",req.getCasename())
                .addValue("p_accuname",req.getFullname())
                .addValue("p_identify",req.getIdentify())
                .addValue("p_birthdayfrom",null)
                .addValue("p_birthdayto",null)
                .addValue("p_localid",req.getAtxtLocaid())
                .addValue("p_addressid",req.getAtxtAddressid())
                .addValue("p_natiid",req.getAtxtNatiid())
                .addValue("p_counid",req.getAtxtCounid())
                .addValue("p_levelid",req.getAtxtLevelid());

        return jdbcCall.executeFunction(List.class, param);
    }

    @Override
    public String insertUpdateAccSpilit(RequestSaveSplitDTO req, String username, String choice, String choiceType) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE_2022_ACCUSED)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_accucode1",req.getAccucode1())
                .addValue("p_casecode1",req.getCasecode1())
                .addValue("p_accucode2",req.getAccucode2())
                .addValue("p_casecode2",req.getCasecode2())
                .addValue("p_splitdate", Utils.getSqlDate(req.getSplitdate()))
                .addValue("p_crtuser",username)
                .addValue("p_tvatype",choice)
                .addValue("p_choicetype",choiceType);
        Map result = jdbcCall.execute(param);
        return (String) result.get("return");
    }

    @Override
    public String deleteAccSpilit(RequestSaveSplitDTO req, String choiceType) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_SPP_ACCSPLIT_UPINFO)
                .withFunctionName(Constant.FUNCTION.FN_DELETE_SPLIT_2022_ACCUSED)
                .withReturnValue();

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_accucode1",req.getAccucode1())
                .addValue("p_casecode1",req.getCasecode1())
                .addValue("p_accucode2",req.getAccucode2())
                .addValue("p_casecode2",req.getCasecode2())
                .addValue("p_choicetype",choiceType);

        Map result = jdbcCall.execute(param);
        return (String) result.get("return");
    }


}
