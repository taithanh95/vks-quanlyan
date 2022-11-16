package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppCase;
import com.bitsco.vks.entity.SppRegister;
import com.bitsco.vks.repository.SppRegisterRepository;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class SppRegisterRepositoryImpl implements SppRegisterRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode, String usefor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_REGISTER") //package name
                .withFunctionName("fn_search_v2");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_casecode", casecode)
                .addValue("p_usefor", usefor)
                .addValue("p_csppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public String insertUpdate(SppRegister ac, SppCase ca, String sppId, String userId) {

        //Check Indate Register the stages
        String _rs = checkIndate(ca.getCasecode(),ac.getUserfor(),ac.getIndate());
        if (!StringCommon.isNullOrBlank(_rs))
            return _rs;

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_REGISTER") //package name
                .withFunctionName(Utils.StringIsNullOrEmpty(ac.getRegicode())? "fn_insert": "fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_regicode", ac.getRegicode())
                .addValue("p_casecode", ca.getCasecode())
                .addValue("p_casename", ca.getCasename())
                .addValue("p_sppid", sppId)
                .addValue("p_setnum", ac.getSetnum())
                .addValue("p_indate", Utils.getSqlDate(ac.getIndate()))
                .addValue("p_fromdate", Utils.getSqlDate(ac.getFromdate()))
                .addValue("p_todate", Utils.getSqlDate(ac.getTodate()))
                .addValue("p_special", ac.isSpecial() ? "Y" : "N")
                .addValue("p_userfor", ac.getUserfor())
                .addValue("p_remark", ac.getRemark())
                .addValue("p_finishdate", ac.getFinishdate())
                .addValue("p_lawcode", ac.getLawcode())
                .addValue("p_casetype", ca.getCasetype())
                .addValue("p_status", ac.getStatus())
                .addValue("p_unspecial", ac.getUnspecial())
                .addValue("p_sppspc", "XXX")
                .addValue("p_appecode", ac.getAppecode())
                .addValue("p_againstcode", ac.getAgainstcode())
                .addValue("p_transfer", ac.getTransfer())
                .addValue("p_transferout", ac.getTransferout())
                .addValue("p_statusreason", ac.getStatusreason())
                .addValue("p_user", userId)
                .addValue("p_usefor", ac.getUserfor())
                .addValue("p_accucode", ca.getFirstacc())
                .addValue("p_spcsetnum", ac.getSpcsetnum())
                .addValue("p_spcindate", Utils.getSqlDate(ac.getSpcindate()))
                .addValue("p_lawyer", ac.isLawyer() ? "Y" : "N")
                .addValue("p_bcvnd", ac.isBcvnd() ? "Y" : "N")
                .addValue("p_tgvpl", ac.isTgvpl() ? "Y" : "N")
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String delete(String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_REGISTER") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_regicode", regicode);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public String checkRegisterable(String casecode, String usefor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_REGISTER") //package name
                .withFunctionName("fn_check_registerable")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_usefor", usefor)
                .addValue("p_sppid", sppid)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    private String checkIndate(String casecode, String userfor, Date indate) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_REGISTER")
                .withFunctionName("fn_check_indate_register")
                .withReturnValue();
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_casecode",casecode)
                .addValue("p_usefor",userfor)
                .addValue("p_indate", Utils.getSqlDate(indate));

        Map result = jdbcCall.execute(param);
        String _result = (String) result.get("return");
        return _result;
    }
}
