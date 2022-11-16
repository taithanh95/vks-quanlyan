package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppCentAccu;
import com.bitsco.vks.entity.SppCentence;
import com.bitsco.vks.entity.SppDecision;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.repository.SppCentenceRepository;
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
public class SppCentenceRepositoryImpl implements SppCentenceRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private LstSignerRepository lstSignerRepository;

    @Override
    public List<SppCentence> searchupdateinfo(int rowIndex, int pageSize, String sortField, String sortOrder,
                                              String regicode, String userfor, String sppid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("fn_search_updateinfo");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ROWINDEX", rowIndex)
                .addValue("P_PAGESIZE", pageSize)
                .addValue("P_SORTFIELD", sortField)
                .addValue("P_SORTODER", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("P_REGICODE", regicode)
                .addValue("P_USERFOR", userfor)
                .addValue("P_SPPID", sppid)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppCentence>>)(Class)List.class, paramMap);
    }

    @Override
    public List<SppCentence> searchcase(int rowIndex, int pageSize, String sortField, String sortOrder,
                                        String casecode, String userfor, String sppid){
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("fn_searchcase");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_ROWINDEX", rowIndex)
                .addValue("P_PAGESIZE", pageSize)
                .addValue("P_SORTFIELD", sortField)
                .addValue("P_SORTODER", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("P_CASECODE", casecode)
                .addValue("P_USERFOR", userfor)
                .addValue("P_SPPID", sppid)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppCentence>>)(Class)List.class, paramMap);
    }

    @Override
    public InsertUpdateCentenceDTO insertUpdateUpdateInfo(String action, String regicode, SppCentence centence,
                                                          String userfor, String userId, String sppId){

        InsertUpdateCentenceDTO ret = new InsertUpdateCentenceDTO();
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("FN_INSERT_UPDATE_DELETE_TB2")
                .withReturnValue();


        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("pCENTCODE", centence.getCentcode())
                .addValue("pREGICODE", regicode)
                .addValue("pSETNUM", centence.getSetnum())
                .addValue("pTRIALDATE", centence.getTrialdate() == null ? null : Utils.getSqlDate(centence.getTrialdate()))
                .addValue("pINDATE", centence.getIndate() == null ? null : Utils.getSqlDate(centence.getIndate()))
                .addValue("pACTDATE", centence.getActdate() == null ? null : Utils.getSqlDate(centence.getActdate()))
                .addValue("pCONTENT", centence.getContent())
                .addValue("pSIGNNAME", centence.getSignname())
                .addValue("pSIGNOFFICE", centence.getSignoffice())
                .addValue("pREMARK", centence.getRemark())
                .addValue("pCONCID",  centence.getConcid())
                .addValue("pCONCIDSPP", centence.getConcidspp())
                .addValue("pCRTUSER", userId)
                .addValue("pMDFUSER", userId)
                .addValue("pSPPID", sppId)
                .addValue("poption", action)
                .addValue("pMOVEMENT", Utils.StringIsNullOrEmpty(centence.getMovement()) ? "N" : centence.getMovement())
                .addValue("pSPCDIFFSPP", centence.getSpcdiffspp() != null ? centence.getSpcdiffspp() : 0)
                .addValue("pSPPNEXT", centence.getSppnext() != null ? centence.getSppnext() : 0)
                .addValue("pSPPBACK", centence.getSppback() != null ? centence.getSppback() : 0)
                .addValue("P_USERFOR", userfor)
                .addValue("P_RECEIVEDATE", centence.getReceivedate() == null ? null : Utils.getSqlDate(centence.getReceivedate()))
                .addValue("pSPCID", centence.getSpcid())
                .addValue("pCENTTYPE", centence.getCenttype() != null && centence.getCenttype() ? "Y" : "N")
                //.addValue("pWARNCEN", _obj.getBegin_office())
                .addValue("pxetxurutkn", centence.getXetxurutkn() != null && centence.getXetxurutkn() ? "Y" : "N")
                .addValue("pxetxurutgon", centence.getXetxurutgon() != null && centence.getXetxurutgon() ? "Y" : "N")
                .addValue("pthiethaitaisan", centence.getThiethaitaisan() != null ? centence.getThiethaitaisan() : 0)
                .addValue("pthiethaithamnhung", centence.getThiethaithamnhung() != null ? centence.getThiethaithamnhung() : 0)
                .addValue("pxetxurutknvks", centence.getXetxurutknvks() != null && centence.getXetxurutknvks() ? "Y" : "N")
                .addValue("pSPPEQ", centence.getSppeq() != null ? centence.getSppeq() : 0)
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        String warn = (String)results.get("pWARNCEN");
        String _centcode = centence.getCentcode();

        ret.result = _result;
        if (Utils.StringIsNullOrEmpty(_result))
            if (!Utils.StringIsNullOrEmpty(warn))
                ret.warn = warn;

        if (Utils.StringIsNullOrEmpty(_result)) {
            _centcode = (String) results.get("pCENTCODE");
            regicode = (String) results.get("pREGICODE");
            ret.centCode = _centcode;
            ret.regiCode = regicode;
        }
        return ret;
    }

    @Override
    public String delete(String regicode, SppCentence centence, String conclusionId, String sppId, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("fn_spp_centence")
                .withReturnValue();


        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("pCENTCODE", centence.getCentcode())
                .addValue("pREGICODE", regicode)
                .addValue("pSETNUM", centence.getSetnum())
                .addValue("pINDATE", centence.getIndate() == null ? null : Utils.getSqlDate(centence.getIndate()))
                .addValue("pACTDATE", centence.getActdate() == null ? null : Utils.getSqlDate(centence.getActdate()))
                .addValue("pCONTENT", centence.getContent())
                .addValue("pSIGNNAME", centence.getSignname())
                .addValue("pSIGNOFFICE", centence.getSignoffice())
                .addValue("pREMARK", centence.getRemark())
                .addValue("pCONCID",  centence.getConcid())
                .addValue("pCRTUSER", userId)
                .addValue("pMDFUSER", userId)
                .addValue("pSPPID", sppId)
                .addValue("poption", "D")
                .addValue("pMOVEMENT", Utils.StringIsNullOrEmpty(centence.getMovement()) ? "N" : centence.getMovement())
                .addValue("pSPCDIFFSPP", centence.getSpcdiffspp() != null ? centence.getSpcdiffspp() : 0)
                .addValue("pSPPNEXT", centence.getSppnext() != null ? centence.getSppnext() : 0)
                .addValue("pSPPBACK", centence.getSppback() != null ? centence.getSppback() : 0)
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<SppAccused> getaccufromcentcode(String centcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("FN_GETACCUFROMCENTCODE");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAccused>>)(Class)List.class, paramMap);
    }

    @Override
    public String deleteUpdateinfo(String action, SppCentence centence, String sppId, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("FN_INSERT_UPDATE_DELETE")
                .withReturnValue();


        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("pCENTCODE", centence.getCentcode())
                .addValue("pREGICODE", centence.getRegicode())
                .addValue("pSETNUM", centence.getSetnum())
                .addValue("pINDATE", centence.getIndate() == null ? null : Utils.getSqlDate(centence.getIndate()))
                .addValue("pACTDATE", centence.getActdate() == null ? null : Utils.getSqlDate(centence.getActdate()))
                .addValue("pCONTENT", centence.getContent())
                .addValue("pSIGNNAME", centence.getSignname())
                .addValue("pSIGNOFFICE", centence.getSignoffice())
                .addValue("pREMARK", centence.getRemark())
                .addValue("pCONCID",  centence.getConcid())
                .addValue("pCONCIDSPP",  centence.getConcid())
                .addValue("pCRTUSER", userId)
                .addValue("pMDFUSER", userId)
                .addValue("pSPPID", sppId)
                .addValue("poption", action)
                .addValue("pMOVEMENT", Utils.StringIsNullOrEmpty(centence.getMovement()) ? "N" : centence.getMovement())
                .addValue("pSPCDIFFSPP", centence.getSpcdiffspp() != null ? centence.getSpcdiffspp() : 0)
                .addValue("pSPPNEXT", centence.getSppnext() != null ? centence.getSppnext() : 0)
                .addValue("pSPPBACK", centence.getSppback() != null ? centence.getSppback() : 0)
                .addValue("P_USERFOR", centence.getUserfor())
                .addValue("P_RECEIVEDATE", centence.getReceivedate() == null ? null : Utils.getSqlDate(centence.getReceivedate()))
                .addValue("pSPCID", centence.getSpcid())
                .addValue("pCENTTYPE", centence.getCenttype() != null && centence.getCenttype() ? "Y" : "N")
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCentApped(String regicode, String type) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("FN_GETCENTENCEAPPED");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_REGICODE", regicode)
                .addValue("P_TYPE", type)
                ;
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap getCentdetail(String centcode, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTENCE") //package name
                .withFunctionName("get");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                .addValue("P_SPPID", sppid)
                ;
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(new LinkedCaseInsensitiveMap());
    }

    @Override
    public LinkedCaseInsensitiveMap getCentAccu(String centcode, String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTACC") //package name
                .withFunctionName("FN_GET_ACCU");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                .addValue("P_ACCUCODE", accucode)
                ;
        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, paramMap).stream().findFirst().orElse(null);
    }

    @Override
    public String saveCentAccu(SppCentAccu req, String username) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTACC") //package name
                .withFunctionName("FN_INSERT_UPDATE_CONC")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", req.getCentcode())
                .addValue("P_REGICODE", req.getRegicode())
                .addValue("P_ACCUCODE", req.getAccucode())
                .addValue("P_CONCID", req.getConcid())
                .addValue("P_CONCIDSPP", req.getConcidspp())
                .addValue("P_USER", username)
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String deleteCentAccu(String centcode, String accucode, String regicode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CENTACC") //package name
                .withFunctionName("FN_DELETE")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CENTCODE", centcode)
                .addValue("P_REGICODE", regicode)
                .addValue("P_ACCUCODE", accucode)
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }
}
