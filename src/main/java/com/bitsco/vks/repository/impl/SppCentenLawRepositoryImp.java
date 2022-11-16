package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.models.SppCentenLawSaveRequest;
import com.bitsco.vks.repository.SppCentenLawRepository;
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
import java.util.Map;

@Repository
public class SppCentenLawRepositoryImp implements SppCentenLawRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertOrDelCentenLawUpdateInfo(SppCentenLawSaveRequest req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENLAW") //package name
                .withFunctionName("FN_INSERT_DELETE")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACTION", req.getAction())
                .addValue("P_CENTCODE", req.getCentcode())
                .addValue("P_LAWCODE", req.getLawcode())
                .addValue("P_CRTUSER", username)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCentenLaw(String centcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENLAW") //package name
                .withFunctionName("FN_GET");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchList(String centcode, LstLaw req, int index, int pageSize, String sortField, String sortOrder) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENLAW")
                .withFunctionName("FN_SEARCH_LAW");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex",index)
                .addValue("p_pagesize",pageSize)
                .addValue("p_sortfield",sortField)
                .addValue("p_sortorder","ASC".equals(sortOrder) ? "ASC" : "DESC")
                .addValue("p_lawid", StringCommon.isNullOrBlank(req.getLawid()) ? null : req.getLawid().trim())
                .addValue("p_item",StringCommon.isNullOrBlank(req.getItem()) ? null : req.getItem().trim())
                .addValue("p_point",StringCommon.isNullOrBlank(req.getPoint()) ? null : req.getPoint().trim())
                .addValue("p_lawname",StringCommon.isNullOrBlank(req.getLawname()) ? null : req.getLawname().trim())
                .addValue("p_groupid",StringCommon.isNullOrBlank(req.getGroupid()) ? null : req.getGroupid().trim())
                .addValue("p_codeid",StringCommon.isNullOrBlank(req.getCodeid()) ? null : req.getCodeid().trim())
                .addValue("p_fromdate", req.getFromdate() == null ? null : Utils.convertDateToString(req.getFromdate(),"yyyy-MM-dd"))
                .addValue("p_todate", req.getTodate() == null ? null : Utils.convertDateToString(req.getTodate(),"yyyy-MM-dd"))
                .addValue("p_centcode",centcode);

        return jdbcCall.executeFunction(List.class, paramMap);
    }
}
