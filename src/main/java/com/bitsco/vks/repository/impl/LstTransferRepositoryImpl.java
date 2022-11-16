package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstTransferSearchDTO;
import com.bitsco.vks.models.LstTransferRequest;
import com.bitsco.vks.repository.LstTransferRepository;
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
public class LstTransferRepositoryImpl implements LstTransferRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LstTransferSearchDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String transid, String transname) {
        SimpleJdbcCall jdbcCall;
        RowMapper<LstTransferSearchDTO> rm = new SingleColumnRowMapper<LstTransferSearchDTO>() {
            @Override
            public LstTransferSearchDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
                LstTransferSearchDTO lstTransferSearchDTO = new LstTransferSearchDTO();
                lstTransferSearchDTO.setRowcount(rs.getLong("ROWCOUNT"));
                lstTransferSearchDTO.setRnum(rs.getInt("RNUM"));

                lstTransferSearchDTO.setTransid(rs.getString("TRANSID"));
                lstTransferSearchDTO.setTransname(rs.getString("TRANSNAME"));
                lstTransferSearchDTO.setFromto(rs.getString("FROMTO"));
                lstTransferSearchDTO.setCrtdate(rs.getString("CRTDATE"));
                lstTransferSearchDTO.setCrtuser(rs.getString("CRTUSER"));
                lstTransferSearchDTO.setMdfdate(rs.getString("MDFDATE"));
                lstTransferSearchDTO.setMdfuser(rs.getString("MDFUSER"));
                return lstTransferSearchDTO;
            }
        };
        jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName(Constant.PACKAGE.PKG_LST_TRANSFER) //package name
                .withFunctionName(Constant.FUNCTION.FN_SEARCH)
                .returningResultSet("return", rm);
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex * pageSize)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", !Strings.isNullOrEmpty(sortOrder) ? sortOrder.toUpperCase() : null)
                .addValue("p_transid", transid)
                .addValue("p_transname", transname);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstTransferSearchDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String save(String action, String transid, String transname, String fromto, String username) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_TRANSFER) //package name
                    .withFunctionName("I".equalsIgnoreCase(action) ? Constant.FUNCTION.FN_INSERT
                            : Constant.FUNCTION.FN_UPDATE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_transid", transid)
                    .addValue("p_transname", transname)
                    .addValue("p_fromto", fromto)
                    .addValue("p_crtuser", username);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

    @Override
    public String delete(String transid) {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_LST_TRANSFER) //package name
                    .withFunctionName(Constant.FUNCTION.FN_DELETE);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_transid", transid);

            //First parameter is function output parameter type.
            Map _res = jdbcCall.execute(paramMap);
            return (String) _res.get("return");
        } catch (Exception e) {
            throw(e);
        }
    }

}
