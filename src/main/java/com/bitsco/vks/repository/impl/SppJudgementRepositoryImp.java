package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppJudgementSaveResponse;
import com.bitsco.vks.repository.SppJudgementRepository;
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
public class SppJudgementRepositoryImp implements SppJudgementRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SppPenalty> searchPenalty(String regicode, String centcode, String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_JUDGEMENT") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_ACCUCODE", accucode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppPenalty>>)(Class) List.class, paramMap);
    }

    @Override
    public List<SppPenalty> searchPenatltySPP(String regicode, String centcode, String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_JUDGEMENTSPP") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_ACCUCODE", accucode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppPenalty>>)(Class) List.class, paramMap);
    }

    @Override
    public SppJudgementSaveResponse insertUpdJudgement(String regicode, String userId, String action, String accucode, String centcode, List<SppPenalty> list) {
        SppJudgementSaveResponse res = new SppJudgementSaveResponse();
        res.result = deleteAllPenalty(accucode,centcode,regicode);
        if (!Utils.StringIsNullOrEmpty(res.getResult()))
            return res;
        if(!"D".equals(action)){
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_JUDGEMENT") //package name
                    .withFunctionName("fn_insert_update_delete")
                    .withReturnValue();
            for(SppPenalty _obj : list){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_option",action)
                        .addValue("p_accucode",accucode)
                        .addValue("p_centcode",centcode)
                        .addValue("p_regicode",regicode)
                        .addValue("p_penaltyid",_obj.getPenaltyid())
                        .addValue("p_numyear",_obj.getNumyear())
                        .addValue("p_nummonth",_obj.getNummonth())
                        .addValue("p_numday",_obj.getNumday())
                        .addValue("p_nummoney",_obj.getNummoney())
                        .addValue("p_fyear",_obj.getFyear())
                        .addValue("p_fmonth",_obj.getFmonth())
                        .addValue("p_tyear",_obj.getTyear())
                        .addValue("p_tmonth",_obj.getTmonth())
                        .addValue("p_numyeartest",_obj.getNumyeartest())
                        .addValue("p_nummonthtest",_obj.getNummonthtest())
                        .addValue("p_numdaytest",_obj.getNumdaytest())
                        .addValue("p_crtuser",userId)
                        .addValue("p_suspended",_obj.isSuspended() ? "Y" : "N")
                        ;
                Map results = jdbcCall.execute(paramMap);
                res.result = (String) results.get("result");
                res.warning = (String) results.get("warning");
                if (!Utils.StringIsNullOrEmpty(res.getResult()))
                    return res;
            }
        }
        return res;
    }

    @Override
    public SppJudgementSaveResponse insertUpdJudgementSpp(String regicode, String userId, String action, String accucode, String centcode, List<SppPenalty> list) {
        SppJudgementSaveResponse res = new SppJudgementSaveResponse();
        res.result = deleteAllPenaltySpp(accucode,centcode,regicode);
        if (!Utils.StringIsNullOrEmpty(res.getResult()))
            return res;
        if(!"D".equals(action)){
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_JUDGEMENTSPP") //package name
                    .withFunctionName("fn_insert_update_delete")
                    .withReturnValue();
            for(SppPenalty _obj : list){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_option",action)
                        .addValue("p_accucode",accucode)
                        .addValue("p_centcode",centcode)
                        .addValue("p_regicode",regicode)
                        .addValue("p_penaltyid",_obj.getPenaltyid())
                        .addValue("p_numyear",_obj.getNumyear())
                        .addValue("p_nummonth",_obj.getNummonth())
                        .addValue("p_numday",_obj.getNumday())
                        .addValue("p_nummoney",_obj.getNummoney())
                        .addValue("p_fyear",_obj.getFyear())
                        .addValue("p_fmonth",_obj.getFmonth())
                        .addValue("p_tyear",_obj.getTyear())
                        .addValue("p_tmonth",_obj.getTmonth())
                        .addValue("p_fyeartest",_obj.getFyeartest())
                        .addValue("p_fmonthtest",_obj.getFmonthtest())
                        .addValue("p_tyeartest",_obj.getTyeartest())
                        .addValue("p_tmonthtest",_obj.getTmonthtest())
                        .addValue("p_crtuser",userId)
                        .addValue("p_suspended",_obj.isSuspended() ? "Y" : "N")
                        .addValue("p_tmoney",_obj.getTmoney())
                        ;
                Map results = jdbcCall.execute(paramMap);
                res.result = (String) results.get("result");
                res.warning = (String) results.get("warning");
                if (!Utils.StringIsNullOrEmpty(res.result))
                    return res;
            }
        }
        return res;
    }

    private String deleteAllPenalty(String accucode, String centcode, String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_JUDGEMENT") //package name
                .withFunctionName("fn_deleteAll");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    private String deleteAllPenaltySpp(String accucode, String centcode, String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_JUDGEMENTSPP") //package name
                .withFunctionName("fn_deleteAll");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
