package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.PreventMeasures;
import com.bitsco.vks.repository.PreventMeasuresRepository;
import com.bitsco.vks.utils.Utils;
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
 * Date: 20/01/2022
 * Time: 4:45 PM
 */
@Repository
public class PreventMeasuresRepositoryImpl implements PreventMeasuresRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PreventMeasures> search(PreventMeasures preventMeasures) {
        RowMapper<PreventMeasures> rm = new SingleColumnRowMapper<PreventMeasures>() {
            @Override
            public PreventMeasures mapRow(ResultSet rs, int rowNum) throws SQLException {
                PreventMeasures response = new PreventMeasures();
                response.setMeasuresId(rs.getLong("measuresid"));
                response.setMeasuresName(rs.getString("measuresname"));
                response.setAccucode(rs.getString("accucode"));
                response.setMeasuresDate(rs.getDate("measuresdate"));
                response.setReason(rs.getString("reason"));
                return response;
            }
        };
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_PREVENT_MEASURES")
                    .withFunctionName("fn_searchbyaccucode")
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_accucode", preventMeasures.getAccucode());

            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<PreventMeasures>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String insertOrUpdate(PreventMeasures preventMeasures, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_PREVENT_MEASURES")
                .withFunctionName("fn_insert_update");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_measures_id", preventMeasures.getMeasuresId())
                .addValue("p_measures_name", preventMeasures.getMeasuresName())
                .addValue("p_measures_date", Utils.getSqlDate(preventMeasures.getMeasuresDate()))
                .addValue("p_reason", preventMeasures.getReason())
                .addValue("p_accucode", preventMeasures.getAccucode())
                .addValue("p_created_at", Utils.getSqlDate(preventMeasures.getCreatedAt()))
                .addValue("p_created_by", preventMeasures.getCreatedBy())
                .addValue("p_updated_at", Utils.getSqlDate(preventMeasures.getUpdatedAt()))
                .addValue("p_updated_by", preventMeasures.getUpdatedBy())
                .addValue("p_option", preventMeasures.getOption());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String delete(String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_PREVENT_MEASURES")
                .withFunctionName("fn_delete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_accucode", accucode);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }
}
