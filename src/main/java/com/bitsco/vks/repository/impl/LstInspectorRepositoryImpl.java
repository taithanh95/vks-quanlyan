package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.models.LstInspectorInsertRequest;
import com.bitsco.vks.models.LstInspectorSearchRequest;
import com.bitsco.vks.repository.LstInspectorRepository;
import com.bitsco.vks.utils.StringCommon;
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
public class LstInspectorRepositoryImpl implements LstInspectorRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstInspector> autocomplete(String query, String sppid, String position_type) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("pkg_lst_inspector") //package name
                .withFunctionName("fn_ks_dtv_ld");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", StringCommon.isNullOrBlank(query) ? null : query)
                .addValue("p_sppid", sppid)
                .addValue("p_position", position_type.equals("ALL") ? null : position_type);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstInspector>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> search(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String caseCode, String sppId, String usefor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_SPP_ACCUSED_UPDATE") //package name
                .withFunctionName("fn_Search_ntl");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_Rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("P_Sortcol", sortField)
                .addValue("P_Sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("P_Regicode", regicode)
                .addValue("p_sppid", sppId)
                .addValue("p_casecode", caseCode)
                .addValue("p_usefor", usefor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap getByInspcode(String inspCode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("pkg_lst_inspector") //package name
                .withFunctionName("fn_get");

        SqlParameterSource paramMap = new MapSqlParameterSource().addValue("p_inspcode", inspCode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);
    }

    @Override
    public List<LstInspector> search1(LstInspectorSearchRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("PKG_LST_INSPECTOR") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", request.getRowIndex())
                .addValue("p_pagesize", request.getPageSize())
                .addValue("p_sortcol", request.getSortField())
                .addValue("p_sortorder", request.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("p_inspcode", !StringCommon.isNullOrBlank(request.getInspcode()) ? request.getInspcode() : null)
                .addValue("p_sppid", StringCommon.isNullOrBlank(request.getCurrentsppid()) ? request.getSppid() : request.getCurrentsppid())
                .addValue("p_name", !StringCommon.isNullOrBlank(request.getName()) ? request.getName() : null)
                .addValue("p_fullname", !StringCommon.isNullOrBlank(request.getFullname()) ? request.getFullname() : null)
                .addValue("p_status", !StringCommon.isNullOrBlank(request.getStatus()) ? request.getStatus() : null)
                .addValue("p_position", !StringCommon.isNullOrBlank(request.getPosition()) ? request.getPosition() : null)
                .addValue("p_currentsppid", !StringCommon.isNullOrBlank(request.getCurrentsppid()) ? request.getCurrentsppid() : null);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstInspector>>) (Class) List.class, paramMap);
    }

    @Override
    public String delete(LstInspectorSearchRequest request) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_INSPECTOR") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_inspcode", request.getInspcode());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String insertUpdate(LstInspectorInsertRequest req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_INSPECTOR") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();
        String positiontemp = "";
        if (req.isKh()) {
            positiontemp += "KH,";
        }
        if (req.isKs()) {
            positiontemp += "KS,";
        }
        if (req.isDt()) {
            positiontemp += "DT,";
        }
        if (req.isLd()) {
            positiontemp += "LD,";
        }

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_inspcode", req.getInspcode())
                .addValue("p_sppid", StringCommon.isNullOrBlank(req.getDepart()) ? req.getSppid() : req.getDepart())
                .addValue("p_fullname", req.getFullname())
                .addValue("p_add", req.getAddress())
                .addValue("p_tel", req.getTel())
                .addValue("p_jobttile", req.getJobtitle())
                .addValue("p_status", req.getStatus())
                .addValue("p_position", positiontemp)
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstSPP> getSpp(String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SPP") //package name
                .withFunctionName("fn_getsppchange");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", !StringCommon.isNullOrBlank(sppid) ? sppid : null);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPP> getListSppIsDepart(String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_ADM_DEPARTMENTS") //package name
                .withFunctionName("fn_list");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", !StringCommon.isNullOrBlank(sppid) ? sppid : null);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public String changeInspector(LstInspector req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_INSPECTOR") //package name
                .withFunctionName("fn_change")
                .withReturnValue();
        String positiontemp = "";
        if (req.isKh()) {
            positiontemp += "KH,";
        }
        if (req.isKs()) {
            positiontemp += "KS,";
        }
        if (req.isDt()) {
            positiontemp += "DT,";
        }
        if (req.isLd()) {
            positiontemp += "LD,";
        }

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_inspcode", req.getInspcode())
                .addValue("p_sppid", req.getSppid())
                .addValue("p_jobttile", req.getJobtitle())
                .addValue("p_position", positiontemp)
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    public List<LstInspector> autocomplete2022(String query, String sppid, String underlevel) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_INSPECTOR")
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_sppid", sppid)
                .addValue("p_underlevel", underlevel);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstInspector>>) (Class) List.class, paramMap);
    }
}
