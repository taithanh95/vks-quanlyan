package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.AdmDepartmentsRequestDTO;
import com.bitsco.vks.dto.AdmFunctionsResponseDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.repository.AdmDepartmentsRepository;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class AdmDepartmentsRepositoryImpl implements AdmDepartmentsRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> getLst(int rowIndex, int pageSize, AdmDepartmentsRequestDTO req) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_DEPARTMENTS)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", rowIndex)
                    .addValue("p_pagesize", pageSize)
                    .addValue("p_sortcol", req.sortField)
                    .addValue("p_sortorder", req.sortOrder)
                    .addValue("p_departid", StringCommon.isNullOrBlank(req.getDepartid()) ? null : req.getDepartid())
                    .addValue("p_name", StringCommon.isNullOrBlank(req.getName()) ? null : req.getName())
                    .addValue("p_sppid", StringCommon.isNullOrBlank(req.getAtxtSpp()) ? null : req.getAtxtSpp())
                    .addValue("p_sppid1", req.getSppid());
            return jdbcCall.executeFunction(List.class, param);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String save(AdmDepartmentsRequestDTO req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_DEPARTMENTS)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE_2022);

            SqlParameterSource param = new MapSqlParameterSource()

                    .addValue("p_action", req.getAction())
                    .addValue("p_activeTHA", Boolean.TRUE.equals(req.getActivetha()) ? "Y" : "N")
                    .addValue("p_departid", req.getDepartid())
                    .addValue("p_name", req.getName())
                    .addValue("p_sppid", req.getSppid())
                    .addValue("p_crtuser", username);
            Map _result = jdbcCall.execute(param);
            return (String) _result.get("return");
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public String delete(String departid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_DEPARTMENTS)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_departid", departid);
            Map _result = jdbcCall.execute(param);
            return (String) _result.get("return");
        } catch (Exception e) {
            throw (e);
        }
    }

    //lstDepart
    @Override
    public List<LstSPP> getLstSpp(String sppid) {
        try {
            RowMapper<LstSPP> rm = new SingleColumnRowMapper<LstSPP>() {
                @Override
                public LstSPP mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstSPP spp = new LstSPP();
                    spp.setSppid(rs.getString("SPPID"));
                    spp.setName(rs.getString("NAME"));
                    spp.setAddr(rs.getString("ADDR"));
                    spp.setTel(rs.getString("TEL"));
                    spp.setFax(rs.getString("FAX"));
                    spp.setDirector(rs.getString("DIRECTOR"));
                    spp.setSpcid(rs.getString("SPCID"));
                    spp.setSpcname(rs.getString("SPCNAME"));
                    spp.setPolid(rs.getString("POLID"));
                    spp.setLocaid(rs.getString("LOCAID"));
                    spp.setPosition(rs.getString("POSITION"));
                    spp.setSppcode(rs.getString("SPPCODE"));
                    spp.setSpplevel(rs.getInt("SPPLEVEL"));
                    spp.setSppparent(rs.getString("SPPPARENT"));
                    spp.setOrdercode(rs.getString("ORDERCODE"));
                    spp.setIsdepart(rs.getString("ISDEPART"));
                    spp.setSppidfox(rs.getString("SPPIDFOX"));
                    return spp;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_ADM_DEPARTMENTS) //package name
                    .withFunctionName(Constant.FUNCTION.FN_LIST)
                    .returningResultSet("return", rm);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_sppid", !StringCommon.isNullOrBlank(sppid) ? sppid : null);
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw(e);
        }
    }
}
