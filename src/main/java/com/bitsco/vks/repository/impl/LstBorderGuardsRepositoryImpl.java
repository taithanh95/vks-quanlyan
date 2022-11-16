package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstBorderGuardsSearchDTO;
import com.bitsco.vks.dto.LstCountrySearchDTO;
import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.SppCase;
import com.bitsco.vks.repository.LstBorderGuardsRepository;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
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
public class LstBorderGuardsRepositoryImpl implements LstBorderGuardsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstBorderGuardsSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String sppId, String name, String addr, String tel, String fax) {

        SimpleJdbcCall jdbcCall;
        RowMapper<LstBorderGuardsSearchDTO> rm = new SingleColumnRowMapper<LstBorderGuardsSearchDTO>() {
            @Override
            public LstBorderGuardsSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstBorderGuardsSearchDTO lstBorderGuardsSearchDTO = new LstBorderGuardsSearchDTO();
                lstBorderGuardsSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstBorderGuardsSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstBorderGuardsSearchDTO.setBORGUAID(rs.getString("BORGUAID"));
                lstBorderGuardsSearchDTO.setNAME(rs.getString("NAME"));
                lstBorderGuardsSearchDTO.setADDR(rs.getString("ADDR"));
                lstBorderGuardsSearchDTO.setTEL(rs.getString("TEL"));
                lstBorderGuardsSearchDTO.setFAX(rs.getString("FAX"));
                lstBorderGuardsSearchDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstBorderGuardsSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstBorderGuardsSearchDTO.setSPCID(rs.getString("SPCID"));
                lstBorderGuardsSearchDTO.setSPCNAME(rs.getString("SPCNAME"));
                lstBorderGuardsSearchDTO.setSPPID(rs.getString("SPPID"));
                lstBorderGuardsSearchDTO.setSPPNAME(rs.getString("SPPNAME"));
                lstBorderGuardsSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstBorderGuardsSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstBorderGuardsSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstBorderGuardsSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstBorderGuardsSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstBorderGuardsSearchDTO.setPOSITION(rs.getString("POSITION"));
                lstBorderGuardsSearchDTO.setSHORTNAME(rs.getString("SHORTNAME"));
                lstBorderGuardsSearchDTO.setLOCANAME(rs.getString("LOCANAME"));
                lstBorderGuardsSearchDTO.setBORGUACODE(rs.getString("BORGUACODE"));
                lstBorderGuardsSearchDTO.setBORGUALEVEL(rs.getString("BORGUALEVEL"));
                lstBorderGuardsSearchDTO.setBORGUAPARENT(rs.getString("BORGUAPARENT"));
                lstBorderGuardsSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                return lstBorderGuardsSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_sppid", sppId)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_tel", tel)
                .addValue("p_fax", fax);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstBorderGuardsSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(LstBorderGuards ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getBorguaid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr())
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_spplevel", String.valueOf(ls.getBorgualevel()))
                .addValue("p_sppparent", ls.getBorguaparent())
                .addValue("p_ordercode", ls.getOrdercode())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId)
                .addValue("p_newsppid", ls.getNewborguaid());

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String update(LstBorderGuards ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getBorguaid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr()) // 1
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_sppparent", ls.getBorguaparent())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String delete(LstBorderGuards _spp) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", _spp.getBorguaid())
                .addValue("p_sppparent", _spp.getBorguaparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstBorderGuards> autocomplete(String query, int level, int limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstBorderGuards>>) (Class) List.class, paramMap);
    }

    @Override
    public String getid(String sppid, Integer spplevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_BORDERGUARDS") //package name
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
    public List<LstBorderGuardsSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstBorderGuardsSearchDTO> rm = new SingleColumnRowMapper<LstBorderGuardsSearchDTO>() {
            @Override
            public LstBorderGuardsSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstBorderGuardsSearchDTO lstBorderGuardsSearchDTO = new LstBorderGuardsSearchDTO();
                lstBorderGuardsSearchDTO.setBORGUAID(rs.getString("BORGUAID"));
                lstBorderGuardsSearchDTO.setNAME(rs.getString("NAME"));
                lstBorderGuardsSearchDTO.setADDR(rs.getString("ADDR"));
                lstBorderGuardsSearchDTO.setTEL(rs.getString("TEL"));
                lstBorderGuardsSearchDTO.setFAX(rs.getString("FAX"));
                lstBorderGuardsSearchDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstBorderGuardsSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstBorderGuardsSearchDTO.setSPCID(rs.getString("SPCID"));
                lstBorderGuardsSearchDTO.setSPCNAME(rs.getString("SPCNAME"));
                lstBorderGuardsSearchDTO.setSPPID(rs.getString("SPPID"));
                lstBorderGuardsSearchDTO.setSPPNAME(rs.getString("SPPNAME"));
                lstBorderGuardsSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstBorderGuardsSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstBorderGuardsSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstBorderGuardsSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstBorderGuardsSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstBorderGuardsSearchDTO.setPOSITION(rs.getString("POSITION"));
                lstBorderGuardsSearchDTO.setSHORTNAME(rs.getString("SHORTNAME"));
                lstBorderGuardsSearchDTO.setLOCANAME(rs.getString("LOCANAME"));
                lstBorderGuardsSearchDTO.setBORGUACODE(rs.getString("BORGUACODE"));
                lstBorderGuardsSearchDTO.setBORGUALEVEL(rs.getString("BORGUALEVEL"));
                lstBorderGuardsSearchDTO.setBORGUAPARENT(rs.getString("BORGUAPARENT"));
                lstBorderGuardsSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                lstBorderGuardsSearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));
                return lstBorderGuardsSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_BORDERGUARDS) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", Utils.StringIsNullOrEmpty(id) ? null : id)
                .addValue("p_spplevel", Utils.StringIsNullOrEmpty(level) ? null : level)
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstBorderGuardsSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstBorderGuardsSearchDTO> getBorderGuardsBySppId(String sppid) {
        SimpleJdbcCall jdbcCall;
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_BORDERGUARDS) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstBorderGuardsSearchDTO>>) (Class) List.class, paramMap);
    }
}
