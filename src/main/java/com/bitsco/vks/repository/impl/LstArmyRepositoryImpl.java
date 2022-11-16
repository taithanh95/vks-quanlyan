package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstArmySearchDTO;
import com.bitsco.vks.entity.LstArmyEntity;
import com.bitsco.vks.repository.LstArmyRepository;
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
public class LstArmyRepositoryImpl implements LstArmyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstArmySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String armyid, String name, String addr, String tel, String fax, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstArmySearchDTO> rm = new SingleColumnRowMapper<LstArmySearchDTO>() {
            @Override
            public LstArmySearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstArmySearchDTO lstArmySearchDTO = new LstArmySearchDTO();
                lstArmySearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstArmySearchDTO.setRnum(rs.getInt("RNUM"));

                lstArmySearchDTO.setArmyid(rs.getString("ARMYID"));
                lstArmySearchDTO.setName(rs.getString("NAME"));
                lstArmySearchDTO.setAddr(rs.getString("ADDR"));
                lstArmySearchDTO.setTel(rs.getString("TEL"));
                lstArmySearchDTO.setFax(rs.getString("FAX"));
                lstArmySearchDTO.setDirector(rs.getString("DIRECTOR"));
//                lstArmySearchDTO.set(rs.getString("STATUS"));
                lstArmySearchDTO.setSpcid(rs.getString("SPCID"));
                lstArmySearchDTO.setSpcname(rs.getString("SPCNAME"));
                lstArmySearchDTO.setSppid(rs.getString("SPPID"));
                lstArmySearchDTO.setSppname(rs.getString("SPPNAME"));
                lstArmySearchDTO.setLocaid(rs.getString("LOCAID"));
                lstArmySearchDTO.setCtrdate(rs.getString("CRTDATE"));
                lstArmySearchDTO.setCtruser(rs.getString("CRTUSER"));
                lstArmySearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstArmySearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstArmySearchDTO.setPosition(rs.getString("POSITION"));
//                lstArmySearchDTO.set(rs.getString("SHORTNAME"));
//                lstArmySearchDTO.set(rs.getString("LOCANAME"));
                lstArmySearchDTO.setArmycode(rs.getString("ARMYCODE"));
                lstArmySearchDTO.setArmylevel(rs.getInt("ARMYLEVEL"));
                lstArmySearchDTO.setArmyparent(rs.getString("ARMYPARENT"));
                lstArmySearchDTO.setOrdercode(rs.getString("ORDERCODE"));
//                lstArmySearchDTO.set(rs.getString("SYNC"));

                return lstArmySearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_sppid", armyid)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_tel", tel)
                .addValue("p_fax", fax)
                .addValue("p_csppid", sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstArmySearchDTO>>) (Class) List.class, paramMap);
    }
    @Override
    public List<LstArmyEntity> autocomplete(String query, Integer level, int limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstArmyEntity>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(LstArmyEntity ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
                .withFunctionName("fn_insert")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getArmyid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr())
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_spplevel", String.valueOf(ls.getArmylevel()))
                .addValue("p_sppparent", ls.getArmyparent())
                .addValue("p_ordercode", ls.getOrdercode())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId)
                .addValue("p_newsppid", ls.getNewarmyid());

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String update(LstArmyEntity ls, String userId) {

        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", ls.getArmyid())
                .addValue("p_name", ls.getName())
                .addValue("p_addr", ls.getAddr()) // 1
                .addValue("p_tel", ls.getTel())
                .addValue("p_fax", ls.getFax())
                .addValue("p_director", ls.getDirector())
                .addValue("p_position", ls.getPosition())
                .addValue("p_sppparent", ls.getArmyparent())
                .addValue("p_spcid",ls.getAtxtspc() != null ? ls.getAtxtspc().getSpcid() : null)
                .addValue("p_spcname", ls.getAtxtspc() != null ? ls.getAtxtspc().getName() : null)
                .addValue("p_sppidin", ls.getAtxspp() != null ? ls.getAtxspp().getSppid() : null)
                .addValue("p_sppnamein", ls.getAtxspp() != null ? ls.getAtxspp().getName() : null)
                .addValue("p_user", userId);

        Map results = jdbcCall.execute(paramMap);
        return (String) results.get("return");
    }

    @Override
    public String delete(LstArmyEntity _spp){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", _spp.getArmyid())
                .addValue("p_sppparent", _spp.getArmyparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String getid(String sppid, Integer spplevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_ARMY") //package name
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
    public List<LstArmySearchDTO> getFnFindTreeData(String id, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstArmySearchDTO> rm = new SingleColumnRowMapper<LstArmySearchDTO>() {
            @Override
            public LstArmySearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstArmySearchDTO lstArmySearchDTO = new LstArmySearchDTO();
                lstArmySearchDTO.setArmyid(rs.getString("ARMYID"));
                lstArmySearchDTO.setName(rs.getString("NAME"));
                lstArmySearchDTO.setAddr(rs.getString("ADDR"));
                lstArmySearchDTO.setTel(rs.getString("TEL"));
                lstArmySearchDTO.setFax(rs.getString("FAX"));
                lstArmySearchDTO.setDirector(rs.getString("DIRECTOR"));
                lstArmySearchDTO.setSpcid(rs.getString("SPCID"));
                lstArmySearchDTO.setSpcname(rs.getString("SPCNAME"));
                lstArmySearchDTO.setSppid(rs.getString("SPPID"));
                lstArmySearchDTO.setSppname(rs.getString("SPPNAME"));
                lstArmySearchDTO.setLocaid(rs.getString("LOCAID"));
                lstArmySearchDTO.setCtrdate(rs.getString("CRTDATE"));
                lstArmySearchDTO.setCtruser(rs.getString("CRTUSER"));
                lstArmySearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstArmySearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstArmySearchDTO.setPosition(rs.getString("POSITION"));
                lstArmySearchDTO.setArmycode(rs.getString("ARMYCODE"));
                lstArmySearchDTO.setArmylevel(rs.getInt("ARMYLEVEL"));
                lstArmySearchDTO.setArmyparent(rs.getString("ARMYPARENT"));
                lstArmySearchDTO.setOrdercode(rs.getString("ORDERCODE"));
                lstArmySearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));

                return lstArmySearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_ARMY) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppcode", StringCommon.isNullOrBlank(id) ? null : id)
                .addValue("p_spplevel", StringCommon.isNullOrBlank(level) ? null : level)
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstArmySearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstArmySearchDTO> getArmyBySppId(String sppid) {
        SimpleJdbcCall jdbcCall;
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_ARMY) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstArmySearchDTO>>) (Class) List.class, paramMap);
    }
}
