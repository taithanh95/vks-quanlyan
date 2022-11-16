package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAgainstSearchDTO;
import com.bitsco.vks.models.LstAgainstRequest;
import com.bitsco.vks.repository.LstAgainstRepository;
import com.bitsco.vks.utils.StringCommon;
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
public class LstAgainstRepositoryImpl implements LstAgainstRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstAgainstSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String againstid, String againstname, String applyfor, String setunit, String thoihan_tu, String thoihan_den) {

        SimpleJdbcCall jdbcCall;
        RowMapper<LstAgainstSearchDTO> rm = new SingleColumnRowMapper<LstAgainstSearchDTO>() {
            @Override
            public LstAgainstSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstAgainstSearchDTO lstAgainstSearchDTO = new LstAgainstSearchDTO();
                lstAgainstSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstAgainstSearchDTO.setRnum(rs.getInt("RNUM"));

                lstAgainstSearchDTO.setAgainstid(rs.getString("AGAINSTID"));
                lstAgainstSearchDTO.setAgainstname(rs.getString("AGAINSTNAME"));
                lstAgainstSearchDTO.setApplyfor(rs.getString("APPLYFOR"));
                lstAgainstSearchDTO.setSettime(rs.getInt("SETTIME"));
                lstAgainstSearchDTO.setSetunit(rs.getString("SETUNIT"));
                lstAgainstSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstAgainstSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstAgainstSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstAgainstSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstAgainstSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_id", againstid)
                .addValue("p_name", againstname)
                .addValue("p_applyfor", applyfor)
                .addValue("p_thoihan_tu", thoihan_tu)
                .addValue("p_thoihan_den", thoihan_den)
                .addValue("p_setunit", setunit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstAgainstSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(LstAgainstRequest req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_againstid", req.getAgainstid())
                    .addValue("p_againstname", req.getAgainstname())
                    .addValue("p_applyfor", req.getApplyfor())
                    .addValue("p_settime", req.getSettime())
                    .addValue("p_setunit", req.getSetunit())
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            String result = (String) _res.get("return");
            if (!StringCommon.isNullOrBlank(result)) new Exception(result);
            return result;
        } catch(Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String againstid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_AGAINST) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_id", againstid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch(Exception e) {
            throw(e);
        }
    }
}
