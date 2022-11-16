package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstPartySearchDTO;
import com.bitsco.vks.entity.LstParty;
import com.bitsco.vks.repository.LstPartyRepository;
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
public class LstPartyRepositoryImpl implements LstPartyRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstPartySearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String partyId, String partyName) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstPartySearchDTO> rm = new SingleColumnRowMapper<LstPartySearchDTO>() {
            @Override
            public LstPartySearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstPartySearchDTO lstPartySearchDTO = new LstPartySearchDTO();
                lstPartySearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstPartySearchDTO.setRNUM(rs.getInt("RNUM"));
                lstPartySearchDTO.setPARTYID(rs.getString("PARTYID"));
                lstPartySearchDTO.setPARTYNAME(rs.getString("PARTYNAME"));
                lstPartySearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstPartySearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstPartySearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstPartySearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstPartySearchDTO.setSETLEVEL(rs.getString("SETLEVEL"));
                lstPartySearchDTO.setSETCOMMITTEE(rs.getString("SETCOMMITTEE"));
                lstPartySearchDTO.setREMARK(rs.getString("REMARK"));
                return lstPartySearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PARTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_partyid", partyId)
                .addValue("p_partyname", partyName);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstPartySearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstParty req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PARTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_partyid", req.getPartyid())
                .addValue("p_partyname", req.getPartyname())
                .addValue("p_crtuser", username)
                .addValue("p_setlevel", req.getSetlevel())
                .addValue("p_setcommittee", req.getSetcommittee())
                .addValue("p_remark", req.getRemark());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstParty req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_PARTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_partyid", req.getPartyid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
