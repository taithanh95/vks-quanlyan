package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.LstOfficeSearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.models.LstOfficeRequest;
import com.bitsco.vks.repository.LstOfficeRepository;
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
public class LstOfficeRepositoryImpl implements LstOfficeRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstOfficeSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String officeId, String officeName, String setLevel) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstOfficeSearchDTO> rm = new SingleColumnRowMapper<LstOfficeSearchDTO>() {
            @Override
            public LstOfficeSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstOfficeSearchDTO lstOfficeSearchDTO = new LstOfficeSearchDTO();
                lstOfficeSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstOfficeSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstOfficeSearchDTO.setOFFICEID(rs.getString("OFFICEID"));
                lstOfficeSearchDTO.setOFFICENAME(rs.getString("OFFICENAME"));
                lstOfficeSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstOfficeSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstOfficeSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstOfficeSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstOfficeSearchDTO.setSETLEVEL(rs.getString("SETLEVEL"));
                return lstOfficeSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_LST_OFFICE") //package name
                .withFunctionName("fn_search")
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_officeid", officeId)
                .addValue("p_officename", officeName)
                .addValue("p_setlevel", setLevel);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstOfficeSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstOfficeRequest req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_OFFICE)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_officeid", req.getOfficeId())
                .addValue("p_officename", req.getOfficeName())
                .addValue("p_setlevel", req.getSetLevel())
                .addValue("p_crtuser", username);

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstOfficeRequest req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_OFFICE) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_officeid", req.getOfficeId());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

}
