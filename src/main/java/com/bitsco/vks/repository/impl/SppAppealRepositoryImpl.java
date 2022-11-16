package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstAgainstEntity;
import com.bitsco.vks.entity.LstAppeal;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppAppeal;
import com.bitsco.vks.models.SppAgainstSaveResponse;
import com.bitsco.vks.models.SppAppealSaveResponse;
import com.bitsco.vks.repository.SppAppealRepository;
import com.bitsco.vks.utils.Utils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class SppAppealRepositoryImpl implements SppAppealRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SppAppeal> searchByRegicode(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String userfor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_searchbyregicode");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_regicode", regicode)
                .addValue("p_userfor", userfor)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAppeal> searchByCase(int pageNumber, int pageSize, String sortField, String sortOrder, String casecode, String userfor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_searchcase");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", pageNumber)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_casecode", casecode)
                .addValue("p_userfor", userfor)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
    }

    @Override
    public SppAppealSaveResponse insertUpdate(String action, SppAppeal bean, String sppid, String userid) {
        SppAppealSaveResponse ret = new SppAppealSaveResponse();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        String strAppid = "";
        for (String p : bean.getArrAppealid()) {
            strAppid += p + ",";
        }

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_action", action)
                .addValue("p_appecode", bean.getAppecode())
                .addValue("p_casecode", bean.getCasecode())
                .addValue("p_casename", bean.getCasename())
                .addValue("p_sppid", bean.getSppid())
                .addValue("p_indate", Utils.getSqlDate(bean.getIndate()))
                .addValue("p_content", bean.getContent())
                .addValue("p_appealid", strAppid)
                .addValue("p_crtuser", userid)
                .addValue("p_regicode", bean.getRegicode())
                .addValue("p_accucode", bean.getAccucode())
                .addValue("p_perapp", bean.getPerapp())
                .addValue("p_acctype", bean.getAcctype())
                .addValue("p_setnum", bean.getSetnum())
                .addValue("p_setdate", Utils.getSqlDate(bean.getSetdate()))
                .addValue("p_appeafor", bean.getAppeafor())
                .addValue("p_participate", bean.getParticipate());

        Map results = jdbcCall.execute(paramMap);
        ret.result = (String) results.get("return");
        bean.setAppecode((String) results.get("p_appecode"));
        ret.sppAppeal = bean;

        return  ret;
    }

    @Override
    public String delete(String code) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_action", "D")
                .addValue("p_appecode", code)
                .addValue("p_casecode", null)
                .addValue("p_casename", null)
                .addValue("p_sppid", null)
                .addValue("p_indate", null)
                .addValue("p_content", null)
                .addValue("p_appealid", null)
                .addValue("p_crtuser", null)
                .addValue("p_regicode", null)
                .addValue("p_accucode", null)
                .addValue("p_perapp", null)
                .addValue("p_acctype", null)
                .addValue("p_setnum", null)
                .addValue("p_setdate", null)
                .addValue("p_appeafor", null);

        Map results = jdbcCall.execute(paramMap);
        return  (String) results.get("return");
    }

    @Override
    public List<SppAppeal> lstAppeals(String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_get_lst_appeal");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_appealname", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
    }

    @Override
    public List<SppAppeal> getAppealAcc(String appecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_APPEAL") //package name
                .withFunctionName("fn_getAppealAcc");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_appecode", appecode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAppeal>>) (Class) List.class, paramMap);
    }
}
