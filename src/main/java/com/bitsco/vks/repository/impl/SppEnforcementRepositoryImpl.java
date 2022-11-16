package com.bitsco.vks.repository.impl;

import com.bitsco.vks.models.SppEnforceSaveRequest;
import com.bitsco.vks.repository.SppEnforcementRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class SppEnforcementRepositoryImpl implements SppEnforcementRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String save(SppEnforceSaveRequest _obj, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ENFORCEMENT") //package name
                .withFunctionName("fn_insert");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", _obj.action)
                .addValue("p_transcode", _obj.transcode)
                .addValue("p_regicode", _obj.regicode)
                .addValue("p_accucode", _obj.accucode)
                .addValue("p_transdate", Utils.getSqlDate(_obj.transdate))
                .addValue("p_sppidf", _obj.sppidf)
                .addValue("p_sppidt", _obj.sppidt)
                .addValue("p_sender", _obj.sender)
                .addValue("p_remark", _obj.remark)
                .addValue("p_acceptdate", Utils.getSqlDate(_obj.acceptdate))
                .addValue("p_casecode", _obj.casecode)
                .addValue("p_accuname", _obj.accuname)
                .addValue("p_casename", _obj.casename)
                .addValue("p_result", _obj.result)
                .addValue("p_decidate", Utils.getSqlDate(_obj.decidate))
                .addValue("p_decicode", _obj.decicode)
                .addValue("p_crtuser", username)
                .addValue("p_receipter", _obj.receipter)
                .addValue("p_reason", "Y".equals(_obj.result) ? _obj.reason : null);
        //First parameter is function output parameter type.
        Map res = jdbcCall.execute(paramMap);
        String _result = (String) res.get("return");
        return _result;
    }

    @Override
    public String delete(String casecode, String regicode, String accucode, String transcode, String action) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ENFORCEMENT")
                .withFunctionName("fn_delete");

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_casecode",casecode)
                .addValue("p_regicode",regicode)
                .addValue("p_accucode", accucode)
                .addValue("p_transcode",transcode)
                .addValue("p_check",action);

        Map res = jdbcCall.execute(param);
        String _result = (String) res.get("result");
        return _result;
    }
}