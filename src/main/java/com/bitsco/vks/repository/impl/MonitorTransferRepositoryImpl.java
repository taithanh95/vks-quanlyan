package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorTransferRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MonitorTransferRepositoryImpl implements MonitorTransferRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    //Cơ quan điều tra <-> Viện kiểm sát
    @Override
    public List<MonitorEntity> monitorTransferRepository_cqdt_vks(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_TRANSFER_VKS_CQDT);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateTransfer()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateTransfer()))
                    .addValue("p_type", req.getType());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }
    //Viện kiểm sát <-> Viện kiểm sát
    @Override
    public List<MonitorEntity> monitorTransferRepository_vks_vks(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_TRANSFER_VKS_VKS);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateTransfer()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateTransfer()))
                    .addValue("p_sppidf", req.getSppidfTransfer())
                    .addValue("p_sppidt", req.getSppidtTransfer());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }         }
    //Viện kiểm sát <-> Tòa án
    @Override
    public List<MonitorEntity> monitorTransferRepository_vks_ta(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_TRANSFER_VKS_TA);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateTransfer()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateTransfer()))
                    .addValue("p_type", req.getType());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }
}
