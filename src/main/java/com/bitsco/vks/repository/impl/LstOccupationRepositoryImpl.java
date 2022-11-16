package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstNationSearchDTO;
import com.bitsco.vks.dto.LstOccupationSearchDTO;
import com.bitsco.vks.repository.LstOccupationRepository;
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
public class LstOccupationRepositoryImpl implements LstOccupationRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstOccupationSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String occuId, String name, String branchJob) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstOccupationSearchDTO> rm = new SingleColumnRowMapper<LstOccupationSearchDTO>() {
            @Override
            public LstOccupationSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstOccupationSearchDTO lstOccupationSearchDTO = new LstOccupationSearchDTO();
                lstOccupationSearchDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstOccupationSearchDTO.setRNUM(rs.getInt("RNUM"));
                lstOccupationSearchDTO.setOCCUID(rs.getString("OCCUID"));
                lstOccupationSearchDTO.setNAME(rs.getString("NAME"));
                lstOccupationSearchDTO.setREMARK(rs.getString("REMARK"));
                lstOccupationSearchDTO.setCRTUSER(rs.getString("CRTUSER"));
                lstOccupationSearchDTO.setMDFUSER(rs.getString("MDFUSER"));
                lstOccupationSearchDTO.setCRTDATE(rs.getString("CRTDATE"));
                lstOccupationSearchDTO.setMDFDATE(rs.getString("MDFDATE"));
                lstOccupationSearchDTO.setBRANCHJOB(rs.getString("BRANCHJOB"));
                return lstOccupationSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_OCCUPATION) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortcol", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_occuid", occuId)
                .addValue("p_name", name)
                .addValue("p_branchjob", branchJob);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstOccupationSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insert(String action, String occuid, String name, String remark, String branchjob, String user) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_OCCUPATION)
                    .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE);
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_action",action)
                    .addValue("p_occuid", occuid)
                    .addValue("p_name", StringCommon.isNullOrBlank(name) ? null : name)
                    .addValue("p_remark", remark)
                    .addValue("p_crtuser", user)
                    .addValue("p_branchjob", branchjob);
            Map result = jdbcCall.execute(param);
            return (String) result.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String occuid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_OCCUPATION)
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_occuid", occuid);

            Map result = jdbcCall.execute(param);
            return (String) result.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public List<LstOccupationSearchDTO> getOccupation(String query, Integer limit) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_OCCUPATION) //package name
                .withFunctionName(Constant.FUNCTION.FN_GET_ATXOCCUPATION);

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_query", query)
                .addValue("p_limit", limit);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstOccupationSearchDTO>>) (Class) List.class, paramMap);
    }
}
