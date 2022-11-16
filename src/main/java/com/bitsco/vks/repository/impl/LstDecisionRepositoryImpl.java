package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstDecisionSearchDTO;
import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.models.LstDecisionSaveRequest;
import com.bitsco.vks.repository.LstDecisionRepository;
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
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class LstDecisionRepositoryImpl implements LstDecisionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstDecisionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String name, String applyFor, String userFor, String status, String applyFinish, String deciType) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstDecisionSearchDTO> rm = new SingleColumnRowMapper<LstDecisionSearchDTO>() {
            @Override
            public LstDecisionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstDecisionSearchDTO lstDecisionSearchDTO = new LstDecisionSearchDTO();
                lstDecisionSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstDecisionSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstDecisionSearchDTO.setDECIID(rs.getString("DECIID"));
                lstDecisionSearchDTO.setDECINAME(rs.getString("DECINAME"));
                lstDecisionSearchDTO.setAPPLYFOR(rs.getString("APPLYFOR"));
                lstDecisionSearchDTO.setSETTIME(rs.getString("SETTIME"));
                lstDecisionSearchDTO.setSETUNIT(rs.getString("SETUNIT"));
                lstDecisionSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstDecisionSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstDecisionSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstDecisionSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstDecisionSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstDecisionSearchDTO.setAPPLYFINISH(rs.getString("APPLYFINISH"));
                lstDecisionSearchDTO.setUSERFOR(rs.getString("USERFOR"));
                lstDecisionSearchDTO.setDECITYPEID(rs.getString("DECITYPEID"));
                lstDecisionSearchDTO.setDECILEVEL(rs.getString("DECILEVEL"));
                lstDecisionSearchDTO.setTIMELIMIT(rs.getString("TIMELIMIT"));
                lstDecisionSearchDTO.setCONTENT(rs.getString("CONTENT"));
                lstDecisionSearchDTO.setUSEFOR(rs.getString("USEFOR"));
                lstDecisionSearchDTO.setDECITYPENAME(rs.getString("DECITYPENAME"));
                lstDecisionSearchDTO.setLIMITTIME(rs.getString("TIMELIMIT"));
                return lstDecisionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_id", id)
                .addValue("p_name", name)
                .addValue("p_applyfor", applyFor)
                .addValue("p_userfor", userFor)
                .addValue("p_status", status)
                .addValue("p_applyfinish", applyFinish)
                .addValue("p_decitype", deciType);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstDecisionEntity> searchForHS(String usefor, String applyfor, String decitype) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                .withFunctionName(Constant.FUNCTION.FN_LSTDECISION_HS);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_userfor", usefor)
                .addValue("P_Applyfor", applyfor)
                .addValue("P_Decitypeid", decitype);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionEntity>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstDecisionSearchDTO> getListApplyForTBTG(Integer rowIndex, Integer pageSize, String search, String sortFields, String sortOrder) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstDecisionSearchDTO> rm = new SingleColumnRowMapper<LstDecisionSearchDTO>() {
            @Override
            public LstDecisionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstDecisionSearchDTO lstDecisionSearchDTO = new LstDecisionSearchDTO();
                lstDecisionSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstDecisionSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstDecisionSearchDTO.setDECIID(rs.getString("DECIID"));
                lstDecisionSearchDTO.setDECINAME(rs.getString("DECINAME"));
                lstDecisionSearchDTO.setAPPLYFOR(rs.getString("APPLYFOR"));
                lstDecisionSearchDTO.setSETTIME(rs.getString("SETTIME"));
                lstDecisionSearchDTO.setSETUNIT(rs.getString("SETUNIT"));
                lstDecisionSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstDecisionSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstDecisionSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstDecisionSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstDecisionSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstDecisionSearchDTO.setAPPLYFINISH(rs.getString("APPLYFINISH"));
                lstDecisionSearchDTO.setUSERFOR(rs.getString("USERFOR"));
                lstDecisionSearchDTO.setDECITYPEID(rs.getString("DECITYPEID"));
                lstDecisionSearchDTO.setDECILEVEL(rs.getString("DECILEVEL"));
                lstDecisionSearchDTO.setTIMELIMIT(rs.getString("TIMELIMIT"));
                lstDecisionSearchDTO.setCONTENT(rs.getString("CONTENT"));
                lstDecisionSearchDTO.setUSEFOR(rs.getString("USEFOR"));
                lstDecisionSearchDTO.setDECITYPENAME(rs.getString("DECITYPENAME"));
                return lstDecisionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortFields)
                .addValue("p_sortorder", sortOrder)
                .addValue("p_id", null)
                .addValue("p_name", search)
                .addValue("p_applyfor", null)
                .addValue("p_userfor", "Tbtg")
                .addValue("p_status", 'Y')
                .addValue("p_applyfinish", null)
                .addValue("p_decitype", null);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap getDecisionById(String deciid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_deciid", deciid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);

    }

    @Override
    public List<LstDecisionSearchDTO> autocomplete(String query) {
        RowMapper<LstDecisionSearchDTO> rm = new SingleColumnRowMapper<LstDecisionSearchDTO>() {
            @Override
            public LstDecisionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstDecisionSearchDTO lstDecisionSearchDTO = new LstDecisionSearchDTO();
                lstDecisionSearchDTO.setDECIID(rs.getString("DECIID"));
                lstDecisionSearchDTO.setDECINAME(rs.getString("DECINAME"));
                return lstDecisionSearchDTO;
            }
        };
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstDecisionSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(LstDecisionSaveRequest req, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", req.getAction())
                    .addValue("p_deciid", req.getDeciid())
                    .addValue("p_deciname", req.getDeciname())
                    .addValue("p_applyfor", req.getApplyfor())
                    .addValue("p_settime", req.isLimittime() ? req.getSettime() : "0")
                    .addValue("p_setunit", req.isLimittime() ? req.getSetunit() : " ")
                    .addValue("p_applyfinish", req.getApplyfinish())
                    .addValue("p_userfor", req.getUserfortempl())
                    .addValue("p_status", req.getStatus())
                    .addValue("p_user", username)
                    .addValue("p_decitypeid", req.getDecitypeid())
                    .addValue("p_parent", "CHA".equalsIgnoreCase(req.getType_ins()) ? req.getDecitemp().substring(0,1) : req.getDecitemp())
                    .addValue("p_decilevel", "CHA".equalsIgnoreCase(req.getType_ins()) ? req.getDecilevel() : 2)
                    .addValue("p_timelimit", req.isLimittime() ? "Y" : "N");

            //First parameter is function output parameter type.
            return (String) jdbcCall.execute(paramMap).get("return");
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public String delete(String deciid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_deciid", deciid);

            //First parameter is function output parameter type.
            return (String) jdbcCall.execute(paramMap).get("return");
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<LstDecisionSearchDTO> getFnFindTree(String decilevel, String deciid) {
        try {
            RowMapper<LstDecisionSearchDTO> rm = new SingleColumnRowMapper<LstDecisionSearchDTO>() {
                @Override
                public LstDecisionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstDecisionSearchDTO lstDecisionSearchDTO = new LstDecisionSearchDTO();
                    lstDecisionSearchDTO.setDECIID(rs.getString("DECIID"));
                    lstDecisionSearchDTO.setDECINAME(rs.getString("DECINAME"));
                    lstDecisionSearchDTO.setAPPLYFOR(rs.getString("APPLYFOR"));
                    lstDecisionSearchDTO.setSETTIME(rs.getString("SETTIME"));
                    lstDecisionSearchDTO.setSETUNIT(rs.getString("SETUNIT"));
                    lstDecisionSearchDTO.setSTATUS(rs.getString("STATUS"));
                    lstDecisionSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                    lstDecisionSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                    lstDecisionSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                    lstDecisionSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                    lstDecisionSearchDTO.setAPPLYFINISH(rs.getString("APPLYFINISH"));
                    lstDecisionSearchDTO.setUSERFOR(rs.getString("USERFOR"));
                    lstDecisionSearchDTO.setDECITYPEID(rs.getString("DECITYPEID"));
                    lstDecisionSearchDTO.setDECILEVEL(rs.getString("DECILEVEL"));
                    lstDecisionSearchDTO.setTIMELIMIT(rs.getString("TIMELIMIT"));
                    lstDecisionSearchDTO.setCONTENT(rs.getString("CONTENT"));
                    lstDecisionSearchDTO.setUSEFOR(rs.getString("USEFOR"));
                    lstDecisionSearchDTO.setDECITYPENAME(rs.getString("DECITYPENAME"));
                    lstDecisionSearchDTO.setLIMITTIME(rs.getString("TIMELIMIT"));
                    lstDecisionSearchDTO.setPlusChildren(rs.getString("CHILDREN"));
                    return lstDecisionSearchDTO;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_DECISION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                    .returningResultSet("return",rm);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_deciid", StringCommon.isNullOrBlank(deciid) ? null : deciid)
                    .addValue("p_level", StringCommon.isNullOrBlank(decilevel) ? null : decilevel);

            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<LstDecisionSearchDTO>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw (e);
        }
    }

}
