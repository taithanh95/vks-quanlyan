package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.LstPolSearchDTO;
import com.bitsco.vks.entity.LstPol;
import com.bitsco.vks.repository.LstPolRepository;
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
public class LstPolRepositoryImpl implements LstPolRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstPolSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String polId, String name, String addr, String director) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPolSearchDTO> rm = new SingleColumnRowMapper<LstPolSearchDTO>() {
            @Override
            public LstPolSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPolSearchDTO lstPolSearchDTO = new LstPolSearchDTO();
                lstPolSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstPolSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstPolSearchDTO.setPOLID(rs.getString("POLID"));
                lstPolSearchDTO.setNAME(rs.getString("NAME"));
                lstPolSearchDTO.setADDR(rs.getString("ADDR"));
                lstPolSearchDTO.setTEL(rs.getString("TEL"));
                lstPolSearchDTO.setFAX(rs.getString("FAX"));
                lstPolSearchDTO.setDIRECTOR(rs.getString("DIRECTOR"));
                lstPolSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstPolSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstPolSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstPolSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                return lstPolSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POL") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_polid", polId)
                .addValue("p_name", name)
                .addValue("p_addr", addr)
                .addValue("p_director", director);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPolSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public List<LstPolSearchDTO> getAll() {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POL") //package name
                .withFunctionName("fn_getall");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CHECK", "");
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPolSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstPol req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POL") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_polid", req.getPolid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_director", req.getDirector())
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstPol req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_POL") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_polid", req.getPolid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
