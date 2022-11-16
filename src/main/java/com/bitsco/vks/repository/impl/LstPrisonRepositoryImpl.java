package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.LstPrisonSearchDTO;
import com.bitsco.vks.entity.LstPrison;
import com.bitsco.vks.repository.LstPrisonRepository;
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
public class LstPrisonRepositoryImpl implements LstPrisonRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstPrisonSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String prisonid, String name, String addr,  String ptype, String sppid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPrisonSearchDTO> rm = new SingleColumnRowMapper<LstPrisonSearchDTO>() {
            @Override
            public LstPrisonSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPrisonSearchDTO lstPrisonSearchDTO = new LstPrisonSearchDTO();
                lstPrisonSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstPrisonSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstPrisonSearchDTO.setPRISONID(rs.getString("PRISONID"));
                lstPrisonSearchDTO.setNAME(rs.getString("NAME"));
                lstPrisonSearchDTO.setADDR(rs.getString("ADDR"));
                lstPrisonSearchDTO.setTEL(rs.getString("TEL"));
                lstPrisonSearchDTO.setFAX(rs.getString("FAX"));
                lstPrisonSearchDTO.setPTYPE(rs.getString("PTYPE"));
                lstPrisonSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstPrisonSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstPrisonSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstPrisonSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstPrisonSearchDTO.setSPPID(rs.getString("SPPID"));
                lstPrisonSearchDTO.setSPPNAME(rs.getString("SPPNAME"));
                return lstPrisonSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_PRISON") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_prisonid", Utils.StringIsNullOrEmpty(prisonid) ? null : prisonid.trim())
                .addValue("p_name", Utils.StringIsNullOrEmpty(name) ? null : name.trim())
                .addValue("p_addr", Utils.StringIsNullOrEmpty(addr) ? null : addr.trim())
                .addValue("p_ptype", Utils.StringIsNullOrEmpty(ptype) ? null : ptype.trim())
                .addValue("p_sppid", Utils.StringIsNullOrEmpty(sppid) ? null : sppid.trim());
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPrisonSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstPrison req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_PRISON") //package name
                .withFunctionName("fn_insert_update")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_prisonid", req.getPrisonid())
                .addValue("p_name", req.getName())
                .addValue("p_addr", req.getAddr())
                .addValue("p_tel", req.getTel())
                .addValue("p_fax", req.getFax())
                .addValue("p_ptype", req.getPtype())
                .addValue("p_crtuser", username)
                .addValue("p_mdfuser", username)
                .addValue("p_sppid", req.getSppid());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstPrison req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_PRISON") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_prisonid", req.getPrisonid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
