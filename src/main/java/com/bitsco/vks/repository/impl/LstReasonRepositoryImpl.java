package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstReasonSearchDTO;
import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.entity.LstReason;
import com.bitsco.vks.repository.LstReasonRepository;
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
public class LstReasonRepositoryImpl implements LstReasonRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstReasonSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String reasonId, String reasonName, String deciId) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstReasonSearchDTO> rm = new SingleColumnRowMapper<LstReasonSearchDTO>() {
            @Override
            public LstReasonSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstReasonSearchDTO lstReasonSearchDTO = new LstReasonSearchDTO();
                lstReasonSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstReasonSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstReasonSearchDTO.setREASONID(rs.getString("REASONID"));
                lstReasonSearchDTO.setREASONNAME(rs.getString("REASONNAME"));
                lstReasonSearchDTO.setDECIID(rs.getString("DECIID"));
                lstReasonSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstReasonSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstReasonSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstReasonSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstReasonSearchDTO.setDECINAME(rs.getString("DECINAME"));
                return lstReasonSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_REASON) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_reasonid", reasonId)
                .addValue("p_reasonname", reasonName)
                .addValue("p_deciid", deciId);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstReasonSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstReason> loadLstReason(String usefor, String applyfor, String deciid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_REASON) //package name
                .withFunctionName(Constant.FUNCTION.FN_LOADLSTREASON_HS);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_userfor", usefor)
                .addValue("p_applyfor", applyfor)
                .addValue("p_deciid", deciid)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstReason>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String reasonid, String reasonname, String deciid, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_REASON) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_reasonid", reasonid)
                    .addValue("p_reasonname", reasonname)
                    .addValue("p_deciid", deciid)
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String reasonid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_REASON) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_reasonid", reasonid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }


}
