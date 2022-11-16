package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstSPPAutoCompleteDTO;
import com.bitsco.vks.dto.LstSPPDTO;
import com.bitsco.vks.dto.LstSPPSearchDTO;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.repository.SppRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class SppRepositoryImpl implements SppRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<LstSPP> getChildSPPs(String parentId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName("fn_get_spps_new");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", parentId);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPPAutoCompleteDTO> autocomplete(String query, Integer level, Integer limit) throws SQLException {
        final String functionCall = "{? = call PKG_LST_SPP.fn_autocomplete(?, ?, ?)}";
        CallableStatement callableSt = null;
        ResultSet rs = null;
        List<LstSPPAutoCompleteDTO> list = new ArrayList<>();
        try (Connection conn = jdbcTemplate.getDataSource().getConnection()) {

            callableSt = conn.prepareCall(functionCall);
            callableSt.registerOutParameter(1, Types.REF_CURSOR);
            callableSt.setString(2, query);
            callableSt.setInt(3, level);
            callableSt.setInt(4, limit);
            callableSt.execute();

            rs = (ResultSet) callableSt.getObject(1);
            while (rs.next()) {
                LstSPPAutoCompleteDTO lstSPPAutoCompleteDTO = new LstSPPAutoCompleteDTO();
                lstSPPAutoCompleteDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstSPPAutoCompleteDTO.setRNUM(rs.getInt("RNUM"));
                lstSPPAutoCompleteDTO.setSPPID(rs.getString("SPPID"));
                lstSPPAutoCompleteDTO.setNAME(rs.getString("NAME"));
                lstSPPAutoCompleteDTO.setADDR(rs.getString("ADDR"));
                lstSPPAutoCompleteDTO.setTEL(rs.getString("TEL"));
                lstSPPAutoCompleteDTO.setFAX(rs.getString("FAX"));
                lstSPPAutoCompleteDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstSPPAutoCompleteDTO.setSTATUS(rs.getString("STATUS"));
                lstSPPAutoCompleteDTO.setSPCID(rs.getString("SPCID"));
                lstSPPAutoCompleteDTO.setSPCNAME(rs.getString("SPCNAME"));
                lstSPPAutoCompleteDTO.setPOLID(rs.getString("POLID"));
                lstSPPAutoCompleteDTO.setPOLNAME(rs.getString("POLNAME"));
                lstSPPAutoCompleteDTO.setLOCAID(rs.getString("LOCAID"));
                lstSPPAutoCompleteDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstSPPAutoCompleteDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstSPPAutoCompleteDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstSPPAutoCompleteDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstSPPAutoCompleteDTO.setPOSITION(rs.getString("POSITION"));
                lstSPPAutoCompleteDTO.setSHORTNAME(rs.getString("SHORTNAME"));
                lstSPPAutoCompleteDTO.setLOCANAME(rs.getString("LOCANAME"));
                lstSPPAutoCompleteDTO.setSPPCODE(rs.getString("SPPCODE"));
                lstSPPAutoCompleteDTO.setSPPLEVEL(rs.getInt("SPPLEVEL"));
                lstSPPAutoCompleteDTO.setSPPPARENT(rs.getString("SPPPARENT"));
                lstSPPAutoCompleteDTO.setORDERCODE(rs.getString("ORDERCODE"));
                lstSPPAutoCompleteDTO.setISDEPART(rs.getString("ISDEPART"));
                lstSPPAutoCompleteDTO.setSPPIDFOX(rs.getString("SPPIDFOX"));
                lstSPPAutoCompleteDTO.setNAME_SYNC(rs.getString("NAME_SYNC"));
                list.add(lstSPPAutoCompleteDTO);
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
    public List<LstSPPSearchDTO> search(int rowIndex, int pageSize, String sortField, String sortOrder, String p_SppId, String p_Name, String p_Addr, String p_Tel, String p_Fax, String p_Csppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstSPPSearchDTO> rm = new SingleColumnRowMapper<LstSPPSearchDTO>() {
            @Override
            public LstSPPSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstSPPSearchDTO lstSPPSearchDTO = new LstSPPSearchDTO();
                lstSPPSearchDTO.setRowCount(rs.getLong("RowCount"));
                lstSPPSearchDTO.setrNum(rs.getInt("rNum"));
                lstSPPSearchDTO.setSppId(rs.getString("SppId"));
                lstSPPSearchDTO.setName(rs.getString("Name"));
                lstSPPSearchDTO.setAddr(rs.getString("Addr"));
                lstSPPSearchDTO.setTel(rs.getString("Tel"));
                lstSPPSearchDTO.setFax(rs.getString("Fax"));
                lstSPPSearchDTO.setDirector(rs.getString("Director"));
                lstSPPSearchDTO.setStatus(rs.getString("Status"));
                lstSPPSearchDTO.setSpcId(rs.getString("SpcId"));
                lstSPPSearchDTO.setSpcName(rs.getString("SpcName"));
                lstSPPSearchDTO.setPolId(rs.getString("PolId"));
                lstSPPSearchDTO.setPolName(rs.getString("PolName"));
                lstSPPSearchDTO.setLocaId(rs.getString("LocaId"));
                lstSPPSearchDTO.setCrtDate(rs.getDate("CrtDate"));
                lstSPPSearchDTO.setCrtUser(rs.getString("CrtUser"));
                lstSPPSearchDTO.setMdfDate(rs.getDate("MdfDate"));
                lstSPPSearchDTO.setMdfUser(rs.getString("MdfUser"));
                lstSPPSearchDTO.setPosition(rs.getString("Position"));
                lstSPPSearchDTO.setShortName(rs.getString("ShortName"));
                lstSPPSearchDTO.setLocaName(rs.getString("LocaName"));
                lstSPPSearchDTO.setSppCode(rs.getString("SppCode"));
                lstSPPSearchDTO.setSppLevel(rs.getString("SppLevel"));
                lstSPPSearchDTO.setSppParent(rs.getString("SppParent"));
                lstSPPSearchDTO.setOrderCode(rs.getString("OrderCode"));
                lstSPPSearchDTO.setIsDepart(rs.getString("IsDepart"));
                lstSPPSearchDTO.setSppIdFox(rs.getString("SppIdFox"));
                lstSPPSearchDTO.setNameSync(rs.getString("Name_Sync"));
                return lstSPPSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName("fn_search_2022")
                .returningResultSet("return", rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(p_SppId) ? null : p_SppId.trim())
                .addValue("p_name", Utils.StringIsNullOrEmpty(p_Name) ? null : p_Name.trim())
                .addValue("p_addr", Utils.StringIsNullOrEmpty(p_Addr) ? null : p_Addr.trim())
                .addValue("p_tel", Utils.StringIsNullOrEmpty(p_Tel) ? null : p_Tel.trim())
                .addValue("p_fax", Utils.StringIsNullOrEmpty(p_Fax) ? null : p_Fax.trim())
                .addValue("p_csppid", Utils.StringIsNullOrEmpty(p_Csppid) ? null : p_Csppid.trim());

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPPSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String findNameSppBySppId(Long sppId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT NAME FROM SPP.LST_SPP WHERE SPPID =:sppId");

        Object name = entityManager.createNativeQuery(sql.toString())
                .setParameter("sppId", sppId)
                .getSingleResult();
        if (name != null) {
            return name.toString();
        }
        return "";
    }

    @Override
    public LstSPPDTO getSPP(String sppId) {
        StringBuilder sql = new StringBuilder("SELECT sppid, name FROM lst_spp");
        sql.append(" WHERE sppid = '").append(sppId).append("'");
        return jdbcTemplate.queryForObject(sql.toString(), new SppMapper());
    }

    private static class SppMapper implements RowMapper<LstSPPDTO> {
        @Override
        public LstSPPDTO mapRow(ResultSet rs, int i) throws SQLException {
            LstSPPDTO lstSPPDTO = new LstSPPDTO();
            lstSPPDTO.setSppId(rs.getString("sppid"));
            lstSPPDTO.setName(rs.getString("name"));
            return lstSPPDTO;
        }
    }

    @Override
    public List<LstSPPAutoCompleteDTO> autocompleteForChangeInsp(String query, Integer level, Integer limit, String sppid) throws SQLException {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName("fn_autocomplete_2022")     
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit)
                .addValue("p_sppid", sppid);

        Map results = jdbcCall.execute(paramMap);
        return jdbcCall.executeFunction((Class<List<LstSPPAutoCompleteDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPP> getListSpp(String query, Integer items, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName("fn_get_list_spp");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_items", items)
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(LstSPP req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP)
                .withFunctionName(Constant.FUNCTION.FN_INSERT)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getSppid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_position", req.getPosition())
                .addValue("p_spplevel", req.getSpplevel())
                .addValue("p_sppparent", req.getSppparent())
                .addValue("p_ordercode", req.getOrdercode())
                .addValue("p_user", username)
                .addValue("p_newsppid", req.getNewsppid())
                .addValue("p_spcid", req.getAtxtspc() != null ? req.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", req.getAtxtspc() != null ? req.getAtxtspc().getName() : null)
                .addValue("p_isdepart", req.getIsdepart() ? "Y" : "N")
                .addValue("p_sppidfox",req.getSppidfox());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String update(LstSPP req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP)
                .withFunctionName(Constant.FUNCTION.FN_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getSppid())
                .addValue("p_name", req.getName())
                .addValue("p_sppparent", req.getSppparent())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_position", req.getPosition())
                .addValue("p_user", username)
                .addValue("p_spcid", req.getAtxtspc() != null ? req.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", req.getAtxtspc() != null ? req.getAtxtspc().getName() : null)
                .addValue("p_isdepart", req.getIsdepart() ? "Y" : "N")
                .addValue("p_sppidfox",req.getSppidfox());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }


    @Override
    public String getid(String sppid, Integer spplevel) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP)
                .withFunctionName(Constant.FUNCTION.FN_GETID)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spplevel", spplevel)
                .addValue("p_sppid", sppid);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
    @Override
    public String delete(LstSPP req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP)
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getSppid())
                .addValue("p_sppparent", req.getSppparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public LstSPP getBySppid(String sppid) {
        try {
            RowMapper<LstSPP> rm = new SingleColumnRowMapper<LstSPP>() {
                @Override
                public LstSPP mapRow(ResultSet rs, int rowNum) throws SQLException {
                    LstSPP dto = new LstSPP();
                    dto.setSppid(rs.getString("SPPID"));
                    dto.setName(rs.getString("NAME"));
                    dto.setAddr(rs.getString("ADDR"));
                    dto.setTel(rs.getString("TEL"));
                    dto.setFax(rs.getString("FAX"));
                    dto.setDirector(rs.getString("DIRECTOR"));
                    dto.setSpcid(rs.getString("SPCID"));
                    dto.setSpcname(rs.getString("SPCNAME"));
                    dto.setPosition(rs.getString("POSITION"));
                    return dto;
                }
            };
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                    .withFunctionName(Constant.FUNCTION.FN_GET)
                    .returningResultSet("return",rm);

            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_sppid", sppid);

            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap).stream().findFirst().orElse(new LstSPP());
        }catch (Exception e) {
            throw(e);
        }
    }


    //loadSppList
    @Override
    public List<LstSPP> getSpps(String sppid, String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_SPPS);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", sppid)
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPP>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPPSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstSPPSearchDTO> rm = new SingleColumnRowMapper<LstSPPSearchDTO>() {
            @Override
            public LstSPPSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstSPPSearchDTO lstSPPSearchDTO = new LstSPPSearchDTO();
                lstSPPSearchDTO.setSppId(rs.getString("SppId"));
                lstSPPSearchDTO.setName(rs.getString("Name"));
                lstSPPSearchDTO.setAddr(rs.getString("Addr"));
                lstSPPSearchDTO.setTel(rs.getString("Tel"));
                lstSPPSearchDTO.setFax(rs.getString("Fax"));
                lstSPPSearchDTO.setDirector(rs.getString("Director"));
                lstSPPSearchDTO.setStatus(rs.getString("Status"));
                lstSPPSearchDTO.setSpcId(rs.getString("SpcId"));
                lstSPPSearchDTO.setSpcName(rs.getString("SpcName"));
                lstSPPSearchDTO.setPolId(rs.getString("PolId"));
                lstSPPSearchDTO.setPolName(rs.getString("PolName"));
                lstSPPSearchDTO.setLocaId(rs.getString("LocaId"));
                lstSPPSearchDTO.setCrtDate(rs.getDate("CrtDate"));
                lstSPPSearchDTO.setCrtUser(rs.getString("CrtUser"));
                lstSPPSearchDTO.setMdfDate(rs.getDate("MdfDate"));
                lstSPPSearchDTO.setMdfUser(rs.getString("MdfUser"));
                lstSPPSearchDTO.setPosition(rs.getString("Position"));
                lstSPPSearchDTO.setShortName(rs.getString("ShortName"));
                lstSPPSearchDTO.setLocaName(rs.getString("LocaName"));
                lstSPPSearchDTO.setSppCode(rs.getString("SppCode"));
                lstSPPSearchDTO.setSppLevel(rs.getString("SppLevel"));
                lstSPPSearchDTO.setSppParent(rs.getString("SppParent"));
                lstSPPSearchDTO.setOrderCode(rs.getString("OrderCode"));
                lstSPPSearchDTO.setIsDepart(rs.getString("IsDepart"));
                lstSPPSearchDTO.setSppIdFox(rs.getString("SppIdFox"));
                lstSPPSearchDTO.setNameSync(rs.getString("Name_Sync"));
                lstSPPSearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));
                return lstSPPSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPP) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", Utils.StringIsNullOrEmpty(id) ? null : id)
                .addValue("p_spplevel", Utils.StringIsNullOrEmpty(level) ? null : level)
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPPSearchDTO>>) (Class) List.class, paramMap);
    }
}
