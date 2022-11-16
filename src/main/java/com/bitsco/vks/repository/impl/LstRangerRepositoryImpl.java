package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstCustomsSearchDTO;
import com.bitsco.vks.dto.LstRangerSearchDTO;
import com.bitsco.vks.entity.LstRanger;
import com.bitsco.vks.repository.LstRangerRepository;
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
public class LstRangerRepositoryImpl implements LstRangerRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstRangerSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String rangid, String name, String addr, String tel, String fax, String sppId) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstRangerSearchDTO> rm = new SingleColumnRowMapper<LstRangerSearchDTO>() {
            @Override
            public LstRangerSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstRangerSearchDTO lstRangerSearchDTO = new LstRangerSearchDTO();
                lstRangerSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstRangerSearchDTO.setRnum(rs.getInt("RNUM"));

                lstRangerSearchDTO.setRangid(rs.getString("RANGID"));
                lstRangerSearchDTO.setName(rs.getString("NAME"));
                lstRangerSearchDTO.setAddr(rs.getString("ADDR"));
                lstRangerSearchDTO.setTel(rs.getString("TEL"));
                lstRangerSearchDTO.setFax(rs.getString("FAX"));
                lstRangerSearchDTO.setDirector(rs.getString("DIRECTOR"));
                //lstRangerSearchDTO.set(rs.getString("STATUS"));
                lstRangerSearchDTO.setSpcid(rs.getString("SPCID"));
                lstRangerSearchDTO.setSpcname(rs.getString("SPCNAME"));
                lstRangerSearchDTO.setSppid(rs.getString("SPPID"));
                lstRangerSearchDTO.setSppname(rs.getString("SPPNAME"));
                lstRangerSearchDTO.setLocaid(rs.getString("LOCAID"));
                lstRangerSearchDTO.setCtrdate(rs.getString("CRTDATE"));
                lstRangerSearchDTO.setCtruser(rs.getString("CRTUSER"));
                lstRangerSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstRangerSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstRangerSearchDTO.setPosition(rs.getString("POSITION"));
//                lstRangerSearchDTO.set(rs.getString("SHORTNAME"));
//                lstRangerSearchDTO.set(rs.getString("LOCANAME"));
                lstRangerSearchDTO.setRangcode(rs.getString("RANGCODE"));
                lstRangerSearchDTO.setRanglevel(rs.getInt("RANGLEVEL"));
                lstRangerSearchDTO.setRangparent(rs.getString("RANGPARENT"));
                lstRangerSearchDTO.setOrdercode(rs.getString("ORDERCODE"));
                return lstRangerSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_sppid", rangid)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_tel", tel)
                .addValue("p_fax", fax)
                .addValue("p_csppid", sppId);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstRangerSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstRanger> autocomplete(String query, Integer level, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstRanger>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(LstRanger ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getRangid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr())
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_spplevel", String.valueOf(ls.getRanglevel()))
                .addValue("p_sppparent", ls.getRangparent())
                .addValue("p_ordercode", ls.getOrdercode())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId)
                .addValue("p_newsppid", ls.getNewrangid());

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String update(LstRanger ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getRangid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr()) // 1
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_sppparent", ls.getRangparent())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String delete(LstRanger _spp){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", _spp.getRangid())
                .addValue("p_sppparent", _spp.getRangparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String getid(String sppid, Integer spplevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_RANGER") //package name
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
    public List<LstRangerSearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstRangerSearchDTO> rm = new SingleColumnRowMapper<LstRangerSearchDTO>() {
            @Override
            public LstRangerSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstRangerSearchDTO lstRangerSearchDTO = new LstRangerSearchDTO();
                lstRangerSearchDTO.setRangid(rs.getString("RANGID"));
                lstRangerSearchDTO.setName(rs.getString("NAME"));
                lstRangerSearchDTO.setAddr(rs.getString("ADDR"));
                lstRangerSearchDTO.setTel(rs.getString("TEL"));
                lstRangerSearchDTO.setFax(rs.getString("FAX"));
                lstRangerSearchDTO.setDirector(rs.getString("DIRECTOR"));
                lstRangerSearchDTO.setSpcid(rs.getString("SPCID"));
                lstRangerSearchDTO.setSpcname(rs.getString("SPCNAME"));
                lstRangerSearchDTO.setSppid(rs.getString("SPPID"));
                lstRangerSearchDTO.setSppname(rs.getString("SPPNAME"));
                lstRangerSearchDTO.setLocaid(rs.getString("LOCAID"));
                lstRangerSearchDTO.setCtrdate(rs.getString("CRTDATE"));
                lstRangerSearchDTO.setCtruser(rs.getString("CRTUSER"));
                lstRangerSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstRangerSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstRangerSearchDTO.setPosition(rs.getString("POSITION"));
                lstRangerSearchDTO.setRangcode(rs.getString("RANGCODE"));
                lstRangerSearchDTO.setRanglevel(rs.getInt("RANGLEVEL"));
                lstRangerSearchDTO.setRangparent(rs.getString("RANGPARENT"));
                lstRangerSearchDTO.setOrdercode(rs.getString("ORDERCODE"));
                lstRangerSearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));
                return lstRangerSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_RANGER) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", StringCommon.isNullOrBlank(id) ? null : id)
                .addValue("p_spplevel", StringCommon.isNullOrBlank(level) ? null : level)
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstRangerSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstRangerSearchDTO> getRangerBySppId(String sppid) {
        SimpleJdbcCall jdbcCall;
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_RANGER) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstRangerSearchDTO>>) (Class) List.class, paramMap);
    }
}
