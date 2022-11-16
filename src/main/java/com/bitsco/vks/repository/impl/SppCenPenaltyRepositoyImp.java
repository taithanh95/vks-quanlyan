package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppPenalty;
import com.bitsco.vks.models.SppCenPenaltySaveResponse;
import com.bitsco.vks.repository.SppCenPenaltyRepositoy;
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
public class SppCenPenaltyRepositoyImp implements SppCenPenaltyRepositoy {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SppPenalty> searchPenalty(String centcode, String lawcode, String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENALTY") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                .addValue("P_ACCUCODE", accucode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppPenalty>>)(Class)List.class, paramMap);
    }

    @Override
    public List<SppPenalty> searchPenaltySpp(String centcode, String lawcode, String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENSPP") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                .addValue("P_ACCUCODE", accucode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppPenalty>>)(Class)List.class, paramMap);
    }

    @Override
    public SppCenPenaltySaveResponse insertUpdCenPenalty(String regicode, String userId, String action, String accucode, String centcode, String lawcode, List<SppPenalty> list) {
        SppCenPenaltySaveResponse res = new SppCenPenaltySaveResponse();
        res.result = deleteAllPenalty(accucode,centcode,lawcode);
        if (!Utils.StringIsNullOrEmpty(res.getResult()))
            return res;

        if(!"D".equals(action)){
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CENLAWPENALTY") //package name
                    .withFunctionName("fn_insert_update_delete")
                    .withReturnValue();
            for(SppPenalty _obj : list){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_option",action)
                        .addValue("p_accucode",accucode)
                        .addValue("p_centcode",centcode)
                        .addValue("p_lawcode",lawcode)
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
                        .addValue("p_forced", _obj.isForced() ? "Y" : "N")
                        ;
                Map results = jdbcCall.execute(paramMap);
                res.result = (String) results.get("return");
                res.warning = (String) results.get("P_WARNING");
                if (!Utils.StringIsNullOrEmpty(res.result))
                    return res;
            }
        }
        insUpdTotalCentPenaly(accucode,centcode,regicode,userId);
        return res;
    }

    @Override
    public SppCenPenaltySaveResponse insertUpdCenPenaltySpp(String regicode, String userId, String action, String accucode, String centcode, String lawcode, List<SppPenalty> list) {
        SppCenPenaltySaveResponse res = new SppCenPenaltySaveResponse();
        res.result = deleteAllPenaltySpp(accucode,centcode,lawcode);
        if (!Utils.StringIsNullOrEmpty(res.getResult()))
            return res;

        if(!"D".equals(action)){
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CENLAWPENSPP") //package name
                    .withFunctionName("fn_insert_update_delete")
                    .withReturnValue();
            for(SppPenalty _obj : list){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_option",action)
                        .addValue("p_accucode",accucode)
                        .addValue("p_centcode",centcode)
                        .addValue("p_lawcode",lawcode)
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
                        .addValue("p_fday",_obj.getFday())
                        .addValue("p_tday",_obj.getTday())
                        .addValue("p_forced",_obj.isForced() ? "Y" : "N")
                        ;
                Map results = jdbcCall.execute(paramMap);
                res.result = (String) results.get("return");
                res.warning = (String) results.get("P_WARNING");
                if (!Utils.StringIsNullOrEmpty(res.result))
                    return res;
            }
        }
        insUpdTotalCentPenalySpp(accucode,centcode,regicode,userId);
        return res;
    }

    private String deleteAllPenalty(String accucode, String centcode, String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENALTY") //package name
                .withFunctionName("fn_deleteAll");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    private String deleteAllPenaltySpp(String accucode, String centcode, String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENSPP") //package name
                .withFunctionName("fn_deleteAll");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String insUpdTotalCentPenaly(String accucode, String centcode, String regicode,String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENALTY") //package name
                .withFunctionName("fn_update_totalcentpen");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_REGICODE", regicode)
                .addValue("P_CRTUSER", userId)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String insUpdTotalCentPenalySpp(String accucode, String centcode, String regicode,String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENLAWPENSPP") //package name
                .withFunctionName("fn_update_totalcentpen");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_REGICODE", regicode)
                .addValue("P_CRTUSER", userId)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

}
