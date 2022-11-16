package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.models.LstLawGroupChapSave;
import com.bitsco.vks.repository.LstLawGroupChapRepository;
import com.bitsco.vks.utils.StringCommon;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:25 AM
 */
@Repository
public class LstLawGroupChapRepositoryImpl implements LstLawGroupChapRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public List<LstLawGroupChapDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String groupid, String fullname, String groupname) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLawGroupChapDTO> rm = new SingleColumnRowMapper<LstLawGroupChapDTO>() {
            @Override
            public LstLawGroupChapDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLawGroupChapDTO lstCodeDTO = new LstLawGroupChapDTO();
                lstCodeDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstCodeDTO.setRNUM(rs.getInt("RNUM"));
                lstCodeDTO.setGROUPID(rs.getString("GROUPID"));
                lstCodeDTO.setGROUPNAME(rs.getString("GROUPNAME"));
                lstCodeDTO.setID(rs.getString("ID"));
                lstCodeDTO.setFULLNAME(rs.getString("FULLNAME"));
                lstCodeDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCodeDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCodeDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCodeDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstCodeDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_id", id)
                .addValue("p_groupid", groupid)
                .addValue("p_fullname", fullname)
                .addValue("p_lawgroupname", groupname);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLawGroupChapDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstLawGroupChapDTO> searchLstById(String id) {
        try {
            SimpleJdbcCall jdbcCall;
            RowMapper<LstLawGroupChapDTO> rm = new SingleColumnRowMapper<LstLawGroupChapDTO>() {
                @Override
                public LstLawGroupChapDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstLawGroupChapDTO lstCodeDTO = new LstLawGroupChapDTO();
                    lstCodeDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                    lstCodeDTO.setRNUM(rs.getInt("RNUM"));
                    lstCodeDTO.setID(rs.getString("ID"));
                    lstCodeDTO.setGROUPID(rs.getString("GROUPID"));
                    lstCodeDTO.setGROUPNAME(rs.getString("GROUPNAME"));
                    lstCodeDTO.setCRTDATE(rs.getString("CRTDATE"));
                    lstCodeDTO.setCRTUSER(rs.getString("CRTUSER"));
                    return lstCodeDTO;
                }
            };
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_UPDATE)
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_id", id)
                    .addValue("p_sortcol", null)
                    .addValue("p_sortorder", "ASCENDING");

            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<LstLawGroupChapDTO>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String insertUpdate(LstLawGroupChapSave req, String username) {
        try {
            String _result = "";
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_FOR_UPDATE);
            for (String groupid : req.getLstGroupid()) {
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_id", req.getId())
                        .addValue("p_fullname", req.getFullname())
                        .addValue("p_groupid", groupid)
                        .addValue("p_crtuser", username);

                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
                if (!StringCommon.isNullOrBlank(_result)) return _result;
            }
            return null;
        }catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String insert(LstLawGroupChapSave req, String username) {
        try {
            String _result = null;
            String id = null;
            int i = 0;
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT);
            for (String groupid : req.getLstGroupid()) {
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("p_order", i)
                        .addValue("p_id", id)
                        .addValue("p_fullname", req.getFullname())
                        .addValue("p_groupid", groupid)
                        .addValue("p_crtuser", username);

                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
                if (i == 0) id = _result;
                if (!StringCommon.isNullOrBlank(_result) && _result.length() != 2) return _result;
                i++;
            }
            return null;
        }catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String id, String groupid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE)
                    .withReturnValue();
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_id", id)
                    .addValue("p_groupid", groupid);
            Map results = jdbcCall.execute(paramMap);
            String _result = (String) results.get("return");
            return _result;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public String deleteAll(String id) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_LAWGROUPCHAP)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE_ALL);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_id", id);
            Map results = jdbcCall.execute(paramMap);
            String _result = (String) results.get("return");
            return _result;
        } catch (Exception e) {
            throw (e);
        }
    }
}
