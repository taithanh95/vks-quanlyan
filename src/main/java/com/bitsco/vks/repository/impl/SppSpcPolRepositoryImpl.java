package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.SppSpcPol;
import com.bitsco.vks.repository.SppSpcPolRepository;
import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;
import java.util.Map;

@Repository
public class SppSpcPolRepositoryImpl implements SppSpcPolRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<LinkedCaseInsensitiveMap> searchUpdateInfo(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String casecode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPCPOL") //package name
                .withFunctionName("FN_SEARCHUPDATEINFO");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ROWINDEX", rowIndex)
                .addValue("P_PAGESIZE", pageSize)
                .addValue("P_SORTFIELD", sortField)
                .addValue("P_SORTORDER", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("P_REGICODE", regicode)
                .addValue("P_CASECODE", casecode)
                .addValue("P_USERFOR", userfor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public String insertUpdate(String action, SppSpcPol ppl, String regicode, String casecode, String userid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPPSPCPOL") //package name
                .withFunctionName("FN_INSERT_UPDATE_DELETE")
                .withReturnValue();

        String policeid =                             ppl.getAtxPol() != null ? ppl.getAtxPol().getPoliceid() : ppl.getAtxArmy() != null ? ppl.getAtxArmy().getArmyid() :
                ppl.getAtxRanger() != null ?
                        ppl.getAtxRanger().getRangid() :
                        ppl.getAtxBorderGuards() !=
                                null ?
                                ppl.getAtxBorderGuards().getBorguaid() :
                                ppl.getAtxCustoms() != null ?
                                        ppl.getAtxCustoms().getCustomid() :
                                        null;
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ACTION", action)
                .addValue("P_CHANGEID", ppl.getChangeid())
                .addValue("P_USERFOR", ppl.getUserfor())
                .addValue("P_TRANSCODE", ppl.getTranscode())
                .addValue("P_REGICODE", action.equals(Constants.DML_INSERT) ? regicode : ppl.getRegicode())
                .addValue("P_CASECODE", casecode)
                .addValue("P_TRANSDATE", ppl.getTransdate() != null ? Utils.getSqlDate(ppl.getTransdate()) : null)
                .addValue("P_SPPID", ppl.getAtxSpp() != null ? ppl.getAtxSpp().getSppid() : null)
                .addValue("P_SPCID", ppl.getAtxSpc() != null ? ppl.getAtxSpc().getSpcid() : null)
                .addValue("P_POLID", ppl.getPolid())
                .addValue("P_POLICEID", policeid)
                .addValue("P_SENDER", ppl.getSender())
                .addValue("P_RECEIPTER", ppl.getReceipter())
                .addValue("P_REMARK", ppl.getRemark())
                .addValue("P_USERNAME", userid)
                .addValue("P_STATUS",                             ppl.getLststatus() != null && ppl.getLststatus().length > 0 ? (ppl.getChangeid().equals("01") ||
                        ppl.getChangeid().equals("04")) ?
                        ppl.getLststatus()[0] : "N" :
                        "")
                .addValue("P_STATUSTYPE",                             ppl.getLststatus() != null && ppl.getLststatus().length > 0 && (ppl.getLststatus()[0]).equals("T") &&
                        (ppl.getChangeid().equals("01") || ppl.getChangeid().equals("04")) ? ppl.getStatustype() :
                        "")
                .addValue("P_EVIDENCE",ppl.getEvidence())
                .addValue("P_NUM_OF_PEN",ppl.getNum_of_pen())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }
}
