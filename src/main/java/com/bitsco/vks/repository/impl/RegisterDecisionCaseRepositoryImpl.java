package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.RegisterDecisionCaseListResponse;
import com.bitsco.vks.models.RegisterDecisionCaseSearchRequest;
import com.bitsco.vks.repository.RegisterDecisionCaseRepository;
import com.bitsco.vks.request.RegisterDecisionCaseRequest;
import com.bitsco.vks.request.RegisterDecisionCaseSeqRequest;
import com.bitsco.vks.request.SppRequest;
import com.bitsco.vks.utils.JsonCommon;
import com.bitsco.vks.validate.ValidateCommon;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RegisterDecisionCaseRepositoryImpl implements RegisterDecisionCaseRepository {

    private static final Logger LOGGER = LogManager.getLogger(Constant.LOG_APPENDER.CONNECTION);
    private final DateFormat dateFormat = new SimpleDateFormat(Constant.DATE.FORMAT.DATE);

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public long count(RegisterDecisionCaseSearchRequest request) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.count request = " + JsonCommon.objectToJsonNotNull(request.getCaseCode()));
        try {
            StringBuilder sql = new StringBuilder("SELECT COUNT(sc.casecode) FROM spp_case sc");
            sql.append(" LEFT JOIN spp_register sr ON sc.casecode = sr.casecode");
            sql.append(" LEFT JOIN spp_accused sa ON sc.firstacc = sa.accucode");
            sql.append(" WHERE sr.userfor IN ('G1', 'G2') AND sr.finishdate IS NULL");
            if (request.getSppId() != null) {
                sql.append(" AND sc.sppid = '").append(request.getSppId()).append("'");
            }
            if (request.getCaseCode() != null && !request.getCaseCode().equals("")) {
                sql.append(" AND sc.casecode LIKE '%").append(request.getCaseCode()).append("%'");
            }
            if (request.getCaseName() != null && !request.getCaseName().equals("")) {
                sql.append(" AND sc.casename LIKE '%").append(request.getCaseName()).append("%'");
            }
            if (request.getFullName() != null && !request.getFullName().equals("")) {
                sql.append(" AND sa.fullname LIKE '%").append(request.getFullName()).append("%'");
            }
            if (request.getStartValue() != null) {
                sql.append(" AND sc.begin_indate >= TO_DATE('").append(dateFormat.format(request.getStartValue())).append("', 'dd/MM/yyyy')");
            }
            if (request.getEndValue() != null) {
                sql.append(" AND sc.begin_indate < TO_DATE('").append(dateFormat.format(request.getEndValue())).append("', 'dd/MM/yyyy')+1");
            }
            return jdbcTemplate.queryForObject(sql.toString(), Long.class);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.count", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.count");
        }
    }

    @Override
    public List<Map<String, Object>> findDeciIdAndDeciNameByDeciName(String query) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.findDeciIdAndDeciNameByDeciName request = " + JsonCommon.objectToJsonNotNull(query));
        try {
            String sql = "SELECT deciid, deciname FROM lst_decision WHERE deciname LIKE '%" + query + "%'" +
                    " AND applyfor = 'C'";
            return jdbcTemplate.queryForList(sql);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.findDeciIdAndDeciNameByDeciName", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.findDeciIdAndDeciNameByDeciName");
        }
    }

    @Override
    public int saveOrUpdate(RegisterDecisionCaseRequest request) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.save request = " + JsonCommon.objectToJsonNotNull(request.getCaseCode()));
        try {
            if (request.getId() == null) {
                return jdbcTemplate.update("INSERT INTO register_decision (USERFOR, INDATE, DECIID, SETNUM, FROMDATE, TODATE, SPPID, APPLYFOR, CASECODE)" + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", request.getUserFor(), request.getInDate(),
                        request.getDeciId(), request.getSetNumReality(), request.getFromDate(), request.getToDate(), request.getSppId(), "C", request.getCaseCode());
            } else {
                return jdbcTemplate.update("UPDATE register_decision SET USERFOR = ?, INDATE = ?, DECIID = ?, SETNUM = ?, FROMDATE = ?, TODATE = ?, SPPID = ?, APPLYFOR = ?, CASECODE = ? WHERE ID = ?", request.getUserFor(), request.getInDate(),
                        request.getDeciId(), request.getSetNumReality(), request.getFromDate(), request.getToDate(), request.getSppId(), "C", request.getCaseCode(), request.getId());
            }
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.save", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.save");
        }
    }

    @Override
    public int insertOrUpdateSeq(RegisterDecisionCaseRequest request) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.insertOrUpdateSeq request = " + JsonCommon.objectToJsonNotNull(request.getCaseCode()));
        try {
            RegisterDecisionCaseSeqRequest registerDecisionCaseSeqRequest = new RegisterDecisionCaseSeqRequest();
            registerDecisionCaseSeqRequest.setDeciId(request.getDeciId());
            registerDecisionCaseSeqRequest.setCaseCode(request.getCaseCode());
            registerDecisionCaseSeqRequest.setSppId(request.getSppId());
            registerDecisionCaseSeqRequest.setLastUpdate(request.getInDate());
            StringBuilder query = new StringBuilder();
            if (this.isRegisterDecisionExists(registerDecisionCaseSeqRequest)) {
                // Check if exists seq
                query.append("UPDATE register_decision_seq SET SEQ_NUMBER = SEQ_NUMBER + 1");
                query.append(" WHERE DECIID = '").append(registerDecisionCaseSeqRequest.getDeciId()).append("'");
                query.append(" AND SPPID = '").append(registerDecisionCaseSeqRequest.getSppId()).append("'");
                query.append(" AND CASECODE = '").append(registerDecisionCaseSeqRequest.getCaseCode()).append("'");
                query.append(" AND LAST_UPDATE >= TO_DATE('").append(dateFormat.format(registerDecisionCaseSeqRequest.getFirstYear())).append("', 'dd/MM/yyyy')");
                query.append(" AND LAST_UPDATE <= TO_DATE('").append(dateFormat.format(registerDecisionCaseSeqRequest.getLastYear())).append("', 'dd/MM/yyyy')");
                return jdbcTemplate.update(query.toString());
            }
            query.append("INSERT INTO register_decision_seq (DECIID, SPPID, CASECODE, SEQ_NUMBER)");
            query.append(" VALUES (?, ?, ?, ?)");
            return jdbcTemplate.update(query.toString(), request.getDeciId(), request.getSppId(), request.getCaseCode(), 2);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.insertOrUpdateSeq", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.insertOrUpdateSeq");
        }
    }

    @Override
    public boolean checkStatusRegister(RegisterDecisionCaseRequest request) {
        String sql = "SELECT count(*) FROM spp_register WHERE casecode = '" + request.getCaseCode() + "' AND USERFOR = '" + request.getUserFor() + "' AND finishdate IS NOT NULL";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count > 0;
    }

    @Override
    public int getSequenceNumber(RegisterDecisionCaseSeqRequest request) throws Exception {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.getSequenceNumber request = " + JsonCommon.objectToJsonNotNull(request.getCaseCode()));
        try {
            String sql = "SELECT SEQ_NUMBER FROM REGISTER_DECISION_SEQ" + " WHERE DECIID = '" + request.getDeciId() + "'" +
                    " AND SPPID = '" + request.getSppId() + "'" +
                    " AND CASECODE = '" + request.getCaseCode() + "'" +
                    " AND LAST_UPDATE >= TO_DATE('" + dateFormat.format(request.getFirstYear()) + "', 'dd/MM/yyyy')" +
                    " AND LAST_UPDATE <= TO_DATE('" + dateFormat.format(request.getLastYear()) + "', 'dd/MM/yyyy')";
            return jdbcTemplate.queryForObject(sql, Integer.class);
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.getSequenceNumber", e);
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.getSequenceNumber");
        }
        return 1;
    }

    private boolean isRegisterDecisionExists(RegisterDecisionCaseSeqRequest request) throws Exception {
        String sql = "SELECT count(*) FROM REGISTER_DECISION_SEQ" + " WHERE DECIID = '" + request.getDeciId() + "'" +
                " AND SPPID = '" + request.getSppId() + "'" +
                " AND CASECODE = '" + request.getCaseCode() + "'" +
                " AND LAST_UPDATE >= TO_DATE('" + dateFormat.format(request.getFirstYear()) + "', 'dd/MM/yyyy')" +
                " AND LAST_UPDATE <= TO_DATE('" + dateFormat.format(request.getLastYear()) + "', 'dd/MM/yyyy')";
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count > 0;
    }

    @Override
    public boolean existsRegisterDecisionByCaseCodeAndSppIdAndDeciIdAndInDate(RegisterDecisionCaseRequest request) throws Exception {
        String sql = "SELECT count(*) FROM REGISTER_DECISION" + " WHERE DECIID = '" + request.getDeciId() + "'" +
                " AND SPPID = '" + request.getSppId() + "'" +
                " AND CASECODE = '" + request.getCaseCode() + "'" +
                " AND INDATE >= TO_DATE('" + dateFormat.format(request.getInDate()) + "', 'dd/MM/yyyy')" +
                " AND INDATE < TO_DATE('" + dateFormat.format(request.getInDate()) + "', 'dd/MM/yyyy')+1";
        
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count > 0;
    }

    @Override
    public boolean existsBySetNumAndSppIdAndCaseCodeAndInDate(RegisterDecisionCaseRequest request) throws Exception {
        String sql;
        if (request.getId() == null) {
            // Nếu request là thêm mới cấp lệnh/ quyết định
            sql = "SELECT count(*) FROM REGISTER_DECISION" + " WHERE DECIID = '" + request.getDeciId() + "'" +
                    " AND SPPID = '" + request.getSppId() + "'" +
                    " AND CASECODE = '" + request.getCaseCode() + "'" +
                    " AND SETNUM = '" + request.getSetNum() + "'" +
                    " AND INDATE >= TO_DATE('" + dateFormat.format(request.getFirstDayOfYear()) + "', 'dd/MM/yyyy')" +
                    " AND INDATE < TO_DATE('" + dateFormat.format(request.getLastDayOfYear()) + "', 'dd/MM/yyyy')";
        } else {
            // Nếu request là cập nhật cấp lệnh/ quyết định
            sql = "SELECT count(*) FROM REGISTER_DECISION" + " WHERE DECIID = '" + request.getDeciId() + "'" +
                    " AND SPPID = '" + request.getSppId() + "'" +
                    " AND CASECODE = '" + request.getCaseCode() + "'" +
                    " AND SETNUM = '" + request.getSetNum() + "'" +
                    " AND INDATE >= TO_DATE('" + dateFormat.format(request.getFirstDayOfYear()) + "', 'dd/MM/yyyy')" +
                    " AND INDATE < TO_DATE('" + dateFormat.format(request.getLastDayOfYear()) + "', 'dd/MM/yyyy')" +
                    " AND ID NOT IN ('" + request.getId() + "')";
        }
        
        int count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count > 0;
    }

    @Override
    public Map<String, Object> getLstSpp(SppRequest lstSpp) {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[B][" + startTime + "] RegisterDecisionCaseRepositoryImpl.getSppId request = " + JsonCommon.objectToJsonNotNull(lstSpp.getSppId()));
        try {
            String sql;
            if (lstSpp.isIsdepart()) {
                sql = "SELECT sppid, name FROM lst_spp WHERE sppid = (SELECT sppparent FROM lst_spp WHERE isdepart = 'Y' and sppid = '" + lstSpp.getSppId() + "')";
            } else {
                sql = "SELECT sppid, name FROM lst_spp WHERE sppid = '" + lstSpp.getSppId() + "'";
            }
            return jdbcTemplate.query(sql, (ResultSet rs) -> {
                HashMap<String, Object> results = new HashMap<>();
                while (rs.next()) {
                    results.put("sppid", rs.getString("sppid"));
                    results.put("name", rs.getString("name"));
                }
                return results;
            });
        } catch (Exception e) {
            LOGGER.error("[Exception][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] khi truy vấn dữ liệu RegisterDecisionCaseRepositoryImpl.getSppId", e);
            throw e;
        } finally {
            LOGGER.info("[E][" + startTime + "][Duration = " + (System.currentTimeMillis() - startTime) + "] RegisterDecisionCaseRepositoryImpl.getSppId");
        }
    }

    @Override
    public List<RegisterDecisionCaseListResponse> findAll(RegisterDecisionCaseSearchRequest request) {
        String sortField = (request.getSortField() != null) ? request.getSortField() : "casecode";
        String sortOrder = (request.getSortField() != null && request.getSortOrder().equals("ascend")) ? "asc" : "desc";

        StringBuilder sql = new StringBuilder("SELECT sc.casecode, sc.casename, sa.fullname, ll.lawid, ll.lawname, sc.begin_setnum, sc.begin_indate FROM spp_case sc");
        sql.append(" LEFT JOIN lst_law ll ON sc.lawcode = ll.lawcode");
        sql.append(" LEFT JOIN spp_accused sa ON sc.firstacc = sa.accucode");
        sql.append(" LEFT JOIN spp_register sr ON sc.casecode = sr.casecode");
        sql.append(" WHERE sr.userfor IN ('G1', 'G2') AND sr.finishdate IS NULL");
        if (request.getSppId() != null) {
            sql.append(" AND sc.sppid = '").append(request.getSppId()).append("'");
        }
        if (request.getCaseCode() != null && !request.getCaseCode().equals("")) {
            sql.append(" AND sc.casecode LIKE '%").append(request.getCaseCode()).append("%'");
        }
        if (request.getCaseName() != null && !request.getCaseName().equals("")) {
            sql.append(" AND sc.casename LIKE '%").append(request.getCaseName()).append("%'");
        }
        if (request.getFullName() != null && !request.getFullName().equals("")) {
            sql.append(" AND sa.fullname LIKE '%").append(request.getFullName()).append("%'");
        }
        if (request.getStartValue() != null) {
            sql.append(" AND sc.begin_indate >= TO_DATE('").append(dateFormat.format(request.getStartValue())).append("', 'dd/mm/yyyy')");
        }
        if (request.getEndValue() != null) {
            sql.append(" AND sc.begin_indate < TO_DATE('").append(dateFormat.format(request.getEndValue())).append("', 'dd/mm/yyyy')+1");
        }
        sql.append(" ORDER BY ").append(sortField).append(" ").append(sortOrder);
        sql.append(" OFFSET ").append((request.getPageIndex() - 1) * request.getPageSize());
        sql.append(" ROWS FETCH NEXT ").append(request.getPageSize()).append(" ROWS ONLY");
        return jdbcTemplate.query(sql.toString(), new RegisterDecisionCaseMapper());
    }

    @Override
    public RegisterDecisionCaseListResponse findByCaseCode(String caseCode) {
        StringBuilder sql = new StringBuilder("SELECT sc.casecode, sc.casename, sa.fullname, sc.lawid, ll.lawname, sc.begin_setnum, sc.begin_indate FROM spp_case sc");
        sql.append(" LEFT JOIN lst_law ll ON sc.lawcode = ll.lawcode");
        sql.append(" LEFT JOIN spp_accused sa ON sc.firstacc = sa.accucode");
        sql.append(" WHERE sc.casecode = '").append(caseCode).append("'");
        return jdbcTemplate.queryForObject(sql.toString(), new RegisterDecisionCaseMapper());
    }

    private static class RegisterDecisionCaseMapper implements RowMapper<RegisterDecisionCaseListResponse> {
        @Override
        public RegisterDecisionCaseListResponse mapRow(ResultSet rs, int i) throws SQLException {
            RegisterDecisionCaseListResponse registerDecisionCaseListResponse = new RegisterDecisionCaseListResponse();
            registerDecisionCaseListResponse.setCaseCode(rs.getString("casecode"));
            registerDecisionCaseListResponse.setCaseName(rs.getString("casename"));
            registerDecisionCaseListResponse.setFullName(rs.getString("fullname"));
            registerDecisionCaseListResponse.setLawId(rs.getString("lawid"));
            registerDecisionCaseListResponse.setLawName(rs.getString("lawname"));
            registerDecisionCaseListResponse.setBeginIndate(rs.getDate("begin_indate"));
            registerDecisionCaseListResponse.setBeginSetnum(rs.getString("begin_setnum"));
            return registerDecisionCaseListResponse;
        }
    }

}
