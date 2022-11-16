package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstAppealSearchDTO;
import com.bitsco.vks.models.LstAppealRequest;
import com.bitsco.vks.repository.LstAppealRepository;
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
public class LstAppealRepositoryImpl implements LstAppealRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstAppealSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String appealid, String appealname) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstAppealSearchDTO> rm = new SingleColumnRowMapper<LstAppealSearchDTO>() {
            @Override
            public LstAppealSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstAppealSearchDTO lstAppealSearchDTO = new LstAppealSearchDTO();
                lstAppealSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstAppealSearchDTO.setRnum(rs.getInt("RNUM"));

                lstAppealSearchDTO.setAppealid(rs.getString("APPEALID"));
                lstAppealSearchDTO.setAppealname(rs.getString("APPEALNAME"));
                lstAppealSearchDTO.setSettime(rs.getInt("SETTIME"));
                lstAppealSearchDTO.setSetunit(rs.getString("SETUNIT"));
                lstAppealSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstAppealSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstAppealSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstAppealSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstAppealSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_APPEAL) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_appealid", appealid)
                .addValue("p_appealname", appealname);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstAppealSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(LstAppealRequest req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_APPEAL) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_appealid", req.getAppealid())
                    .addValue("p_appealname", req.getAppealname())
                    .addValue("p_settime", req.getSettime())
                    .addValue("p_setunit", req.getSetunit())
                    .addValue("p_crtuser", username);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e)  {
            throw(e);
        }
    }

    @Override
    public String delete(String appealid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_APPEAL) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_appealid", appealid);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e)  {
            throw(e);
        }
    }
}
