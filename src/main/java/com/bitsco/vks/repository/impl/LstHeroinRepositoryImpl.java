package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstHeroin;
import com.bitsco.vks.repository.LstHeroinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class LstHeroinRepositoryImpl implements LstHeroinRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstHeroin> getall() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_HEROIN") //package name
                .withFunctionName("fn_getall");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", "");

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstHeroin>>) (Class) List.class, paramMap);
    }
}
