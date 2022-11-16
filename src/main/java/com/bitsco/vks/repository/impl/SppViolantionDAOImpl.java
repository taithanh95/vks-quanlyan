package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppViolantion;
import com.bitsco.vks.repository.SppViolantionDAO;
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

@Repository
public class SppViolantionDAOImpl implements SppViolantionDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void save(SppViolantion sppViolantion) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_VIOLANTION") //package name
                .withProcedureName("fn_insert");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_id", sppViolantion.getId())
                .addValue("p_casecode", sppViolantion.getCaseCode())
                .addValue("p_accucode", sppViolantion.getAccuCode())
                .addValue("p_violcode", sppViolantion.getViolcode())
                .addValue("p_typename", sppViolantion.getTypeName())
                .addValue("p_dateofviolation", sppViolantion.getDateOfViolation())
                .addValue("p_timeofviolation", sppViolantion.getTimeOfViolation())
                .addValue("p_contentviolations", sppViolantion.getContentViolations())
                .addValue("p_processing", sppViolantion.getProcessing())
                .addValue("p_typeofviolations", sppViolantion.getTypeOfViolations());
        jdbcCall.execute(paramMap);
    }

    @Override
    public List<SppViolantion> getSppViolantionByAccucode(String accucode) {
        SimpleJdbcCall jdbcCall;
        RowMapper<SppViolantion> rm = new SingleColumnRowMapper<SppViolantion>() {
            @Override
            public SppViolantion mapRow(ResultSet rs, int rowNum) throws SQLException {
                SppViolantion response = new SppViolantion();
                response.setId(rs.getLong("ID"));
                response.setCaseCode(rs.getString("CASECODE"));
                response.setAccuCode(rs.getString("ACCUCODE"));
                response.setViolcode(rs.getString("VIOLCODE"));
                response.setTypeName(rs.getString("TYPE_NAME"));
                response.setDateOfViolation(rs.getDate("DATE_OF_VIOLATION"));
                response.setTimeOfViolation(rs.getInt("TIME_OF_VIOLATION"));
                response.setContentViolations(rs.getString("CONTENT_VIOLATIONS"));
                response.setProcessing(rs.getString("PROCESSING"));
                response.setTypeOfViolations(rs.getInt("TYPE_OF_VIOLATIONS"));
                return response;
            }
        };
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_VIOLANTION")
                    .withFunctionName("fn_get_by_accucode")
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_accucode", accucode);
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<SppViolantion>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteById(Long id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_VIOLANTION") //package name
                .withProcedureName("fn_delete_by_id");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_id", id);
        jdbcCall.execute(paramMap);
    }
}
