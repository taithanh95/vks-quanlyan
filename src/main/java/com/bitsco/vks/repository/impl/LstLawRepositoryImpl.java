package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawAutoCompleteDTO;
import com.bitsco.vks.dto.LstLawSearchDTO;
import com.bitsco.vks.entity.LstCode;
import com.bitsco.vks.entity.LstLaw;
import com.bitsco.vks.entity.LstLawGroup;
import com.bitsco.vks.repository.LstLawRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class LstLawRepositoryImpl implements LstLawRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

//    @Override
//    public List<LstLaw> autocomplete(String query, String codeId, Integer limit) {
//        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
//                .withCatalogName("PKG_LST_LAW") //package name
//                .withFunctionName("FN_AUTOCOMPLETE")
//                .withoutProcedureColumnMetaDataAccess();
//
//        MapSqlParameterSource  paramMap = new MapSqlParameterSource()
//                .addValue("p_query", query)
//                .addValue("p_level", codeId)
//                .addValue("p_limit", limit);
//
//        //First parameter is function output parameter type.
//        return jdbcCall.executeFunction((Class<List<LstLaw>>) (Class) List.class, paramMap);
//    }


    @Override
    public List<LstLawAutoCompleteDTO> autocomplete(String query, String codeId, Integer limit) throws SQLException {
        final String functionCall = "{? = call PKG_LST_LAW.fn_autocomplete(?, ?, ?)}";
        CallableStatement callableSt = null;
        ResultSet rs = null;
        List<LstLawAutoCompleteDTO> list = new ArrayList<LstLawAutoCompleteDTO>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

            callableSt = conn.prepareCall(functionCall);
            callableSt.registerOutParameter(1, Types.REF_CURSOR);
            callableSt.setString(2, query);
            callableSt.setString(3, codeId);
            callableSt.setInt(4, limit);
            callableSt.execute();
            rs = (ResultSet) callableSt.getObject(1);
            while (rs.next()) {
                LstLawAutoCompleteDTO lstLawAutoCompleteDTO = new LstLawAutoCompleteDTO();
                lstLawAutoCompleteDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstLawAutoCompleteDTO.setRNUM(rs.getInt("RNUM"));
                lstLawAutoCompleteDTO.setLAWCODE(rs.getString("LAWCODE"));
                lstLawAutoCompleteDTO.setLAWID(rs.getInt("LAWID"));
                lstLawAutoCompleteDTO.setITEM(rs.getInt("ITEM"));
                lstLawAutoCompleteDTO.setLAWDATE(rs.getString("LAWDATE"));
                lstLawAutoCompleteDTO.setPRIORITY(rs.getInt("PRIORITY"));
                lstLawAutoCompleteDTO.setGROUPID(rs.getInt("GROUPID"));
                lstLawAutoCompleteDTO.setSTATUS(rs.getString("STATUS"));
                lstLawAutoCompleteDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstLawAutoCompleteDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstLawAutoCompleteDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstLawAutoCompleteDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstLawAutoCompleteDTO.setCODEID(rs.getString("CODEID"));
                lstLawAutoCompleteDTO.setPOINT(rs.getString("POINT"));
                lstLawAutoCompleteDTO.setLAWTYPE(rs.getString("LAWTYPE"));
                lstLawAutoCompleteDTO.setLAWNAME(rs.getString("LAWNAME"));
                list.add(lstLawAutoCompleteDTO);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            rs.close();
            callableSt.close();
            jdbcTemplate.getDataSource().getConnection().close();
        }
        return list;
    }

    @Override
    public List<LstLawAutoCompleteDTO> search(String query, Integer limit) throws SQLException {
        final String functionCall = "{? = call PKG_LST_LAW.fn_autocomplete_2020(?, ?)}";
        CallableStatement callableSt = null;
        ResultSet rs = null;
        List<LstLawAutoCompleteDTO> list = new ArrayList<LstLawAutoCompleteDTO>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

            callableSt = conn.prepareCall(functionCall);
            callableSt.registerOutParameter(1, Types.REF_CURSOR);
            callableSt.setString(2, query);
            callableSt.setInt(3, limit);
            callableSt.execute();
            rs = (ResultSet) callableSt.getObject(1);
            while (rs.next()) {
                LstLawAutoCompleteDTO lstLawAutoCompleteDTO = new LstLawAutoCompleteDTO();
                lstLawAutoCompleteDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstLawAutoCompleteDTO.setRNUM(rs.getInt("RNUM"));
                lstLawAutoCompleteDTO.setLAWCODE(rs.getString("LAWCODE"));
                lstLawAutoCompleteDTO.setLAWID(rs.getInt("LAWID"));
                lstLawAutoCompleteDTO.setITEM(rs.getInt("ITEM"));
                lstLawAutoCompleteDTO.setLAWDATE(rs.getString("LAWDATE"));
                lstLawAutoCompleteDTO.setPRIORITY(rs.getInt("PRIORITY"));
                lstLawAutoCompleteDTO.setGROUPID(rs.getInt("GROUPID"));
                lstLawAutoCompleteDTO.setSTATUS(rs.getString("STATUS"));
                lstLawAutoCompleteDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstLawAutoCompleteDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstLawAutoCompleteDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstLawAutoCompleteDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstLawAutoCompleteDTO.setCODEID(rs.getString("CODEID"));
                lstLawAutoCompleteDTO.setPOINT(rs.getString("POINT"));
                lstLawAutoCompleteDTO.setLAWTYPE(rs.getString("LAWTYPE"));
                lstLawAutoCompleteDTO.setLAWNAME(rs.getString("LAWNAME"));
                list.add(lstLawAutoCompleteDTO);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            rs.close();
            callableSt.close();
            jdbcTemplate.getDataSource().getConnection().close();
        }
        return list;
    }

    @Override
    public List<LstLaw> sarchLaw(int rowIndex, int pageSize, String sortField, String sortOrder, LstLaw lawFilters) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LAW") //package name
                .withFunctionName("fn_search");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_lawid", Utils.StringIsNullOrEmpty(lawFilters.getLawid()) ? null : lawFilters.getLawid().trim())
                .addValue("p_item", Utils.StringIsNullOrEmpty(lawFilters.getItem()) ? null : lawFilters.getItem().trim())
                .addValue("p_point", Utils.StringIsNullOrEmpty(lawFilters.getPoint()) ? null : lawFilters.getPoint().trim())
                .addValue("p_lawname", Utils.StringIsNullOrEmpty(lawFilters.getLawname()) ? null : lawFilters.getLawname().trim())
                .addValue("p_groupid", Utils.StringIsNullOrEmpty(lawFilters.getGroupid()) ? null : lawFilters.getGroupid().trim())
                .addValue("p_codeid", Utils.StringIsNullOrEmpty(lawFilters.getCodeid()) ? null : lawFilters.getCodeid().trim());

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLaw>>) (Class) List.class, paramMap);
    }


    @Override
    public List<LstLawSearchDTO> searchLaw(int rowIndex, int pageSize, String sortField, String sortOrder, String p_LawId, String p_Item, String p_Point, String p_LawName, String p_GroupId, String p_CodeId) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLawSearchDTO> rm = new SingleColumnRowMapper<LstLawSearchDTO>() {
            @Override
            public LstLawSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLawSearchDTO lstLaw = new LstLawSearchDTO();
                lstLaw.setRowCount(rs.getLong("ROWCOUNT"));
                lstLaw.setRNum(rs.getInt("RNum"));
                lstLaw.setLawCode(rs.getString("LawCode"));
                lstLaw.setLawId(rs.getString("LawId"));
                lstLaw.setItem(rs.getString("Item"));
                lstLaw.setPoint1(rs.getString("Point1"));
                lstLaw.setLawName(rs.getString("LawName"));
                lstLaw.setLawDate(rs.getDate("LawDate"));
                lstLaw.setPriority(rs.getInt("Priority"));
                lstLaw.setSetOrder(rs.getInt("SetOrder"));
                lstLaw.setGroupId(rs.getString("GroupId"));
                lstLaw.setStatus(rs.getString("Status"));
                lstLaw.setCrtUser(rs.getString("CrtUser"));
                lstLaw.setCrtDate(rs.getDate("CrtDate"));
                lstLaw.setMdfDate(rs.getDate("MdfDate"));
                lstLaw.setMdfUser(rs.getString("MdfUser"));
                lstLaw.setCodeId(rs.getString("CodeId"));
                lstLaw.setPoint(rs.getString("Point"));
                lstLaw.setLawType(rs.getString("LawType"));
                lstLaw.setLawCodeParrent(rs.getString("LawCodeParrent"));
                lstLaw.setSync(rs.getString("Sync"));
                lstLaw.setLawNameTxt(rs.getString("LawName_Txt"));
                lstLaw.setCodeName(rs.getString("CodeName"));
                StringBuilder label = new StringBuilder();
                label.append("Điều ").append(lstLaw.getLawId());
                if (lstLaw.getItem() != null) {
                    label.append(", Khoản ").append(lstLaw.getItem());
                }
                if (lstLaw.getPoint() != null) {
                    label.append(", Điểm ").append(lstLaw.getPoint());
                }
                label.append(" - ").append(lstLaw.getLawName());
                lstLaw.setLabel(label.toString());
                return lstLaw;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LAW") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_lawid", Utils.StringIsNullOrEmpty(p_LawId) ? null : p_LawId.trim())
                .addValue("p_item", Utils.StringIsNullOrEmpty(p_Item) ? null : p_Item.trim())
                .addValue("p_point", Utils.StringIsNullOrEmpty(p_Point) ? null : p_Point.trim())
                .addValue("p_lawname", Utils.StringIsNullOrEmpty(p_LawName) ? null : p_LawName.trim())
                .addValue("p_groupid", Utils.StringIsNullOrEmpty(p_GroupId) ? null : p_GroupId.trim())
                .addValue("p_codeid", Utils.StringIsNullOrEmpty(p_CodeId) ? null : p_CodeId.trim());

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLawSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstCode> getLstCode(String codeid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_CODE") //package name
                .withFunctionName("fn_getallhs");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", codeid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCode>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstLawGroup> getLstLawGroup(String codeid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LAW") //package name
                .withFunctionName("fn_get_lst_lawgroup");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_codeid", codeid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLawGroup>>) (Class) List.class, paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap get(String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LAW") //package name
                .withFunctionName("fn_get");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_lawcode", lawcode);

        //First parameter is function output parameter type.
        List<LinkedCaseInsensitiveMap> lstLaws = jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap);
        if (lstLaws != null && lstLaws.size() > 0)
            return lstLaws.get(0);
        else
            return null;
    }

    @Override
    public String insert(LstLaw req, String username, String action) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAW)
                .withFunctionName(Constant.FUNCTION.FN_INSERT)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_lawcode", req.getLawcode())
                .addValue("p_lawid", req.getLawid())
                .addValue("p_item", req.getItem())
                .addValue("p_point", req.getPoint())
                .addValue("p_lawname", req.getLawname())
                .addValue("p_lawdate", Utils.getSqlDate(req.getLawdate()))
                .addValue("p_priority", req.getPriority())
                .addValue("p_setorder", req.getSetorder())
                .addValue("p_groupid", req.getGroupid())
                .addValue("p_lawtype", req.getLawtype())
                .addValue("p_crtuser", username)
                .addValue("p_codeid", req.getCodeid());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String update(LstLaw req, String username, String action) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAW)
                .withFunctionName(Constant.FUNCTION.FN_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_lawcode", req.getLawcode())
                .addValue("p_lawid", req.getLawid())
                .addValue("p_item", req.getItem())
                .addValue("p_point", req.getPoint())
                .addValue("p_lawname", req.getLawname())
                .addValue("p_lawdate", Utils.getSqlDate(req.getLawdate()))
                .addValue("p_priority", req.getPriority())
                .addValue("p_setorder", req.getSetorder())
                .addValue("p_groupid", req.getGroupid())
                .addValue("p_lawtype", req.getLawtype())
                .addValue("p_crtuser", username)
                .addValue("p_codeid", req.getCodeid());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstLaw req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAW) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_lawcode", req.getLawcode());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
