package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.StatisticaRequestDTO;
import com.bitsco.vks.repository.LstStatisticaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;
import java.util.Map;

@Repository
public class LstStatisticaRepositoryImpl implements LstStatisticaRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(int rowIndex, int pageSize, StatisticaRequestDTO req) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_STATISTICA)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH);
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", rowIndex)
                    .addValue("p_pagesize", pageSize)
                    .addValue("p_sortfield", req.sortField)
                    .addValue("p_sortorder", req.sortOrder)
                    .addValue("p_statid", req.getStatid())
                    .addValue("p_statname", req.getStatname())
                    .addValue("p_status", req.getStatus());

            return jdbcCall.executeFunction(List.class, param);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String save(StatisticaRequestDTO req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_STATISTICA)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                    .withReturnValue();

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_statid", req.getStatid())
                    .addValue("p_statname", req.getStatname())
                    .addValue("p_status", req.getStatus())
                    .addValue("p_children", req.getChildren())
                    .addValue("p_adult", req.getAdult())
                    .addValue("p_crtuser", username);
            Map _result  = jdbcCall.execute(param);
            return (String) _result.get("return");
        }catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String statid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_STATISTICA)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE)
                    .withReturnValue();

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_statid", statid);
            Map _result  = jdbcCall.execute(param);
            return (String) _result.get("return");
        }catch (Exception e) {
            throw(e);
        }
    }
}
