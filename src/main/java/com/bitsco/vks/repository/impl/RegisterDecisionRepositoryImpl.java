package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.RegisterDecisionListResponse;
import com.bitsco.vks.models.RegisterDecisionResponse;
import com.bitsco.vks.repository.RegisterDecisionRepository;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.utils.DateCommon;
import com.bitsco.vks.utils.JsonCommon;
import com.bitsco.vks.utils.StringCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class RegisterDecisionRepositoryImpl implements RegisterDecisionRepository {

    private static final SimpleDateFormat formatter = new SimpleDateFormat(Constant.DATE.FORMAT.DATE);
    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CONNECTION);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<RegisterDecisionListResponse> findAllByCaseCodeAndSppId(RegisterDecisionCaseRequest request) {
        String sql = "SELECT rd.id, rd.userfor, ld.deciid, ld.deciname, rd.setnum, rd.indate FROM register_decision rd" +
                " LEFT JOIN lst_decision ld ON rd.deciid = ld.deciid" +
                " WHERE rd.casecode = '" + request.getCaseCode() + "'" +
                " AND rd.status = 'Y'" +
                " AND rd.sppid = '" + request.getSppId() + "'" +
                " ORDER BY rd.id ASC";
        return jdbcTemplate.query(sql, new RegisterDecisionListMapper());
    }

    @Override
    public RegisterDecisionResponse findById(Long id) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionRepositoryImpl.findById request = " + JsonCommon.objectToJsonNotNull(id));
        try {
            String sql = "SELECT rd.id, rd.userfor, rd.indate, ld.deciid, ld.deciname, rd.setnum, rd.fromdate, rd.todate, rd.casecode, ls.sppid, ls.name as sppname FROM register_decision rd" +
                    " LEFT JOIN lst_decision ld ON rd.deciid = ld.deciid" +
                    " LEFT JOIN lst_spp ls ON rd.sppid = ls.sppid" +
                    " WHERE rd.id = " + id;
            return jdbcTemplate.queryForObject(sql, new RegisterDecisionMapper(id));
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionRepositoryImpl.findById", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionRepositoryImpl.findById");
        }
    }

    @Override
    public int deleteById(Long id, String mdfuser) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionRepositoryImpl.deleteById request = " + JsonCommon.objectToJsonNotNull(id));
        try {
            Date mdfdate = new Date();
            String sql = "UPDATE register_decision SET status = 'N', mdfuser = '" + mdfuser + "', mdfdate = TO_DATE('" + formatter.format(mdfdate) + "', 'dd/MM/yyyy') WHERE id = " + id;
            return jdbcTemplate.update(sql);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionRepositoryImpl.deleteById", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionRepositoryImpl.deleteById");
        }
    }

    @Override
    public List<RegisterDecisionListResponse> findAll(RegisterDecisionCaseRequest request) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionRepositoryImpl.findAll request = " + JsonCommon.objectToJsonNotNull(request.getDeciId()));
        SimpleJdbcCall jdbcCall;
        RowMapper<RegisterDecisionListResponse> rm = new SingleColumnRowMapper<RegisterDecisionListResponse>() {
            @Override
            public RegisterDecisionListResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                RegisterDecisionListResponse response = new RegisterDecisionListResponse();
                response.setId(rs.getLong("n_id"));
                response.setUserFor(rs.getString("s_giai_doan"));
                response.setSetNum(rs.getLong("n_so_quyet_dinh"));
                response.setDeciId(rs.getString("s_ma_qd"));
                response.setDeciName(rs.getString("s_ten_quyet_dinh"));
                response.setCaseCode(rs.getString("s_ma_vu_an"));
                response.setCaseName(rs.getString("s_ten_vu_an"));
                response.setFullName(rs.getString("s_bi_can_dau_vu")); // Bi can dau vu
                response.setInDate(rs.getDate("d_ngay_cap_so"));
                response.setFromDate(rs.getDate("d_hieu_luc_tu_ngay"));
                response.setToDate(rs.getDate("d_hieu_luc_den_ngay"));
                return response;
            }
        };
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_REGISTER_DECISION)
                    .withFunctionName(Constant.FUNCTION.GET_LIST_REGISTER_DECISION)
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("pi_from_date", DateCommon.convertDateToString(request.getFromDate()))
                    .addValue("pi_to_date", DateCommon.convertDateToString(request.getToDate()))
                    .addValue("pi_giai_doan", StringCommon.isNullOrBlank(request.getUserFor()) ? null : request.getUserFor().trim())
                    .addValue("pi_ma_quyet_dinh", StringCommon.isNullOrBlank(request.getDeciId()) ? null : request.getDeciId().trim())
                    .addValue("pi_ma_vu_an", StringCommon.isNullOrBlank(request.getCaseCode()) ? null : request.getCaseCode().trim())
                    .addValue("pi_ten_vu_an", request.getCaseName());
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<RegisterDecisionListResponse>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionRepositoryImpl.findAll", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionRepositoryImpl.findAll");
        }

    }

    private static class RegisterDecisionMapper implements RowMapper<RegisterDecisionResponse> {
        private final Long id;

        public RegisterDecisionMapper(Long id) {
            this.id = id;
        }

        @Override
        public RegisterDecisionResponse mapRow(ResultSet rs, int i) throws SQLException {
            RegisterDecisionResponse registerDecisionResponse = new RegisterDecisionResponse();
            registerDecisionResponse.setId(this.id);
            registerDecisionResponse.setUserFor(rs.getString("userfor"));
            registerDecisionResponse.setInDate(rs.getDate("indate"));
            registerDecisionResponse.setDeciId(rs.getString("deciid"));
            registerDecisionResponse.setDeciName(rs.getString("deciname"));
            registerDecisionResponse.setSetNum(rs.getInt("setnum"));
            registerDecisionResponse.setFromDate(rs.getDate("fromdate"));
            registerDecisionResponse.setToDate(rs.getDate("todate"));
            registerDecisionResponse.setCaseCode(rs.getString("casecode"));
            registerDecisionResponse.setSppId(rs.getString("sppid"));
            registerDecisionResponse.setSppName(rs.getString("sppname"));
            return registerDecisionResponse;
        }
    }

    private static class RegisterDecisionListMapper implements RowMapper<RegisterDecisionListResponse> {
        @Override
        public RegisterDecisionListResponse mapRow(ResultSet rs, int i) throws SQLException {
            RegisterDecisionListResponse registerDecisionListResponse = new RegisterDecisionListResponse();
            registerDecisionListResponse.setId(rs.getLong("id"));
            registerDecisionListResponse.setUserFor(rs.getString("userfor"));
            registerDecisionListResponse.setDeciId(rs.getString("deciid"));
            registerDecisionListResponse.setDeciName(rs.getString("deciname"));
            registerDecisionListResponse.setSetNum(rs.getLong("setnum"));
            registerDecisionListResponse.setInDate(rs.getDate("indate"));
            return registerDecisionListResponse;
        }
    }
}
