package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPenaltyDTO;
import com.bitsco.vks.entity.LstPenalty;
import com.bitsco.vks.repository.LstPenaltyRepository;
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
 * Date: 16/05/2022
 * Time: 3:27 PM
 */
@Repository
public class LstPenaltyRepositoryImpl implements LstPenaltyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstPenaltyDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String penaltyid, String penaltyname, String penaltyfor) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPenaltyDTO> rm = new SingleColumnRowMapper<LstPenaltyDTO>() {
            @Override
            public LstPenaltyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPenaltyDTO lstPenaltyDTO = new LstPenaltyDTO();
                lstPenaltyDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstPenaltyDTO.setRNUM(rs.getInt("RNUM"));
                lstPenaltyDTO.setPENALTYID(rs.getString("PENALTYID"));
                lstPenaltyDTO.setPENALTYNAME(rs.getString("PENALTYNAME"));
                lstPenaltyDTO.setPENALTYFOR(rs.getString("PENALTYFOR"));
                lstPenaltyDTO.setSTATUS(rs.getString("STATUS"));
                lstPenaltyDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstPenaltyDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstPenaltyDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstPenaltyDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstPenaltyDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PENALTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_penaltyid", penaltyid)
                .addValue("p_penaltyname", penaltyname)
                .addValue("p_penaltyfor", penaltyfor);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPenaltyDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstPenalty req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PENALTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_penaltyid", req.getPenaltyid())
                .addValue("p_penaltyname", req.getPenaltyname())
                .addValue("p_status", req.getStatus())
                .addValue("p_penaltyfor", req.getPenaltyfor())
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstPenalty req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PENALTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_penaltyid", req.getPenaltyid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstPenalty> getListPenalty(String query, Integer rownum) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PENALTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_rownum", rownum);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPenalty>>) (Class) List.class, paramMap);
    }
}
