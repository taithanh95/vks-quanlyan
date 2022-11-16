package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.repository.LstCountryRepository;
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

@Repository
public class LstCountryRepositoryImpl implements LstCountryRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstCountrySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String counId, String counName, String remark) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstCountrySearchDTO> rm = new SingleColumnRowMapper<LstCountrySearchDTO>() {
            @Override
            public LstCountrySearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstCountrySearchDTO lstCountrySearchDTO = new LstCountrySearchDTO();
                lstCountrySearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstCountrySearchDTO.setRNUM(rs.getInt("RNUM"));
                lstCountrySearchDTO.setCOUNID(rs.getString("COUNID"));
                lstCountrySearchDTO.setCOUNNAME(rs.getString("COUNNAME"));
                lstCountrySearchDTO.setREMARK(rs.getString("REMARK"));
                lstCountrySearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCountrySearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCountrySearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCountrySearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstCountrySearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_COUNTRY) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_counid", counId)
                .addValue("p_counname", counName)
                .addValue("p_remark", remark);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCountrySearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String counid, String counname, String remark, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_COUNTRY) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_counid", counid)
                    .addValue("p_counname", counname)
                    .addValue("p_remark", remark)
                    .addValue("p_crtuser", username);
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String counid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_COUNTRY) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_counid", counid);
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<LstCountrySearchDTO> getCountry(String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_COUNTRY) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCountrySearchDTO>>) (Class) List.class, paramMap);
    }
}
