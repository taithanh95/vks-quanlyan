package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.LstSigner;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LstSignerRepositoryImpl implements LstSignerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insert(String signname, String position, String polid, String officeid, String sppid, String userid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SIGNER") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_signname", signname)
                .addValue("p_position", position)
                .addValue("p_polid", polid)
                .addValue("p_officeid", officeid)
                .addValue("p_sppid", sppid)
                .addValue("p_user", userid)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstSigner> autocomplete(String query, String polid, String officeid, String sppid, int limit){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SIGNER") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_polid", polid.equals("SPC") ? Constants.DONVIRAQD_SPC : polid.equals("SPP") ? Constants.DONVIRAQD_SPP : polid)
                .addValue("p_officeid", officeid)
                .addValue("p_sppid", sppid)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSigner>>) (Class) List.class, paramMap);
    }

}
