package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.repository.LstNationRepository;
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
public class LstNationRepositoryImpl implements LstNationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstNationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String natiId, String name) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstNationSearchDTO> rm = new SingleColumnRowMapper<LstNationSearchDTO>() {
            @Override
            public LstNationSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstNationSearchDTO lstNationSearchDTO = new LstNationSearchDTO();
                lstNationSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstNationSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstNationSearchDTO.setNATIID(rs.getString("NATIID"));
                lstNationSearchDTO.setNAME(rs.getString("NAME"));
                lstNationSearchDTO.setREMARK(rs.getString("REMARK"));
                lstNationSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstNationSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstNationSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstNationSearchDTO.setMDFDATE(rs.getString("MDFDATE"));;
                return lstNationSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_NATION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_natiid", natiId)
                .addValue("p_name", name);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstNationSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String natiid, String name, String remark, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_NATION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("P_action", action)
                    .addValue("p_natiid", natiid)
                    .addValue("p_name", name)
                    .addValue("p_remark", remark)
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String natiid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_NATION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_natiid", natiid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<LstNationSearchDTO> getNation(String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_NATION) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstNationSearchDTO>>) (Class) List.class, paramMap);
    }

}
