package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstReligionSearchDTO;
import com.bitsco.vks.repository.LstReligionRepository;
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
public class LstReligionRepositoryImpl implements LstReligionRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstReligionSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String name, String note) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstReligionSearchDTO> rm = new SingleColumnRowMapper<LstReligionSearchDTO>() {
            @Override
            public LstReligionSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstReligionSearchDTO lstReligionSearchDTO = new LstReligionSearchDTO();
                lstReligionSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstReligionSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstReligionSearchDTO.setRELIGIONID(rs.getString("RELIGIONID"));
                lstReligionSearchDTO.setRELIGIONNAME(rs.getString("RELIGIONNAME"));
                lstReligionSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstReligionSearchDTO.setRELIGIONNOTE(rs.getString("RELIGIONNOTE"));
                lstReligionSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstReligionSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstReligionSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                return lstReligionSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_RELIGION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_id", id)
                .addValue("p_name", name)
                .addValue("p_note", note);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstReligionSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String religionid, String religioname, String religionote, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RELIGION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_action", action)
                    .addValue("p_religionid", religionid)
                    .addValue("p_religionname", religioname)
                    .addValue("p_religionnote", religionote)
                    .addValue("p_crtuser", username);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String religionid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_RELIGION) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_religionid", religionid);

            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }


}
