package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.dto.LstDecitypeSearchDTO;
import com.bitsco.vks.entity.LstDecitype;
import com.bitsco.vks.entity.LstReason;
import com.bitsco.vks.repository.LstDecisionRepository;
import com.bitsco.vks.repository.LstDecitypeRepository;
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

@Repository
public class LstDecitypeRepositoryImpl implements LstDecitypeRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstDecitypeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String decitypeId, String name) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstDecitypeSearchDTO> rm = new SingleColumnRowMapper<LstDecitypeSearchDTO>() {
            @Override
            public LstDecitypeSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstDecitypeSearchDTO lstDecitypeSearchDTO = new LstDecitypeSearchDTO();
                lstDecitypeSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstDecitypeSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstDecitypeSearchDTO.setDECITYPEID(rs.getString("DECITYPEID"));
                lstDecitypeSearchDTO.setNAME(rs.getString("NAME"));
                lstDecitypeSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstDecitypeSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstDecitypeSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstDecitypeSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                return lstDecitypeSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECITYPE) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_decitypeid", decitypeId)
                .addValue("p_name", name);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecitypeSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstDecitype> searchDecitypeAccu(String usefor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECITYPE) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_ACC);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_usefor", usefor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecitype>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String decitypeid, String name, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECITYPE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_decitypeid", decitypeid)
                    .addValue("p_name", name)
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String decitypeid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECITYPE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_decitypeid", decitypeid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<LstDecitype> getLstDecitype() {
        try {
            RowMapper<LstDecitype> rm = new SingleColumnRowMapper<LstDecitype>() {
                @Override
                public LstDecitype mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstDecitype resp = new LstDecitype();
                    resp.setDecitypeid(rs.getString("DECITYPEID"));
                    resp.setName(rs.getString("NAME"));
                    return resp;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECITYPE) //package name
                    .withFunctionName(Constant.FUNCTION.FN_LISTDECITYPE)
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource();
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<LstDecitype>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw (e);
        }
    }

}
