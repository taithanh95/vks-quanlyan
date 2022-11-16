package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorRepository;
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
 * Date: 04/07/2022
 * Time: 11:49 AM
 */
@Repository
public class MonitorRepositoryImpl implements MonitorRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<MonitorEntity> monitorRegister(MonitorRequest req) throws Exception {
        int temp = Integer.parseInt(req.getTyperegister());
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_REGISTER)
                    .withFunctionName(temp == 1 ? Constant.FUNCTION.FN_REGISTER_NEAR : Constant.FUNCTION.FN_REGISTER_OVER);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateRegister()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateRegister()))
                    .addValue("p_inspcode", req.getInspcode())
                    .addValue("p_usefor", req.getUsefor())
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_flagdate", Utils.getSqlDate(req.getFlagdate()))
                    .addValue("p_special", (req.getSpecial() != null && req.getSpecial() == true) ? "Y" : "N")
                    .addValue("p_lawyer", (req.getLawyer() != null && req.getLawyer() == true) ? "Y" : "N")
                    .addValue("p_movement", (req.getMovement() != null && req.getMovement() == true) ? "Y" : "N")
                    .addValue("p_flagnotify", null);
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<LstLawGroupChapDTO> getLstLawGroupChap() throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_GET_LAWGROUPCHAP_2022);
            List<LstLawGroupChapDTO> res = jdbcCall.executeFunction((Class<List<LstLawGroupChapDTO>>) (Class) List.class);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase1(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_SEARCH_DATE_SPPID);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_inclue", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase2(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_THULY_MOI_GAI_DOAN);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("p_idksv", req.getInspcode())
                    .addValue("p_include", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase3(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_XULY_THULY_MOI_GAI_DOAN);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("p_idksv", req.getInspcode())
                    .addValue("p_include", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase4(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.GET_RPT_COMP_INFO);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_fdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_tdate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_usefor", req.getUsefor())
                    .addValue("p_inspcode", req.getInspcode())
                    .addValue("p_underlever", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase5(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_THULY_MOI_FDATE_TDATE);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("p_casetype", req.getTypecase())
                    .addValue("p_idksv", req.getInspcode())
                    .addValue("p_include", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase6(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_THULY_MOI_DIEU_LUAT);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("p_lawcode", req.getLawcode())
                    .addValue("p_codeid", req.getCodeid())
                    .addValue("p_idksv", req.getInspcode())
                    .addValue("p_include", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase7(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.FN_THULY_NHOM_VU_AN);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortoder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_sdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_edate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_userfor", req.getUsefor())
                    .addValue("pGROUP", req.getGroupcase())
                    .addValue("p_idksv", req.getInspcode())
                    .addValue("p_include", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase8(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.GET_CATL_VKSKTL);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_fdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_tdate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_underlever", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorCase9(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_CASE)
                    .withFunctionName(Constant.FUNCTION.GET_VKSTL_TAKTL);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_fdate", Utils.getSqlDate(req.getRegfdate()))
                    .addValue("p_tdate", Utils.getSqlDate(req.getRegtdate()))
                    .addValue("p_underlever", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorLaw(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.GET_RPT_LAW);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdateLaw()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdateLaw()))
                    .addValue("p_userforlaw", req.getUsefor())
                    .addValue("p_lawid", req.getLawid())
                    .addValue("p_codeid", req.getCodeid())
                    .addValue("p_corrup", (req.getBooCorrup() != null && req.getBooCorrup() == true) ? "Y" : "N")
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorPenalty(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR)
                    .withFunctionName(Constant.FUNCTION.GET_RPT_PENALTY);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_fromdate", Utils.getSqlDate(req.getFdatePenalty()))
                    .addValue("p_todate", Utils.getSqlDate(req.getTdatePenalty()))
                    .addValue("p_useforpenalty", req.getUsefor())
                    .addValue("p_penaltyid", req.getPenaltyid())
                    .addValue("p_suspended", (req.getSuspended() != null && req.getSuspended() == true) ? "Y" : "N")
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAgainst(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_AGAINST)
                    .withFunctionName(Constant.FUNCTION.FN_MONITORAGAINST);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("psppid", req.getSppIdList())
                    .addValue("pfdate", Utils.getSqlDate(req.getFdateAgainsts()))
                    .addValue("ptdate", Utils.getSqlDate(req.getTdateAgainsts()))
                    .addValue("punderlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }

    @Override
    public List<MonitorEntity> monitorAppeal(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_MONITOR_APPEAL)
                    .withFunctionName(Constant.FUNCTION.FN_MONITORAPPEAL);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortcol", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("psppid", req.getSppIdList())
                    .addValue("pfdate", Utils.getSqlDate(req.getFdateAppeals()))
                    .addValue("ptdate", Utils.getSqlDate(req.getTdateAppeals()))
                    .addValue("punderlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "true" : "false");
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }
}
