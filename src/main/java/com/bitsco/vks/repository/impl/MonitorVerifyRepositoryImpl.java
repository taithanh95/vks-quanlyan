package com.bitsco.vks.repository.impl;

import com.bitsco.vks.constant.Constant;
import com.bitsco.vks.entity.MonitorEntity;
import com.bitsco.vks.models.MonitorRequest;
import com.bitsco.vks.repository.MonitorVerifyRepository;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class MonitorVerifyRepositoryImpl implements MonitorVerifyRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;
    @Override
    public List<MonitorEntity> getList(MonitorRequest req) throws Exception {
        try {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName(Constant.PACKAGE.PKG_DATAVERIFY)
                    .withFunctionName(Constant.FUNCTION.DATA_VERIFY);

            SqlParameterSource param = new MapSqlParameterSource()
                    .addValue("p_rowindex", req.getPageIndex())
                    .addValue("p_pagesize", req.getPageSize())
                    .addValue("p_sortfield", req.getSortField())
                    .addValue("p_sortorder", req.getSortOrder().equals("ASC") ? "ASC" : "DESC")
                    .addValue("p_verifyid", req.getVerifyId())
                    .addValue("p_sppid", req.getSppIdList())
                    .addValue("p_underlevel", (req.getUnderlevel() != null && req.getUnderlevel() == true) ? "Y" : "N")
                    .addValue("p_begin_indatef", Utils.getSqlDate(req.getFdateVerify()))
                    .addValue("p_begin_indatet", Utils.getSqlDate(req.getTdateVerify()));
            List<MonitorEntity> res = jdbcCall.executeFunction((Class<List<MonitorEntity>>) (Class) List.class, param);
            return res;
        } catch (Exception e) {
            throw (e);
        }
    }


}
