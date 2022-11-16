package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstConclusionAutoCompleteDTO;
import com.bitsco.vks.dto.LstConclusionSearchDTO;
import com.bitsco.vks.repository.LstConclusionRepository;
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
public class LstConclusionRepositoryImpl implements LstConclusionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstConclusionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String concid, String concname, String userfor, String status) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstConclusionSearchDTO> rm = new SingleColumnRowMapper<LstConclusionSearchDTO>() {
            @Override
            public LstConclusionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstConclusionSearchDTO lstConclusionSearchDTO = new LstConclusionSearchDTO();
                lstConclusionSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstConclusionSearchDTO.setRnum(rs.getInt("RNUM"));

                lstConclusionSearchDTO.setConcid(rs.getString("CONCID"));
                lstConclusionSearchDTO.setConcname(rs.getString("CONCNAME"));
                lstConclusionSearchDTO.setUserfor(rs.getString("USERFOR"));
                lstConclusionSearchDTO.setStatus(rs.getString("STATUS"));
                lstConclusionSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstConclusionSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstConclusionSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstConclusionSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstConclusionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CONCLUTION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("P_SORTFIELD", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_concid", concid)
                .addValue("p_concname", concname)
                .addValue("p_userfor", userfor)
                .addValue("p_status", status);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstConclusionSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstConclusionAutoCompleteDTO> autocomplete(String query, String userfor) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstConclusionAutoCompleteDTO> rm = new SingleColumnRowMapper<LstConclusionAutoCompleteDTO>() {
            @Override
            public LstConclusionAutoCompleteDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstConclusionAutoCompleteDTO lstConclusionSearchDTO = new LstConclusionAutoCompleteDTO();
                lstConclusionSearchDTO.setConcid(rs.getString("CONCID"));
                lstConclusionSearchDTO.setConcname(rs.getString("CONCNAME"));
                return lstConclusionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CONCLUTION) //package name
                .withFunctionName(Constant.FUNCTION.FN_AUTOCOMPLETE)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_QUERY", StringCommon.isNullOrBlank(query) ? null : query)
                .addValue("P_USERFOR", userfor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstConclusionAutoCompleteDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public LstConclusionSearchDTO getConclu(String concid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstConclusionSearchDTO> rm = new SingleColumnRowMapper<LstConclusionSearchDTO>() {
            @Override
            public LstConclusionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstConclusionSearchDTO lstConclusionSearchDTO = new LstConclusionSearchDTO();
                lstConclusionSearchDTO.setConcid(rs.getString("CONCID"));
                lstConclusionSearchDTO.setConcname(rs.getString("CONCNAME"));
                lstConclusionSearchDTO.setUserfor(rs.getString("USERFOR"));
                lstConclusionSearchDTO.setStatus(rs.getString("STATUS"));
                lstConclusionSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstConclusionSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstConclusionSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstConclusionSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstConclusionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CONCLUTION) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_concid", concid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstConclusionSearchDTO>>) (Class) List.class, paramMap).stream().findFirst().orElse(new LstConclusionSearchDTO());
    }

    @Override
    public String save(String action, String concid, String concname, String userfor, String status, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_CONCLUTION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_concid", concid)
                    .addValue("p_concname", concname)
                    .addValue("p_status", status)
                    .addValue("p_userfor", userfor)
                    .addValue("p_user", username);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");

        }catch (Exception e){
            throw(e);
        }
    }

    @Override
    public String delete(String concid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_CONCLUTION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_concid", concid);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");

        }catch (Exception e){
            throw(e);
        }
    }
}
