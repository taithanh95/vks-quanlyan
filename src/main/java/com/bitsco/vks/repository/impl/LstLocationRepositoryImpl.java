package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLocationSearchDTO;
import com.bitsco.vks.entity.LstBorderGuards;
import com.bitsco.vks.entity.LstLocation;
import com.bitsco.vks.repository.LstLocationRepository;
import com.bitsco.vks.utils.ArrayListCommon;
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
public class LstLocationRepositoryImpl implements LstLocationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstLocationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String locaid, String name, String remark, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLocationSearchDTO> rm = new SingleColumnRowMapper<LstLocationSearchDTO>() {
            @Override
            public LstLocationSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLocationSearchDTO lstLocationSearchDTO = new LstLocationSearchDTO();
                lstLocationSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstLocationSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstLocationSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstLocationSearchDTO.setNAME(rs.getString("NAME"));
                lstLocationSearchDTO.setREMARK(rs.getString("REMARK"));
                lstLocationSearchDTO.setSTDCODE(rs.getString("STDCODE"));
                lstLocationSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstLocationSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstLocationSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstLocationSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstLocationSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstLocationSearchDTO.setL1NAME(rs.getString("L1NAME"));
                lstLocationSearchDTO.setL2NAME(rs.getString("L2NAME"));
                lstLocationSearchDTO.setLOCACODE(rs.getString("LOCACODE"));
                lstLocationSearchDTO.setLOCALEVEL(rs.getString("LOCALEVEL"));
                lstLocationSearchDTO.setLOCAPARENT(rs.getString("LOCAPARENT"));
                lstLocationSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                lstLocationSearchDTO.setSYNC(rs.getInt("SYNC"));
                return lstLocationSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_locaid", locaid)
                .addValue("p_name", name)
                .addValue("p_remark", remark)
                .addValue("p_sppid", sppid);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLocationSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstLocation> autocomplete(String query, Integer level, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLocation>>) (Class) List.class, paramMap);
    }

    @Override
    public LstLocation getLocationById(String id) {

        RowMapper<LstLocation> rm = new SingleColumnRowMapper<LstLocation>() {
            @Override
            public LstLocation mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLocation response = new LstLocation();
                response.setLocaid(rs.getString("LOCAID"));
                response.setName(rs.getString("NAME"));
                response.setRemark(rs.getString("REMARK"));
                response.setLocacode(rs.getString("LOCACODE"));
                response.setLocalevel(rs.getString("LOCALEVEL"));
                response.setLocaparent(rs.getString("LOCAPARENT"));
                response.setOrdercode(rs.getString("ORDERCODE"));
                response.setStatus(rs.getString("STATUS"));
                return response;
            }
        };

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_get")
                .returningResultSet("return",rm);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_locaid", id);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLocation>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);
    }

    @Override
    public String insert(LstLocation ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_locaid", ls.getLocaid())
                .addValue("p_name", ls.getName())
                .addValue("p_localevel", ls.getLocalevel())
                .addValue("p_locaparent", ls.getLocaparent())
                .addValue("p_ordercode", ls.getOrdercode())
                .addValue("p_newlocaid", ls.getNewlocaid())
                .addValue("p_remark", ls.getRemark())
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String update(LstLocation ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_locaid", ls.getLocaid())
                .addValue("p_name", ls.getName())
                .addValue("p_locaparent", ls.getLocaparent()) // 1
                .addValue("p_remark", ls.getRemark())
                .addValue("p_l1name", ls.getL1name())
                .addValue("p_l2name", ls.getL2name())
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String delete(LstLocation _spp){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_locaid", _spp.getLocaid())
                .addValue("p_locaparent", _spp.getLocaparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String getid(String locaid, Integer localevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName("fn_getid")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_localevel", localevel)
                .addValue("p_locaid", locaid);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public List<LstLocationSearchDTO> getFnFindTreeData(String locaid, String localevel, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLocationSearchDTO> rm = new SingleColumnRowMapper<LstLocationSearchDTO>() {
            @Override
            public LstLocationSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLocationSearchDTO lstLocationSearchDTO = new LstLocationSearchDTO();
                lstLocationSearchDTO.setLOCAID(rs.getString("LOCAID"));
                lstLocationSearchDTO.setNAME(rs.getString("NAME"));
                lstLocationSearchDTO.setREMARK(rs.getString("REMARK"));
                lstLocationSearchDTO.setSTDCODE(rs.getString("STDCODE"));
                lstLocationSearchDTO.setSTATUS(rs.getString("STATUS"));
                lstLocationSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstLocationSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstLocationSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstLocationSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstLocationSearchDTO.setL1NAME(rs.getString("L1NAME"));
                lstLocationSearchDTO.setL2NAME(rs.getString("L2NAME"));
                lstLocationSearchDTO.setLOCACODE(rs.getString("LOCACODE"));
                lstLocationSearchDTO.setLOCALEVEL(rs.getString("LOCALEVEL"));
                lstLocationSearchDTO.setLOCAPARENT(rs.getString("LOCAPARENT"));
                lstLocationSearchDTO.setORDERCODE(rs.getString("ORDERCODE"));
                lstLocationSearchDTO.setSYNC(rs.getInt("SYNC"));
                lstLocationSearchDTO.setPLUSCHILDREN(rs.getString("PLUSCHILDREN"));
                return lstLocationSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_LOCATION") //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_locacode", StringCommon.isNullOrBlank(locaid) ? null : locaid)
                .addValue("p_localevel", StringCommon.isNullOrBlank(localevel) ? null : localevel)
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLocationSearchDTO>>) (Class) List.class, paramMap);
    }
}
