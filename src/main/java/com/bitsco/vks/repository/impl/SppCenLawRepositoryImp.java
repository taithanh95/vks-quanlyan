package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.SppCenLawDeleteRequest;
import com.bitsco.vks.models.SppCenLawSaveRequest;
import com.bitsco.vks.models.SppStattisticaSaveRequest;
import com.bitsco.vks.repository.SppCenLawRepository;
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
public class SppCenLawRepositoryImp implements SppCenLawRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> searchFromAccuUpdateInfo(String regicode, String centcode, String accucode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAW") //package name
                .withFunctionName("GET_FROM_ACCUCODE_UDINF");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_USERFOR", userfor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public String insertCenLawUpdateInfo(SppCenLawSaveRequest req, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAW") //package name
                .withFunctionName("FN_INSERT_UDINF")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", req.getRegicode())
                .addValue("P_CENTCODE", req.getCentcode())
                .addValue("P_LAWCODE", req.getLawcode())
                .addValue("P_ACCUCODE", req.getAccucode())
                .addValue("P_USERFOR", req.getUserfor())
                .addValue("P_CRTUSER", userid)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String deleteCenlaw(SppCenLawDeleteRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAW") //package name
                .withFunctionName("FN_DELETE")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", req.getCentcode())
                .addValue("P_LAWCODE", req.getLawcode())
                .addValue("P_ACCUCODE", req.getAccucode())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String updateStatica(SppStattisticaSaveRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAW") //package name
                .withFunctionName("FN_UPDATE_FROM_STATICA_UDINF")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", req.getRegicode())
                .addValue("P_CENTCODE", req.getCentcode())
                .addValue("P_LAWCODE", req.getLawcode())
                .addValue("P_ACCUCODE", req.getAccucode())
                .addValue("P_CRIMWHERE", req.getLocaid())
                .addValue("P_CRIMDATE", req.getCrimdate())
                .addValue("P_CRIMTIME", req.getCrimtime())
                .addValue("P_USERFOR", req.getUserfor())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCenLaw(int rowIndex, int pageSize, String sortField, String sortOrder,
                                                       LstLaw lawFilters,String centcode, String regicode, String accucode,
                                                       String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAW") //package name
                .withFunctionName("FN_SEARCH_LAW_UDINF");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", "ASC".equals(sortOrder) ? "ASC" : "DESC")
                .addValue("p_lawid", Utils.StringIsNullOrEmpty(lawFilters.getLawid()) ? null : lawFilters.getLawid().trim())
                .addValue("p_item", Utils.StringIsNullOrEmpty(lawFilters.getItem()) ? null : lawFilters.getItem().trim())
                .addValue("p_point", Utils.StringIsNullOrEmpty(lawFilters.getPoint()) ? null : lawFilters.getPoint().trim())
                .addValue("p_lawname", Utils.StringIsNullOrEmpty(lawFilters.getLawname()) ? null : lawFilters.getLawname().trim())
                .addValue("p_groupid", Utils.StringIsNullOrEmpty(lawFilters.getGroupid()) ? null : lawFilters.getGroupid().trim())
                .addValue("p_codeid", Utils.StringIsNullOrEmpty(lawFilters.getCodeid()) ? null : lawFilters.getCodeid().trim())
                .addValue("p_fromdate",lawFilters.getFromdate() == null ? null : Utils.convertDateToString(lawFilters.getFromdate(),"YYYY-MM-dd"))
                .addValue("p_todate",lawFilters.getTodate() == null ? null :Utils.convertDateToString(lawFilters.getTodate(),"YYYY-MM-dd"))
                .addValue("p_regicode", regicode)
                .addValue("p_centcode", centcode)
                .addValue("p_accucode", accucode)
                .addValue("p_userfor", userfor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }
}
