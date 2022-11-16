package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.repository.LstCustomsRepository;
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

@Repository
public class LstCustomsRepositoryImpl implements LstCustomsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstCustomsSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String sppid, String name, String addr, String tel, String fax, String spcid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstCustomsSearchDTO> rm = new SingleColumnRowMapper<LstCustomsSearchDTO>() {
            @Override
            public LstCustomsSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstCustomsSearchDTO lstCustomsSearchDTO = new LstCustomsSearchDTO();
                lstCustomsSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstCustomsSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstCustomsSearchDTO.setCUSTOMID(rs.getString("CUSTOMID"));
                lstCustomsSearchDTO.setNAME(rs.getString("NAME"));
                lstCustomsSearchDTO.setADDR(rs.getString("ADDR"));
                lstCustomsSearchDTO.setTEL(rs.getString("TEL"));
                lstCustomsSearchDTO.setFAX(rs.getString("FAX"));
                lstCustomsSearchDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstCustomsSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstCustomsSearchDTO.setSPCID(rs.getString("SPCID"));
                lstCustomsSearchDTO.setSPCNAME(rs.getString("SPCNAME"));
                lstCustomsSearchDTO.setSPPID(rs.getString("SPPID"));
                lstCustomsSearchDTO.setSPPNAME(rs.getString("SPPNAME"));
                lstCustomsSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstCustomsSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCustomsSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCustomsSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCustomsSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstCustomsSearchDTO.setPOSITION(rs.getString("POSITION"));
                lstCustomsSearchDTO.setSHORTNAME(rs.getString("SHORTNAME"));
                lstCustomsSearchDTO.setLOCANAME(rs.getString("LOCANAME"));
                lstCustomsSearchDTO.setCUSTOMCODE(rs.getString("CUSTOMCODE"));
                lstCustomsSearchDTO.setCUSTOMLEVEL(rs.getString("CUSTOMLEVEL"));
                lstCustomsSearchDTO.setCUSTOMPARENT(rs.getString("CUSTOMPARENT"));
                lstCustomsSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                return lstCustomsSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_CUSTOMS") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_sppid", sppid)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_tel", tel)
                .addValue("p_fax", fax)
                .addValue("p_csppid", spcid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCustomsSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstCustoms> autocomplete(String query, Integer level, int limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_CUSTOMS") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCustoms>>) (Class) List.class, paramMap);
    }

    public String insert(LstCustoms req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
                .withFunctionName(Constant.FUNCTION.FN_INSERT)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getCustomid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_position", req.getPosition())
                .addValue("p_spplevel", req.getCustomlevel())
                .addValue("p_sppparent", req.getCustomparent())
                .addValue("p_ordercode", req.getOrdercode())
                .addValue("p_user", username)
                .addValue("p_newsppid", req.getNewcustomid())
                .addValue("p_spcid", req.getAtxtspc() != null ? req.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", req.getAtxtspc() != null ? req.getAtxtspc().getName() : null)
                .addValue("p_sppidin", req.getAtxspp() != null ? req.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein",req.getAtxspp() != null ? req.getAtxspp().getName() : null);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    public String update(LstCustoms req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
                .withFunctionName(Constant.FUNCTION.FN_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getCustomid())
                .addValue("p_name", req.getName())
                .addValue("p_sppparent", req.getCustomparent())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_position", req.getPosition())
                .addValue("p_user", username)
                .addValue("p_spcid", req.getAtxtspc() != null ? req.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", req.getAtxtspc() != null ? req.getAtxtspc().getName() : null)
                .addValue("p_sppidin", req.getAtxspp() != null ? req.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein",req.getAtxspp() != null ? req.getAtxspp().getName() : null);


        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    public String getid(String sppid, Integer spplevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
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
    public String delete(LstCustoms req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", req.getCustomid())
                .addValue("p_sppparent", req.getCustomparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstCustomsSearchDTO> getFnFindTreeData(String cumstoid, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstCustomsSearchDTO> rm = new SingleColumnRowMapper<LstCustomsSearchDTO>() {
            @Override
            public LstCustomsSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstCustomsSearchDTO lstCustomsSearchDTO = new LstCustomsSearchDTO();
                lstCustomsSearchDTO.setCUSTOMID(rs.getString("CUSTOMID"));
                lstCustomsSearchDTO.setNAME(rs.getString("NAME"));
                lstCustomsSearchDTO.setADDR(rs.getString("ADDR"));
                lstCustomsSearchDTO.setTEL(rs.getString("TEL"));
                lstCustomsSearchDTO.setFAX(rs.getString("FAX"));
                lstCustomsSearchDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstCustomsSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstCustomsSearchDTO.setSPCID(rs.getString("SPCID"));
                lstCustomsSearchDTO.setSPCNAME(rs.getString("SPCNAME"));
                lstCustomsSearchDTO.setSPPID(rs.getString("SPPID"));
                lstCustomsSearchDTO.setSPPNAME(rs.getString("SPPNAME"));
                lstCustomsSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstCustomsSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstCustomsSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstCustomsSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstCustomsSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstCustomsSearchDTO.setPOSITION(rs.getString("POSITION"));
                lstCustomsSearchDTO.setSHORTNAME(rs.getString("SHORTNAME"));
                lstCustomsSearchDTO.setLOCANAME(rs.getString("LOCANAME"));
                lstCustomsSearchDTO.setCUSTOMCODE(rs.getString("CUSTOMCODE"));
                lstCustomsSearchDTO.setCUSTOMLEVEL(rs.getString("CUSTOMLEVEL"));
                lstCustomsSearchDTO.setCUSTOMPARENT(rs.getString("CUSTOMPARENT"));
                lstCustomsSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                lstCustomsSearchDTO.setPLUSCHILDREN(rs.getString("PLUSCHILDREN"));
                return lstCustomsSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", StringCommon.isNullOrBlank(cumstoid) ? null : cumstoid)
                .addValue("p_spplevel", StringCommon.isNullOrBlank(level) ? null : level)
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCustomsSearchDTO>>) (Class) List.class, paramMap);
    }


    @Override
    public List<LstCustomsSearchDTO> getCustomsBySppId(String sppid) {
        SimpleJdbcCall jdbcCall;
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_CUSTOMS) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstCustomsSearchDTO>>) (Class) List.class, paramMap);
    }

}
