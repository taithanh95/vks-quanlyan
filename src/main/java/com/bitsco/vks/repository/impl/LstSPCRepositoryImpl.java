package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstSPCSearchDTO;
import com.bitsco.vks.entity.LstCustoms;
import com.bitsco.vks.entity.LstSPC;
import com.bitsco.vks.entity.LstSPP;
import com.bitsco.vks.repository.LstSPCRepository;
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
public class LstSPCRepositoryImpl implements LstSPCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstSPCSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String spcId, String name, String addr, String sppId) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstSPCSearchDTO> rm = new SingleColumnRowMapper<LstSPCSearchDTO>() {
            @Override
            public LstSPCSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstSPCSearchDTO lstSPCSearchDTO = new LstSPCSearchDTO();
                lstSPCSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstSPCSearchDTO.setRnum(rs.getInt("RNUM"));

                lstSPCSearchDTO.setSpcid(rs.getString("SPCID"));
                lstSPCSearchDTO.setName(rs.getString("NAME"));
                lstSPCSearchDTO.setAddr(rs.getString("ADDR"));
                lstSPCSearchDTO.setTel(rs.getString("TEL"));
                lstSPCSearchDTO.setFax(rs.getString("FAX"));
                lstSPCSearchDTO.setDirector(rs.getString("DIRECTOR"));
                lstSPCSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstSPCSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstSPCSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstSPCSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstSPCSearchDTO.setSpccode(rs.getString("SPCCODE"));
                lstSPCSearchDTO.setSpclevel(rs.getString("SPCLEVEL"));
                lstSPCSearchDTO.setSpcparent(rs.getString("SPCPARENT"));
                lstSPCSearchDTO.setOrdercode(rs.getString("ORDERCODE"));
                lstSPCSearchDTO.setLocaid(rs.getString("LOCAID"));
                return lstSPCSearchDTO;

            }
        };

        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SPC") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : "ASC")
                .addValue("p_spcid", spcId)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_cspcid", sppId);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPCSearchDTO>>) (Class) List.class, paramMap);
    }
    @Override
    public List<LstSPC> autocomplete(String query, Integer level, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SPC") //package name
                .withFunctionName("fn_autocomplete");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_level", level)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPC>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPC> getFromSpp(String spcid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SPC") //package name
                .withFunctionName("fn_get_fromspp");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spcid", spcid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPC>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPC> getFromSpp2022(String spcid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_SPC") //package name
                .withFunctionName("fn_get_fromspp_2022");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spcid", spcid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPC>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(LstSPC req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC)
                .withFunctionName(Constant.FUNCTION.FN_INSERT)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spcid", req.getSpcid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_spclevel", req.getSpclevel())
                .addValue("p_ordercode", req.getOrdercode())
                .addValue("p_user", username)
                .addValue("p_newspcid", req.getNewspcid());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String update(LstSPC req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC)
                .withFunctionName(Constant.FUNCTION.FN_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spcid", req.getSpcid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_spcparent", req.getSpcparent())
                .addValue("p_user", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstSPC req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spcid", req.getSpcid())
                .addValue("p_spcparent", req.getSpcparent());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    public String getid(String spcid, Integer spclevel){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC)
                .withFunctionName(Constant.FUNCTION.FN_GETID)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spclevel", spclevel)
                .addValue("p_spcid", spcid);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LstSPC> getListSpc(String query) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC)
                .withFunctionName(Constant.FUNCTION.FN_GET_LIST);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPC>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstSPCSearchDTO> getFnFindTreeData(String sppcode, String level, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstSPCSearchDTO> rm = new SingleColumnRowMapper<LstSPCSearchDTO>() {
            @Override
            public LstSPCSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstSPCSearchDTO lstSPCSearchDTO = new LstSPCSearchDTO();
                lstSPCSearchDTO.setSpcid(rs.getString("SPCID"));
                lstSPCSearchDTO.setName(rs.getString("NAME"));
                lstSPCSearchDTO.setAddr(rs.getString("ADDR"));
                lstSPCSearchDTO.setTel(rs.getString("TEL"));
                lstSPCSearchDTO.setFax(rs.getString("FAX"));
                lstSPCSearchDTO.setDirector(rs.getString("DIRECTOR"));
                lstSPCSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstSPCSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstSPCSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstSPCSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                lstSPCSearchDTO.setSpccode(rs.getString("SPCCODE"));
                lstSPCSearchDTO.setSpclevel(rs.getString("SPCLEVEL"));
                lstSPCSearchDTO.setSpcparent(rs.getString("SPCPARENT"));
                lstSPCSearchDTO.setOrdercode(rs.getString("ORDERCODE"));
                lstSPCSearchDTO.setLocaid(rs.getString("LOCAID"));
                lstSPCSearchDTO.setPluschildren(rs.getString("PLUSCHILDREN"));
                return lstSPCSearchDTO;

            }
        };

        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_SPC) //package name
                .withFunctionName(Constant.FUNCTION.FN_FIND_2022)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_spccode", StringCommon.isNullOrBlank(sppcode) ? null : sppcode)
                .addValue("p_spclevel", StringCommon.isNullOrBlank(level) ? null : level)
                .addValue("p_spcid", StringCommon.isNullOrBlank(sppid) ? null : sppid);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstSPCSearchDTO>>) (Class) List.class, paramMap);
    }
}
