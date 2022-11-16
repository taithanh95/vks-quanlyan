package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorDecisonRepository;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/07/2022
 * Time: 10:30 AM
 */
@Repository
public class MonitorDecisonRepositoryImpl implements MonitorDecisonRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MonitorEntity> monitorDecison1(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DECI_2022);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateDecision()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateDecision()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("p_reasonid", StringCommon.isNullOrBlank(req.getReasonid()) ? null : req.getReasonid())
                    .addValue("p_deciid", req.getDeciid());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorDecison2(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DECI_OVER);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateDecision()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateDecision()))
                    .addValue("p_utildate", Utils.getSqlDate(req.getUtildate()))
                    .addValue("p_userfor", req.getUsefor());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorDecison3(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DECI_NEAR);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateDecision()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateDecision()))
                    .addValue("p_utildate", Utils.getSqlDate(req.getUtildate()))
                    .addValue("p_userfor", req.getUsefor());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorDecison4(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DECI_NEAR_TAMGIAM);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateDecision()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateDecision()))
                    .addValue("p_utildate", Utils.getSqlDate(req.getUtildate()))
                    .addValue("p_userfor", req.getUsefor());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorDecison5(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_NEW)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DECI_OVER_TAMGIAM);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateDecision()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateDecision()))
                    .addValue("p_utildate", Utils.getSqlDate(req.getUtildate()))
                    .addValue("p_userfor", req.getUsefor());
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }
}
