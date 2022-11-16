package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.repository.SppUpdateAccusedRepository;
import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;
import java.util.Map;

@Repository
public class SppUpdateAccusedRepositoryImpl implements SppUpdateAccusedRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String insertDelete(List<SppAccused> sppAccusedsDeleted, List<SppAccused> sppAccusedsInserted, List<LstInspector> lstInspectorsDeleted
            , List<LstInspector> lstInspectorsInserted, String for_type){
        String result = null;
        result = delete(sppAccusedsDeleted, lstInspectorsDeleted, for_type);
        if (!Utils.StringIsNullOrEmpty(result))
            return result;
        insert(sppAccusedsInserted, lstInspectorsInserted, for_type);
        if (!Utils.StringIsNullOrEmpty(result))
            return result;
        return null;
    }

    private String insert(List<SppAccused> sppAccuseds, List<LstInspector> lstInspectors, String for_type){
        String _result = null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED_UPDATE") //package name
                .withFunctionName("fn_insert_update_delete")
                .withReturnValue();
        if (for_type.equalsIgnoreCase(Constants.FOR_BICAN)) {
            for(SppAccused _obj : sppAccuseds){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_accucode", _obj.getAccucode())
                        .addValue("p_regicode", _obj.getRegicode())
                        .addValue("p_status", _obj.getStatus())
                        .addValue("p_option", Constants.DML_INSERT)
                        .addValue("p_fortype", Constants.FOR_BICAN)
                        ;
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
        }else if (for_type.equalsIgnoreCase(Constants.FOR_NTL)) {
            for(LstInspector _obj : lstInspectors){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_accucode", _obj.getInspcode())
                        .addValue("p_regicode", _obj.getRegicode())
                        .addValue("p_status", _obj.getStatus())
                        .addValue("p_option", Constants.DML_INSERT)
                        .addValue("p_fortype", Constants.FOR_BICAN)
                        ;
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
        }

        return _result;
    }
    private String delete(List<SppAccused> sppAccuseds, List<LstInspector> lstInspectors, String for_type){
        String _result = null;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED_UPDATE") //package name
                .withFunctionName("fn_insert_update_delete")
                .withReturnValue();
        if (for_type.equalsIgnoreCase(Constants.FOR_BICAN)) {
            for(SppAccused _obj : sppAccuseds){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_accucode", _obj.getAccucode())
                        .addValue("p_regicode", _obj.getRegicode())
                        .addValue("p_status", _obj.getStatus())
                        .addValue("p_option", Constants.DML_DELETE)
                        .addValue("p_fortype", Constants.FOR_BICAN)
                        ;
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
        }else if (for_type.equalsIgnoreCase(Constants.FOR_NTL)) {
            for(LstInspector _obj : lstInspectors){
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_accucode", _obj.getInspcode())
                        .addValue("p_regicode", _obj.getRegicode())
                        .addValue("p_status", _obj.getStatus())
                        .addValue("p_option", Constants.DML_DELETE)
                        .addValue("p_fortype", Constants.FOR_BICAN)
                        ;
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
        }

        return _result;
    }
}
