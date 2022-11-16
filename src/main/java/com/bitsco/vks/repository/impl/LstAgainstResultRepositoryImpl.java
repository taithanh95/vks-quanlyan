package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAgainstResultSearchDTO;
import com.bitsco.vks.repository.LstAgainstResultRepository;
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
public class LstAgainstResultRepositoryImpl implements LstAgainstResultRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstAgainstResultSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String resultid, String resultname) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstAgainstResultSearchDTO> rm = new SingleColumnRowMapper<LstAgainstResultSearchDTO>() {
            @Override
            public LstAgainstResultSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstAgainstResultSearchDTO lstAgainstResultSearchDTO = new LstAgainstResultSearchDTO();
                lstAgainstResultSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstAgainstResultSearchDTO.setRnum(rs.getInt("RNUM"));

                lstAgainstResultSearchDTO.setResultid(rs.getString("RESULTID"));
                lstAgainstResultSearchDTO.setResultname(rs.getString("RESULTNAME"));
                lstAgainstResultSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstAgainstResultSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstAgainstResultSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstAgainstResultSearchDTO.setMdfuser(rs.getString("MDFUSER"));

                return lstAgainstResultSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST_RESULT) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_id", resultid)
                .addValue("p_name", resultname);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstAgainstResultSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String resultid, String resultname, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST_RESULT) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_id", resultid)
                    .addValue("p_name", resultname)
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch(Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String resultid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST_RESULT) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_id", resultid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch(Exception e) {
            throw(e);
        }
    }
}
