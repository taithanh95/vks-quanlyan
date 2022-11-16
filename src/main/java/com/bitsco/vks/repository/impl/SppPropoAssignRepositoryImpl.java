package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppPropoAssignEntity;
import com.bitsco.vks.repository.SppPropoAssignRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SppPropoAssignRepositoryImpl implements SppPropoAssignRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertUpdate(String action, String sppId, SppPropoAssignEntity bean){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_PROPOASSIGN") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        String pos = "";
        if (bean.getPosition_type().equalsIgnoreCase("KS"))
            pos = bean.getPosition_ksv();
        else
            pos = bean.getPosition_type();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_inspcode", bean.getAtxtIns() != null ? bean.getAtxtIns().getInspcode() : "")
                .addValue("p_assignins", bean.getAtxtAssignIns() != null ? bean.getAtxtAssignIns().getInspcode() : "")
                .addValue("p_assigndate", Utils.getSqlDate(bean.getAssigndate()))
                .addValue("p_setnum", bean.getSetnum())
                .addValue("p_position", pos)
                .addValue("p_regicode", bean.getRegicode())
                .addValue("p_user", sppId)
                .addValue("p_finishdate", Utils.getSqlDate(bean.getFinishdate()))
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String delete(String inspcode, String regicode, String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED_UPDATE") //package name
                .withFunctionName("fn_delete_ins")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_inspcode", inspcode)
                .addValue("p_regicode", regicode)
                .addValue("p_casecode", casecode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }
}
