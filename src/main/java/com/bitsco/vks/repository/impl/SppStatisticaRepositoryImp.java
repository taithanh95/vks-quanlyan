package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.SppStatisticaDTO;
import com.bitsco.vks.entity.SppStaticcBegin;
import com.bitsco.vks.models.SppStattisticaSaveRequest;
import com.bitsco.vks.repository.SppCenLawRepository;
import com.bitsco.vks.repository.SppStatisticaRepository;
import com.bitsco.vks.utils.ArrayListCommon;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SppStatisticaRepositoryImp implements SppStatisticaRepository {

    @Autowired
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public SppCenLawRepository sppCenLawRepository;

    @Override
    public List<SppStatisticaDTO> search(String regicode, String centcode, String accucode, String lawcode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_STATTISTICA") //package name
                .withFunctionName("FN_SEARCH_FROM_LAWCODE_UDINF");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_USERFOR", userfor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppStatisticaDTO>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdateInfo(SppStattisticaSaveRequest req, String userid) {
        String _res = sppCenLawRepository.updateStatica(req);
        if (!Utils.StringIsNullOrEmpty(_res))
            return _res;
        _res = deleteStattis(req.getRegicode(), req.getCentcode(), req.getLawcode(), req.getAccucode(), req.getUserfor());
        if (!Utils.StringIsNullOrEmpty(_res))
            return _res;

        if (!ArrayListCommon.isNullOrEmpty(req.getListStatistics())) {
            _res = insertStattis(req.getRegicode(), req.getCentcode(), req.getLawcode(), req.getAccucode(), req.getUserfor(),
                    userid, req.getListStatistics());
            if (!Utils.StringIsNullOrEmpty(_res))
                return _res;
        }
        return _res;
    }

    private String deleteStattis(String regicode, String centcode, String lawcode, String accucode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_STATTISTICA") //package name
                .withFunctionName("FN_DELETE_UDINF")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                .addValue("P_ACCUCODE", accucode)
                .addValue("P_USERFOR", userfor);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    private String insertStattis(String regicode, String centcode, String lawcode, String accucode, String userfor,
                                 String userid, List<String> lstStatistics) {
        String _result = null;
        for (String _obj : lstStatistics) {
            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_STATTISTICA") //package name
                    .withFunctionName("FN_INSERT_UDINF")
                    .withReturnValue();
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("P_REGICODE", regicode)
                    .addValue("P_CENTCODE", centcode)
                    .addValue("P_LAWCODE", lawcode)
                    .addValue("P_ACCUCODE", accucode)
                    .addValue("P_STATID", _obj)
                    .addValue("P_USERFOR", userfor)
                    .addValue("P_CRTUSER", userid);
            Map results = jdbcCall.execute(paramMap);
            _result = (String) results.get("return");
            if (!Utils.StringIsNullOrEmpty(_result))
                return _result;
        }
        return _result;
    }

    @Override
    public String  insertCaseStatis(String regicode, String centcode, String lawcode, List<SppStaticcBegin> lstStaticcBegin, String userfor, String userid) {
        SimpleJdbcCall jdbcCall;
        String _result = null;
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_STATISTICC") //package name
                    .withFunctionName("FN_INSERT_UPDATE_UDINF")
                    .withReturnValue();
            for (SppStaticcBegin staticc : lstStaticcBegin) {
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("P_REGICODE", regicode)
                        .addValue("P_CENTCODE", centcode)
                        .addValue("P_LAWCODE", lawcode)
                        .addValue("P_STATID", staticc.getStatid())
                        .addValue("P_AMOUNT", staticc.getAmount())
                        .addValue("P_USERFOR", userfor)
                        .addValue("P_CRTUSER", userid);
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
                if (!Utils.StringIsNullOrEmpty(_result)) {
                    break;
                }
            }
            if (Utils.StringIsNullOrEmpty(_result)) {
                jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("PKG_SPP_STATISTICC") //package name
                        .withFunctionName("FN_CHECKWARING_AFTERINSERT")
                        .withReturnValue();
                SqlParameterSource paramMap = new MapSqlParameterSource()
                        .addValue("P_REGICODE", regicode)
                        .addValue("P_CENTCODE", centcode)
                        .addValue("P_LAWCODE", lawcode)
                        .addValue("P_USERFOR", userfor);
                Map results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
            return _result;
        } catch (Exception e) {
            throw e;
        }
    }


    @Override
    public List<SppStatisticaDTO> searchStaticcLawcodeUpdateInfo(String regicode, String centcode, String lawcode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_STATISTICC") //package name
                .withFunctionName("FN_SEARCH_FROM_LAWCODE_UPINF");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_CENTCODE", centcode)
                .addValue("P_LAWCODE", lawcode)
                .addValue("P_USERFOR", userfor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppStatisticaDTO>>) (Class) List.class, paramMap);
    }
}
