package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.LstRuleSearchDTO;
import com.bitsco.vks.models.LstRuleRequest;
import com.bitsco.vks.repository.LstRuleRepository;
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
public class LstRuleRepositoryImpl implements LstRuleRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstRuleSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String caseType, String userFor, String setUnit, String thoi_han_tu, String thoi_han_den) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstRuleSearchDTO> rm = new SingleColumnRowMapper<LstRuleSearchDTO>() {
            @Override
            public LstRuleSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstRuleSearchDTO lstRuleSearchDTO = new LstRuleSearchDTO();
                lstRuleSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstRuleSearchDTO.setRnum(rs.getInt("RNUM"));

                lstRuleSearchDTO.setCaseType(rs.getString("CASETYPE"));
                lstRuleSearchDTO.setUserFor(rs.getString("USERFOR"));
                lstRuleSearchDTO.setRuleTime(rs.getString("RULETIME"));
                lstRuleSearchDTO.setSetUnit(rs.getString("SETUNIT"));
                lstRuleSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstRuleSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstRuleSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstRuleSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstRuleSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_RULE) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_casetype", caseType)
                .addValue("p_userfor", userFor)
                .addValue("p_thoihan_tu", thoi_han_tu)
                .addValue("p_thoihan_den", thoi_han_den)
                .addValue("p_setunit", setUnit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstRuleSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(LstRuleRequest req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RULE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_casetype", req.getCaseType())
                    .addValue("p_userfor", req.getUserFor())
                    .addValue("p_ruletime", req.getRuleTime())
                    .addValue("p_setunit", req.getSetUnit())
                    .addValue("p_user", username);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String caseType, String userFor) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RULE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_casetype", caseType)
                    .addValue("p_userfor", userFor);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }
}
