package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPoliceSearchDTO;
import com.bitsco.vks.entity.LstPolice;
import com.bitsco.vks.repository.LstPoliceRepository;
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

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Repository
public class LstPoliceRepositoryImpl implements LstPoliceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LstPolice> autocomplete(String query, Integer level, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPolice>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstPoliceSearchDTO> search(int rowIndex, int pageSize, String sortField, String sortOrder, String p_SppId, String p_Name, String p_Addr, String p_Tel, String p_Fax, String p_Csppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPoliceSearchDTO> rm = new SingleColumnRowMapper<LstPoliceSearchDTO>() {
            @Override
            public LstPoliceSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPoliceSearchDTO lstPoliceSearchDTO = new LstPoliceSearchDTO();
                  lstPoliceSearchDTO.setRowCount(rs.getLong("RowCount"));
                  lstPoliceSearchDTO.setrNum(rs.getInt("rNum"));
                  lstPoliceSearchDTO.setPoliceId(rs.getString("PoliceId"));
                  lstPoliceSearchDTO.setName(rs.getString("Name"));
                  lstPoliceSearchDTO.setAddr(rs.getString("Addr"));
                  lstPoliceSearchDTO.setTel(rs.getString("Tel"));
                  lstPoliceSearchDTO.setFax(rs.getString("Fax"));
                  lstPoliceSearchDTO.setDirector(rs.getString("Director"));
                  lstPoliceSearchDTO.setStatus(rs.getString("Status"));
                  lstPoliceSearchDTO.setSpcId(rs.getString("SpcId"));
                  lstPoliceSearchDTO.setSpcName(rs.getString("SpcName"));
                  lstPoliceSearchDTO.setSppId(rs.getString("SppId"));
                  lstPoliceSearchDTO.setSppName(rs.getString("SppName"));
                  lstPoliceSearchDTO.setLocaId(rs.getString("LocaId"));
                  lstPoliceSearchDTO.setCrtDate(rs.getDate("CrtDate"));
                  lstPoliceSearchDTO.setCrtUser(rs.getString("CrtUser"));
                  lstPoliceSearchDTO.setMdfDate(rs.getDate("MdfDate"));
                  lstPoliceSearchDTO.setMdfUser(rs.getString("MdfUser"));
                  lstPoliceSearchDTO.setPosition(rs.getString("Position"));
                  lstPoliceSearchDTO.setShortName(rs.getString("ShortName"));
                  lstPoliceSearchDTO.setLocaName(rs.getString("LocaName"));
                  lstPoliceSearchDTO.setPoliceCode(rs.getString("PoliceCode"));
                  lstPoliceSearchDTO.setPoliceLevel(rs.getString("PoliceLevel"));
                  lstPoliceSearchDTO.setPoliceParent(rs.getString("PoliceParent"));
                  lstPoliceSearchDTO.setOrderCode(rs.getString("OrderCode"));
                return lstPoliceSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
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
        return jdbcCall.executeFunction((Class<List<LstPoliceSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String findPoliceBySppId(Long sppId) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT NAME FROM SPP.LST_POLICE ");
        sql.append("WHERE SPPID =:sppId");
        return (String) em.createNativeQuery(sql.toString()).setParameter("sppId", sppId).getResultStream().findFirst().orElse(null);
    }


    @Override
    public LinkedCaseInsensitiveMap getfromspp(String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_get_fromspp");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);
    }

    @Override
    public String insert(LstPolice ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getPoliceid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr())
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_spplevel", String.valueOf(ls.getPolicelevel()))
                .addValue("p_sppparent", ls.getPoliceparent())
                .addValue("p_ordercode", ls.getOrdercode())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId)
                .addValue("p_newsppid", ls.getNewpoliceid());

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String update(LstPolice ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getPoliceid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr()) // 1
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_sppparent", ls.getPoliceparent())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String delete(LstPolice _spp) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", _spp.getPoliceid())
                .addValue("p_sppparent", _spp.getPoliceparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String getid(String sppid, Integer spplevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POLI") //package name
                .withFunctionName("fn_getid")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spplevel", spplevel)
                .addValue("p_sppid", sppid);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public List<LstPoliceSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPoliceSearchDTO> rm = new SingleColumnRowMapper<LstPoliceSearchDTO>() {
            @Override
            public LstPoliceSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPoliceSearchDTO lstPoliceSearchDTO = new LstPoliceSearchDTO();
                lstPoliceSearchDTO.setPoliceId(rs.getString("PoliceId"));
                lstPoliceSearchDTO.setName(rs.getString("Name"));
                lstPoliceSearchDTO.setAddr(rs.getString("Addr"));
                lstPoliceSearchDTO.setTel(rs.getString("Tel"));
                lstPoliceSearchDTO.setFax(rs.getString("Fax"));
                lstPoliceSearchDTO.setDirector(rs.getString("Director"));
                lstPoliceSearchDTO.setStatus(rs.getString("Status"));
                lstPoliceSearchDTO.setSpcId(rs.getString("SpcId"));
                lstPoliceSearchDTO.setSpcName(rs.getString("SpcName"));
                lstPoliceSearchDTO.setSppId(rs.getString("SppId"));
                lstPoliceSearchDTO.setSppName(rs.getString("SppName"));
                lstPoliceSearchDTO.setLocaId(rs.getString("LocaId"));
                lstPoliceSearchDTO.setCrtDate(rs.getDate("CrtDate"));
                lstPoliceSearchDTO.setCrtUser(rs.getString("CrtUser"));
                lstPoliceSearchDTO.setMdfDate(rs.getDate("MdfDate"));
                lstPoliceSearchDTO.setMdfUser(rs.getString("MdfUser"));
                lstPoliceSearchDTO.setPosition(rs.getString("Position"));
                lstPoliceSearchDTO.setShortName(rs.getString("ShortName"));
                lstPoliceSearchDTO.setLocaName(rs.getString("LocaName"));
                lstPoliceSearchDTO.setPoliceCode(rs.getString("PoliceCode"));
                lstPoliceSearchDTO.setPoliceLevel(rs.getString("PoliceLevel"));
                lstPoliceSearchDTO.setPoliceParent(rs.getString("PoliceParent"));
                lstPoliceSearchDTO.setOrderCode(rs.getString("OrderCode"));
                lstPoliceSearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));
                return lstPoliceSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_POLI) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", Utils.StringIsNullOrEmpty(id) ? null : id)
                .addValue("p_spplevel", Utils.StringIsNullOrEmpty(level) ? null : level)
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPoliceSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstPoliceSearchDTO> getPoliceLst(String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_POLI) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPoliceSearchDTO>>) (Class) List.class, paramMap);
    }
}
