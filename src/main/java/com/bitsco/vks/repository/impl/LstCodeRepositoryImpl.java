package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCodeDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.repository.LstCodeRepository;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:26 PM
 */
@Repository
public class LstCodeRepositoryImpl implements LstCodeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstCodeDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String codeid, String codename) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstCodeDTO> rm = new SingleColumnRowMapper<LstCodeDTO>() {
            @Override
            public LstCodeDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstCodeDTO lstCodeDTO = new LstCodeDTO();
                lstCodeDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstCodeDTO.setRNUM(rs.getInt("RNUM"));
                lstCodeDTO.setCODEID(rs.getString("CODEID"));
                lstCodeDTO.setCODENAME(rs.getString("CODENAME"));
                lstCodeDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCodeDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCodeDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCodeDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstCodeDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CODE)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_codeid", codeid)
                .addValue("p_codename", codename);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCodeDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstCode req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CODE)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_codeid", req.getCodeid())
                .addValue("p_codename", req.getCodeName())
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstCode req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CODE)
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_codeid", req.getCodeid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstCode> autocomplete(String query, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CODE) //package name
                .withFunctionName(Constant.FUNCTION.FN_AUTOCOMPLETE);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCode>>) (Class) List.class, paramMap);
    }
}
