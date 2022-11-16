package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawPenaltyDTO;
import com.bitsco.vks.entity.LstLawPenalty;
import com.bitsco.vks.repository.LstLawPenaltyRepository;
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

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 1:40 PM
 */
@Repository
public class LstLawPenaltyRepositoryImpl implements LstLawPenaltyRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstLawPenaltyDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String lawid, String item, String point, String lawname, String codeid, String groupid) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstLawPenaltyDTO> rm = new SingleColumnRowMapper<LstLawPenaltyDTO>() {
            @Override
            public LstLawPenaltyDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstLawPenaltyDTO lstLawPenaltyDTO = new LstLawPenaltyDTO();
                lstLawPenaltyDTO.setROWCOUNT(rs.getLong("ROWCOUNT"));
                lstLawPenaltyDTO.setRNUM(rs.getInt("RNUM"));
                lstLawPenaltyDTO.setLAWCODE(rs.getString("LAWCODE"));
                lstLawPenaltyDTO.setLAWID(rs.getString("LAWID"));
                lstLawPenaltyDTO.setITEM(rs.getString("ITEM"));
                lstLawPenaltyDTO.setPOINT(rs.getString("POINT"));
                lstLawPenaltyDTO.setLAWNAME(rs.getString("LAWNAME"));
                lstLawPenaltyDTO.setLAWNAMECUT(rs.getString("LAWNAMECUT"));
                lstLawPenaltyDTO.setLAWDATE(rs.getDate("LAWDATE"));
                lstLawPenaltyDTO.setLAWTYPE(rs.getString("LAWTYPE"));
                lstLawPenaltyDTO.setFROMAMOUNT(rs.getInt("FROMAMOUNT"));
                lstLawPenaltyDTO.setTOAMOUNT(rs.getInt("TOAMOUNT"));
                lstLawPenaltyDTO.setCODEID(rs.getString("CODEID"));
                lstLawPenaltyDTO.setCODENAME(rs.getString("CODENAME"));
                lstLawPenaltyDTO.setGROUPID(rs.getString("GROUPID"));
                lstLawPenaltyDTO.setGROUPNAME(rs.getString("GROUPNAME"));
                lstLawPenaltyDTO.setPENALTYID(rs.getString("PENALTYID"));
                lstLawPenaltyDTO.setPENALTYNAME(rs.getString("PENALTYNAME"));
                return lstLawPenaltyDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWPENALTY)
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_lawid", lawid)
                .addValue("p_item", item)
                .addValue("p_point", point)
                .addValue("p_lawname", lawname)
                .addValue("p_groupid", groupid)
                .addValue("p_codeid", codeid);
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLawPenaltyDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(LstLawPenalty req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWPENALTY)
                .withFunctionName(Constant.FUNCTION.FN_INSERT_UPDATE)
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", req.getAction())
                .addValue("p_lawcode", req.getLawcode())
                .addValue("p_penaltyid", req.getPenaltyid())
                .addValue("p_fromamount", req.getFromamount())
                .addValue("p_toamount", req.getToamount());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String delete(LstLawPenalty req) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_LAWPENALTY) //package name
                .withFunctionName(Constant.FUNCTION.FN_DELETE)
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_lawcode", req.getLawcode())
                .addValue("p_penaltyid", req.getPenaltyid());
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
