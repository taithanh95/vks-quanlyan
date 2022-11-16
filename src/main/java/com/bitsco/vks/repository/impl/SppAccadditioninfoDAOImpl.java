package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppAccadditioninfo;
import com.bitsco.vks.repository.SppAccadditioninfoDAO;
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

@Repository
public class SppAccadditioninfoDAOImpl implements SppAccadditioninfoDAO {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public SppAccadditioninfo getByAccucode(String accucode) {
        SimpleJdbcCall jdbcCall;
        RowMapper<SppAccadditioninfo> rm = new SingleColumnRowMapper<SppAccadditioninfo>() {
            @Override
            public SppAccadditioninfo mapRow(ResultSet rs, int rowNum) throws SQLException {
                SppAccadditioninfo response = new SppAccadditioninfo();
                response.setId(rs.getLong("ID"));
                response.setAccucode(rs.getString("ACCUCODE"));
                response.setPreventiveMeasures(rs.getString("PREVENTIVE_MEASURES"));
                response.setPreventiveMeasuresId(rs.getString("PREVENTIVE_MEASURES_ID"));
                response.setDead("Y".equals(rs.getString("DEAD")) ? true : false);
                response.setDeadDay(rs.getDate("DEAD_DAY"));
                response.setCauseOfDeath(rs.getLong("CAUSE_OF_DEATH"));
                response.setFled("Y".equals(rs.getString("FLED")) ? true : false);
                response.setDayOfHiding(rs.getDate("DAY_OF_HIDING"));
                response.setReasonForHiding(rs.getString("REASON_FOR_HIDING"));
                response.setRecaptureDate(rs.getDate("RECAPTURE_DATE"));
                response.setMoveToOtherPlace("Y".equals(rs.getString("MOVE_TO_OTHER_PLACE")) ? true : false);
                response.setMoveOutdate(rs.getDate("MOVE_OUT_DATE"));
                response.setMovedToAnotherPlace("Y".equals(rs.getString("MOVED_TO_ANOTHER_PLACE")) ? true : false);
                response.setMoveInDate(rs.getDate("MOVE_IN_DATE"));
                response.setReason(rs.getString("REASON"));
                return response;
            }
        };
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_ACCADDITIONINFO")
                    .withFunctionName("fn_get_by_accucode")
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_accucode", accucode);

            //First parameter is function output parameter type.
            List<SppAccadditioninfo> lstSppAccadditioninfo = jdbcCall.executeFunction((Class<List<SppAccadditioninfo>>) (Class) List.class, paramMap);
            if (lstSppAccadditioninfo != null && lstSppAccadditioninfo.size() > 0)
                return lstSppAccadditioninfo.get(0);
            else
                return null;
        } catch (Exception e) {
            throw e;
        }
    }
}
