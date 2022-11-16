package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.dto.LstLawGroupDTO;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.repository.LstLawGroupRepository;
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
 * Date: 12/05/2022
 * Time: 9:25 AM
 */
@Repository
public class LstLawGroupRepositoryImpl implements LstLawGroupRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<LstLawGroupDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String groupid, String groupname, String codeid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLawGroupDTO> rm = new SingleColumnRowMapper<LstLawGroupDTO>() {
            @Override
            public LstLawGroupDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLawGroupDTO lstCodeDTO = new LstLawGroupDTO();
                lstCodeDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstCodeDTO.setRNUM(rs.getInt("RNUM"));
                lstCodeDTO.setGROUPID(rs.getString("GROUPID"));
                lstCodeDTO.setGROUPNAME(rs.getString("GROUPNAME"));
                lstCodeDTO.setCODEID(rs.getString("CODEID"));
                lstCodeDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCodeDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCodeDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCodeDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstCodeDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUP)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_groupid", groupid)
                .addValue("p_groupname", groupname)
                .addValue("p_codeid", codeid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLawGroupDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstLawGroup req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUP)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_groupid", req.getGroupid())
                .addValue("p_groupname", req.getGroupname())
                .addValue("p_codeid", req.getCodeid())
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
    @Override
    public String delete(LstLawGroup req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUP)
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_groupid", req.getGroupid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
