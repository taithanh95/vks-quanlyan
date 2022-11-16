package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorAccusedRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MonitorAccusedRepositoryImpl implements MonitorAccusedRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MonitorEntity> monitorAccusedRepository_1(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_FOR_ACCUSED);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("psppid", req.getSppIdList())
                    .addValue("puserfor", req.getUsefor())
                    .addValue("pfdate", Utils.getSqlDate(req.getFdateAccused()))
                    .addValue("ptdate", Utils.getSqlDate(req.getTdateAccused()))
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_2(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_FOR_PROSECUTION);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class
                    , baseParam(req));
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_3(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_PARTY_ACCUSED);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_4(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_CATL_VKSKTL);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_5(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_ACCUSED_VKS_TA);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_6(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_FOR_CASE);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_7(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_ADOLESCENT_ACCUSED);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_8(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_IN_VKSTT_TAKTL);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAccusedRepository_11(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.FN_XXST);
            List<MonitorEntity> res = jdbcCall.executeFunction(
                    (Class<List<MonitorEntity>>) (Class) List.class,
                    baseParam(req)
            );
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    private SqlParameterSource baseParam(MonitorRequest req) {
        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_rowindex", req.getPageIndex())
                .addValue("p_pagesize", req.getPageSize())
                .addValue("p_sortcol", req.getSortField())
                .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                .addValue("psppid", req.getSppIdList())
                .addValue("pfdate", Utils.getSqlDate(req.getFdateAccused()))
                .addValue("ptdate", Utils.getSqlDate(req.getTdateAccused()))
                .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
        return param;
    }
}
