package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmGroupsRequestDTO;
import com.bitsco.vks.repository.AdmGroupsRepository;
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
public class AdmGroupsRepositoryImpl implements AdmGroupsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(AdmGroupsRequestDTO req, int rowIndex, int pageSize, String sortField, String sortOrder) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_ADM_GROUPS)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder)
                .addValue("p_groupid", req.getGroupid())
                .addValue("p_groupname", req.getGroupname())
                .addValue("p_sppid", req.getSppid());

        return jdbcCall.executeFunction(List.class,param);
    }

    @Override
    public String save(AdmGroupsRequestDTO req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_ADM_GROUPS)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_groupid", req.getGroupid())
                .addValue("p_groupname", req.getGroupname())
                .addValue("p_crtuser", username)
                .addValue("p_sppid", req.getSppid());
        Map res = jdbcCall.execute(param);
        String _return = (String) res.get("return");
        return _return;
    }

    @Override
    public String delete(String groupid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_ADM_GROUPS)
                .withFunctionName(Constant.FUNCTION.FN_DELETE);

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_groupid", groupid);

        Map res = jdbcCall.execute(param);
        String _return = (String) res.get("return");
        return _return;
    }
}
