package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.SppAgainstDTO;
import com.bitsco.vks.entity.SppAgainst;
import com.bitsco.vks.models.SppAgainstSaveResponse;
import com.bitsco.vks.repository.SppAgainstRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public class SppAgainstRepositoryImpl implements SppAgainstRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;


    @Override
    public List<SppAgainst> searchByRegicode(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String userfor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_searchByRegicode");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_regicode", regicode)
                .addValue("p_userfor", userfor)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAgainst> searchcase(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode, String userfor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_searchcase");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_casecode", casecode)
                .addValue("p_userfor", userfor)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public SppAgainstSaveResponse insertUpdate(String action, SppAgainst bean, String userid) {
        SppAgainstSaveResponse ret = new SppAgainstSaveResponse();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_insert_update1")
                .withReturnValue();

        String strAgaid = "";
        for (String p : bean.getArrAgainstid()) {
            strAgaid += p + ",";
        }

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_action", action)
                .addValue("p_againstcode", bean.getAgainstcode())
                .addValue("p_casecode", bean.getCasecode())
                .addValue("p_casename", bean.getCasename())
                .addValue("p_setnum", bean.getSetnum())
                .addValue("p_sppid", bean.getSppid())
                .addValue("p_indate", Utils.getSqlDate(bean.getIndate()))
                .addValue("p_content", bean.getContent())
                .addValue("p_againstid", strAgaid)
                .addValue("p_userfor", bean.getUserfor())
                .addValue("p_forsetnum", bean.getForsetnum())
                .addValue("p_forindate", Utils.getSqlDate(bean.getForindate()))
                .addValue("p_sppspc", bean.getSppspc())
                .addValue("p_resultid", bean.getResultid())
                .addValue("p_gd_tt", bean.getGd_tt())
                .addValue("p_crtuser", userid)
                .addValue("p_regicode", bean.getRegicode())
                .addValue("p_agafor", bean.getAgafor())
                .addValue("p_agalevel", bean.getAgalevel())
                .addValue("p_accucode", bean.getAccucode())
                .addValue("p_change", bean.isChange() ? "Y" : "N")
                .addValue("p_changedate", bean.isChange() ? Utils.getSqlDate(bean.getChangedate()) : null)
                .addValue("p_changecontent", bean.isChange() ? bean.getChangecontent() : null)
                .addValue("p_additional", bean.isAdditional() ? "Y" : "N")
                .addValue("p_additionaldate", bean.isAdditional() ? Utils.getSqlDate(bean.getAdditionaldate()) : null)
                .addValue("p_additionalcontent", bean.isAdditional() ? bean.getAdditionalcontent() : null)
                .addValue("p_withdraw", bean.isWithdraw() ? "Y" : "N")
                .addValue("p_withdrawdate", bean.isWithdraw() ? Utils.getSqlDate(bean.getWithdrawdate()) : null)
                .addValue("p_withdrawcontent", bean.isWithdraw() ? bean.getWithdrawcontent() : null);

//                .addValue("p_err", ac.getWander() ? "Y" : "N");

        Map results = jdbcCall.execute(paramMap);
        ret.result = (String) results.get("return");
        ret.warning = (String) results.get("p_err");
        bean.setAgainstcode((String) results.get("p_againstcode"));
        ret.sppAgainst = bean;

        return ret;
    }

    @Override
    public String delete(SppAgainst bean, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_action", "D")
                .addValue("p_againstcode", bean.getAgainstcode())
                .addValue("p_casecode", null)
                .addValue("p_casename", null)
                .addValue("p_setnum", null)
                .addValue("p_sppid", sppid)
                .addValue("p_indate", null)
                .addValue("p_content", null)
                .addValue("p_againstid", null)
                .addValue("p_userfor", null)
                .addValue("p_forsetnum", null)
                .addValue("p_forindate", null)
                .addValue("p_sppspc", null)
                .addValue("p_resultid", null)
                .addValue("p_gd_tt", null)
                .addValue("p_crtuser", null)
                .addValue("p_regicode", bean.getRegicode())
                .addValue("p_agafor", null)
                .addValue("p_agalevel", null)
                .addValue("p_accucode", null);
//                .addValue("p_err", ac.getWander() ? "Y" : "N");

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public List<SppAgainst> loadLstAgainsts(String id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_get_lst_against");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_againstid", id);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAgainst> loadLstAgainstResult(String id) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_get_lst_againstResult");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_againstid", id);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAgainst> getAgacase(String againstcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_getAgacase");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_againstcode", againstcode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainst>>) (Class) List.class, paramMap);
    }

    @Override
    public Integer isCheckDisable(String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_check_disableIn");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_regicode", regicode);

        //First parameter is function output parameter type.
        BigDecimal count = jdbcCall.executeFunction(BigDecimal.class, paramMap);
        return count.intValue();
    }

    @Override
    public List<SppAgainstDTO> searchForUpdateResult(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_searchForUpdateResult");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", "ASC".equals(sortOrder) ? "ASC" : "DESC")
                .addValue("p_casecode", casecode)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAgainstDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public SppAgainstSaveResponse updateResult(String action, SppAgainst bean, String userid) {
        SppAgainstSaveResponse ret = new SppAgainstSaveResponse();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_AGAINST") //package name
                .withFunctionName("fn_update_result")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_action", action)
                .addValue("p_againstcode", bean.getAgainstcode())
                .addValue("p_casecode", bean.getCasecode())
                .addValue("p_casename", bean.getCasename())
                .addValue("p_setnum", bean.getSetnum())
                .addValue("p_sppid", bean.getSppid())
                .addValue("p_indate", Utils.getSqlDate(bean.getIndate()))
                .addValue("p_content", bean.getContent())
                .addValue("p_againstid", null)
                .addValue("p_userfor", bean.getUserfor())
                .addValue("p_forsetnum", bean.getForsetnum())
                .addValue("p_forindate", Utils.getSqlDate(bean.getForindate()))
                .addValue("p_sppspc", bean.getSppspc())
                .addValue("p_resultid", bean.getResultid())
                .addValue("p_gd_tt", bean.getGd_tt())
                .addValue("p_crtuser", userid)
                .addValue("p_regicode", bean.getRegicode())
                .addValue("p_agafor", bean.getAgafor())
//                .addValue("p_agalevel", bean.getAgalevel())
                .addValue("p_accucode", bean.getAccucode());
//                .addValue("p_change", bean.isChange() ? "Y" : "N")
//                .addValue("p_changedate", bean.isChange() ? Utils.getSqlDate(bean.getChangedate()) : null)
//                .addValue("p_changecontent", bean.isChange() ? bean.getChangecontent() : null)
//                .addValue("p_additional", bean.isAdditional() ? "Y" : "N")
//                .addValue("p_additionaldate", bean.isAdditional() ? Utils.getSqlDate(bean.getAdditionaldate()) : null)
//                .addValue("p_additionalcontent", bean.isAdditional() ? bean.getAdditionalcontent() : null)
//                .addValue("p_withdraw", bean.isWithdraw() ? "Y" : "N")
//                .addValue("p_withdrawdate", bean.isWithdraw() ? Utils.getSqlDate(bean.getWithdrawdate()) : null)
//                .addValue("p_withdrawcontent", bean.isWithdraw() ? bean.getWithdrawcontent() : null);

//                .addValue("p_err", ac.getWander() ? "Y" : "N");

        Map results = jdbcCall.execute(paramMap);
        ret.result = (String) results.get("return");
        bean.setAgainstcode((String) results.get("p_againstcode"));
        ret.sppAgainst = bean;

        return ret;
    }
}
