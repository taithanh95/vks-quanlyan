package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstResolveSearchDTO;
import com.bitsco.vks.repository.LstResolveRepository;
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
public class LstResolveRepositoryImpl implements LstResolveRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstResolveSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String resolid, String resolname, String state) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstResolveSearchDTO> rm = new SingleColumnRowMapper<LstResolveSearchDTO>() {
            @Override
            public LstResolveSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstResolveSearchDTO lstResolveSearchDTO = new LstResolveSearchDTO();
                lstResolveSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstResolveSearchDTO.setRnum(rs.getInt("RNUM"));

                lstResolveSearchDTO.setResolid(rs.getString("RESOLID"));
                lstResolveSearchDTO.setResolname(rs.getString("RESOLNAME"));
                lstResolveSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstResolveSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstResolveSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstResolveSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstResolveSearchDTO.setState(rs.getString("STATE"));
                return lstResolveSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_RESOLVE) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_resolid", resolid)
                .addValue("p_resolname", resolname)
                .addValue("p_state", state);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstResolveSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String resolid, String resolname, String state, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RESOLVE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_resolid", resolid)
                    .addValue("p_resolname", resolname)
                    .addValue("p_state", state)
                    .addValue("p_crtuser", username);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String resolid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RESOLVE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_resolid", resolid);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }
}
