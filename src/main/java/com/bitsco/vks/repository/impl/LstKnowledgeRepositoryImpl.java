package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstKnowledgeSearchDTO;
import com.bitsco.vks.repository.LstKnowledgeRepository;
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
public class LstKnowledgeRepositoryImpl implements LstKnowledgeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstKnowledgeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String levelid, String levelname) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstKnowledgeSearchDTO> rm = new SingleColumnRowMapper<LstKnowledgeSearchDTO>() {
            @Override
            public LstKnowledgeSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstKnowledgeSearchDTO lstKnowledgeSearchDTO = new LstKnowledgeSearchDTO();
                lstKnowledgeSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstKnowledgeSearchDTO.setRnum(rs.getInt("RNUM"));

                lstKnowledgeSearchDTO.setLevelid(rs.getString("LEVELID"));
                lstKnowledgeSearchDTO.setLevelname(rs.getString("LEVELNAME"));
                lstKnowledgeSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstKnowledgeSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstKnowledgeSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstKnowledgeSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstKnowledgeSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_KNOWLEDGE") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_levelid", levelid)
                .addValue("p_levelname", levelname);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstKnowledgeSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String levelid, String levelname, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_KNOWLEDGE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_levelid", levelid)
                    .addValue("p_levelname", levelname)
                    .addValue("p_crtuser", username);
            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String levelid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_KNOWLEDGE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_levelid", levelid);
            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }
}
