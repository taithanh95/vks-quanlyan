package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppDecision;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.repository.SppDecisionRepository;
import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;
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
public class SppDecisionRepositoryImpl implements SppDecisionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private LstSignerRepository lstSignerRepository;

    @Override
    public List<SppDecision> search(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String applyfor, String casecode, String usefor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_Rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("P_Sortcol", sortField)
                .addValue("P_Sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("P_Regicode", regicode)
                .addValue("p_applyfor", applyfor)
                .addValue("p_casecode", casecode)
                .addValue("p_usefor", usefor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppDecision>>)(Class)List.class, paramMap);
    }

    @Override
    public List<LstDecisionEntity> searchDecitypeHS(String applyfor, String userfor){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_DECITYPE") //package name
                .withFunctionName("fn_search_decitype");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_APPLYFOR", applyfor)
                .addValue("p_userfor", userfor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionEntity>>)(Class)List.class, paramMap);
    }

    @Override
    public List<LstDecisionEntity> search_gh(String usefor, String applyfor, String deciid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("fn_gia_han");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_usefor", usefor)
                .addValue("P_Applyfor", applyfor)
                .addValue("p_deciid", deciid)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionEntity>>)(Class)List.class, paramMap);
    }

    @Override
    public String deleteAcc(String decicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION_ACC") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();


        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_decicode", decicode)
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(SppDecision _obj) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();


        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_Decicode", _obj.getDecicode())
                .addValue("P_Deciid", _obj.getDeciid())
                .addValue("P_Indate", Utils.getSqlDate(_obj.getIndate()))
                .addValue("p_regicode", _obj.getRegicode())
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromdate()))
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String insertUpdate(String action, SppDecision _obj, String userid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("insert_update_delete")
                .withReturnValue();

        String idcode =
                _obj.getBegin_office().equalsIgnoreCase("SPP") ? _obj.getAtxSpp().getSppid() : _obj.getBegin_office().equalsIgnoreCase("SPC") ?
                        _obj.getAtxSpc().getSpcid() :
                        _obj.getBegin_office().equalsIgnoreCase("02") ?
                                _obj.getAtxPolice().getPoliceid() :
                                _obj.getBegin_office().equalsIgnoreCase("04") ?
                                        _obj.getAtxArmy().getArmyid() :
                                        _obj.getBegin_office().equalsIgnoreCase("06") ?
                                                _obj.getAtxCustoms().getCustomid() :
                                                _obj.getBegin_office().equalsIgnoreCase("09") ?
                                                        _obj.getAtxBorderGuards().getBorguaid() :
                                                        _obj.getBegin_office().equalsIgnoreCase("08") ?
                                                                _obj.getAtxRanger().getRangid() :
                                                                "";
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_decicode", _obj.getDecicode())
                .addValue("p_regicode", _obj.getRegicode())
                .addValue("p_deciid", _obj.getDeciid())
                .addValue("p_setnum", _obj.getSetnumdeci())
                .addValue("p_indate", Utils.getSqlDate(_obj.getIndate()))
                .addValue("p_spcid", "")
                .addValue("p_sppid", "")
                .addValue("p_polid", "")
                .addValue("p_content",  _obj.getContent())
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(_obj.getTodate()))
                .addValue("p_accucode", _obj.getAccucode())
                .addValue("p_reasonid", _obj.getReasonid())
                .addValue("p_signname", _obj.getSignname())
                .addValue("p_signoffice", _obj.getSignoffice())
                .addValue("P_Finishdate", Utils.getSqlDate(_obj.getFinishdate()))
                .addValue("p_userfor", _obj.getUserfor())
                .addValue("P_Crtuser", userid)
                .addValue("p_time", _obj.getSettime())
                .addValue("p_unit", _obj.getSetunit())
                .addValue("p_etime", _obj.getEsettime())
                .addValue("p_eunit", _obj.getEsetunit())
                .addValue("p_begin_office", _obj.getBegin_office())
                .addValue("p_begin_officeid", idcode)
                .addValue("p_REGISTER_DECISION_N_ID",_obj.getRegisterdeciid())
                .addValue("P_RUTGON", Boolean.TRUE.equals(_obj.getRutgon()) ? "Y" : "N")
                ;

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String insertUpdateAcc(String action, SppDecision _obj, String userid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION_ACC") //package name
                .withFunctionName(action.equals(Constants.DML_INSERT)? "fn_insert" : "fn_update")
                .withReturnValue();

        String idcode =
                _obj.getBegin_office().equalsIgnoreCase("SPP") ? _obj.getAtxSpp().getSppid() : _obj.getBegin_office().equalsIgnoreCase("SPC") ?
                        _obj.getAtxSpc().getSpcid() :
                        _obj.getBegin_office().equalsIgnoreCase("02") ?
                                _obj.getAtxPolice().getPoliceid() :
                                _obj.getBegin_office().equalsIgnoreCase("04") ?
                                        _obj.getAtxArmy().getArmyid() :
                                        _obj.getBegin_office().equalsIgnoreCase("06") ?
                                                _obj.getAtxCustoms().getCustomid() :
                                                _obj.getBegin_office().equalsIgnoreCase("09") ?
                                                        _obj.getAtxBorderGuards().getBorguaid() :
                                                        _obj.getBegin_office().equalsIgnoreCase("08") ?
                                                                _obj.getAtxRanger().getRangid() :
                                                                "";
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_decicode", _obj.getDecicode())
                .addValue("p_regicode", _obj.getRegicode())
                .addValue("p_deciid", _obj.getDeciid())
                .addValue("p_setnum", _obj.getSetnum())
                .addValue("p_indate", Utils.getSqlDate(_obj.getIndate()))
                .addValue("p_begin_office", _obj.getBegin_office())
                .addValue("p_begin_officeid", idcode)
                .addValue("p_content",  _obj.getContent())
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(_obj.getTodate()))
                .addValue("p_accucode", _obj.getAccucode())
                .addValue("p_reasonid", _obj.getReasonid())
                .addValue("p_signname", _obj.getSignname())
                .addValue("p_signoffice", _obj.getSignoffice())
                .addValue("P_finishdate", Utils.getSqlDate(_obj.getFinishdate()))
                .addValue("p_userfor", _obj.getUserfor())
                .addValue("P_user", userid)
                .addValue("p_settime", _obj.getSettime())
                .addValue("p_setunit", _obj.getSetunit())
                .addValue("p_esettime", _obj.getEsettime())
                .addValue("p_esetunit", _obj.getEsetunit())
                .addValue("p_timefrom", _obj.getHfrom() + ":" + _obj.getMfrom())
                .addValue("p_timeto", _obj.getHto() + ":" + _obj.getMto())
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LinkedCaseInsensitiveMap> isCheckTrans(String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("check_delete_deci_ins");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_regicode", regicode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap getDecidetail(String decicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DECISION") //package name
                .withFunctionName("get");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_DECICODE", decicode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);
    }

}
