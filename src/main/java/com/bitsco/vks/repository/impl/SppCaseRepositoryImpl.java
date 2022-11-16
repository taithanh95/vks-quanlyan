package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.ProcessSppCaseResponse;
import com.bitsco.vks.repository.SppCaseRepository;
import com.bitsco.vks.utils.ArrayListCommon;
import com.bitsco.vks.utils.DateCommon;
import com.bitsco.vks.utils.StringCommon;
import com.bitsco.vks.utils.Utils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.sql.Types;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class SppCaseRepositoryImpl implements SppCaseRepository {

    private static final Logger LOGGER = LogManager.getLogger("DB");
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<SppCase> searchUpdateInfo1(String sppId, int rowIndex, int pageSize, String sortField, String sortOrder, SppCase _case, SppAccused _acc, SppRegister _regi, SppCentence _cen, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_search_updateinfo1");

        String beginofficeid = _case.getActualBeginOfficeId();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortoder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_beginsetnum", StringCommon.isNullOrBlank(_case.getBegin_setnum()) ? null : _case.getBegin_setnum().trim())
                .addValue("p_sid", StringCommon.isNullOrBlank(_case.getBegin_office()) ? null : _case.getBegin_office().trim())
                .addValue("p_begin_spp", StringCommon.isNullOrBlank(beginofficeid) ? null : beginofficeid.trim())
                .addValue("p_begin_spc", null)
                .addValue("p_beginindatefrom", _case.getBegin_indatefrom() == null? "" : Utils.getSqlDate(_case.getBegin_indatefrom()).toString())
                .addValue("p_beginindateto", _case.getBegin_indateto() == null? "" : Utils.getSqlDate(_case.getBegin_indateto()).toString())
                .addValue("p_casecode", StringCommon.isNullOrBlank(_case.getCasecode()) ? null :_case.getCasecode().trim())
                .addValue("p_casename", StringCommon.isNullOrBlank(_case.getCasename()) ? null : _case.getCasename().trim())
                .addValue("p_casetype", StringCommon.isNullOrBlank(_case.getCasetype()) ? null : _case.getCasetype().trim())
                .addValue("p_lawcode", _case.getAtxLaw() != null ? _case.getAtxLaw().getLawcode() : "")
                .addValue("p_crimdate_from", Utils.getSqlDate(_case.getCrimdate_from()))
                .addValue("p_crimdate_to", Utils.getSqlDate(_case.getCrimdate_to()))
                .addValue("p_sppid", StringCommon.isNullOrBlank(sppId) ? null : sppId.trim() )
                .addValue("p_checksppori", _case.isCheckorisppid() ? "Y" : "N")
                .addValue("p_inspectorname", StringCommon.isNullOrBlank(_regi.getFullname()) ? null : _regi.getFullname().trim())
                .addValue("p_accucode", StringCommon.isNullOrBlank(_acc.getAccucode()) ? null : _acc.getAccucode().trim())
                .addValue("P_ACCUNAME", StringCommon.isNullOrBlank(_acc.getFullname()) ? null : _acc.getFullname().trim())
                .addValue("P_BIRTHDAY_FROM", Utils.getSqlDate(_acc.getBirthdayfrom()))
                .addValue("P_BIRTHDAY_TO", Utils.getSqlDate(_acc.getBirthdayto()))
                .addValue("P_PASTPORTCODE", StringCommon.isNullOrBlank(_acc.getIdentify()) ? null : _acc.getIdentify().trim())
                .addValue("P_LOCANAME", StringCommon.isNullOrBlank(_acc.getLocaname()) ? null : _acc.getLocaname().trim())
                .addValue("P_ADDRNAME", StringCommon.isNullOrBlank(_acc.getAddrname()) ? null : _acc.getAddrname().trim())
                .addValue("P_REGISETNUM", StringCommon.isNullOrBlank(_regi.getSetnum()) ? null : _regi.getSetnum().trim())
                .addValue("P_REGISTATUS", StringCommon.isNullOrBlank(_regi.getRegiclosed()) ? null : _regi.getRegiclosed().trim())
                .addValue("P_REGIINDATE_FROM", Utils.getSqlDate(_regi.getFromdate()))
                .addValue("P_REGIINDATE_TO", Utils.getSqlDate(_regi.getTodate()))
                .addValue("P_CENTSETNUM", StringCommon.isNullOrBlank(_cen.getSetnum()) ? null : _cen.getSetnum().trim())
                .addValue("P_CENTINDATE_FROM", Utils.getSqlDate(_cen.getIndatefrom()))
                .addValue("P_CENTINDATE_TO", Utils.getSqlDate(_cen.getIndateto()))
                .addValue("P_CENTSETNUM1", StringCommon.isNullOrBlank(_cen.getSetnum1()) ? null : _cen.getSetnum1().trim())
                .addValue("P_CENTINDATE_FROM1", Utils.getSqlDate(_cen.getIndatefrom1()))
                .addValue("P_CENTINDATE_TO1", Utils.getSqlDate(_cen.getIndateto1()))
                .addValue("P_USERFOR", userfor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppCase>>)(Class)List.class, paramMap);
    }

    @Override
    public String updatewithwarn(SppCase _obj, String sppId, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_update")
                .withReturnValue();

        String beginofficeid = _obj.getActualBeginOfficeId();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_beginsetnum", _obj.getBegin_setnum())
                .addValue("p_beginindate", Utils.getSqlDate(_obj.getBegin_indate()), Types.DATE)
                .addValue("p_beginoffice", _obj.getBegin_office())
                .addValue("p_beginofficeid", beginofficeid)
                .addValue("p_casecode", _obj.getCasecode())
                .addValue("p_casename", _obj.getCasename())
                .addValue("p_spccasecode", _obj.getSpccasecode())
                .addValue("p_casetype", _obj.getCasetype())
                .addValue("p_crimwhere", _obj.getAtxLocation() != null ? _obj.getAtxLocation().getLocaid() : null)
                .addValue("p_crimwhere1", _obj.getCrimwhere1())
                .addValue("p_crimdate", Utils.getSqlDate(_obj.getCrimdate()), Types.DATE)
                .addValue("p_crimdate1", _obj.getCrimdate1())
                .addValue("p_crimtime", _obj.getCrimtime().equals("__:__") ? "" : _obj.getCrimtime())
                .addValue("p_address", _obj.getAddress())
                .addValue("p_remark", _obj.getRemark())
                .addValue("p_lawcode",  _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawcode() : null)
                .addValue("p_lawid", _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawid() : null)
                .addValue("p_autolaw", _obj.isAutolaw() ? "1" : "0")
                .addValue("p_sppid", sppId)
                .addValue("p_mdfuser", userId)
                //.addValue("p_tachva", isTachva ? "1" : "0")
                .addValue("p_ghihinh", _obj.isGhihinh() ? "Y" : "N")
                .addValue("p_dienthoai", _obj.isDienthoai() ? "Y" : "N")
                .addValue("p_dientu", _obj.isDientu() ? "Y" : "N")
                .addValue("p_kham_nghiem_hien_truong", parseInt(_obj.getKham_nghiem_hien_truong()))
                .addValue("p_nhan_dang", parseInt(_obj.getNhan_dang()))
                .addValue("p_kham_xet", parseInt(_obj.getKham_xet()))
                .addValue("p_kham_nghiem_tu_thi", parseInt(_obj.getKham_nghiem_tu_thi()))
                .addValue("p_nhan_biet_giong_noi", parseInt(_obj.getNhan_biet_giong_noi()))
                .addValue("p_thuc_nghiem_dieu_tra", parseInt(_obj.getThuc_nghiem_dieu_tra()))
                .addValue("p_doi_chat", parseInt(_obj.getDoi_chat()))
                .addValue("p_vks_y_c_khoi_to", _obj.isvks_y_c_khoi_to() ? "Y" : "N")
                .addValue("p_tt_hoi_cung", parseInt(_obj.gettt_hoi_cung()))
                .addValue("p_tt_lk_nbd_ds", parseInt(_obj.gettt_lk_nbd_ds()))
                .addValue("p_tg_hoi_cung", parseInt(_obj.gettg_hoi_cung()))
                .addValue("p_tt_lk_bb_tg", parseInt(_obj.gettt_lk_bb_tg()))
                .addValue("p_tt_lk_nlc", parseInt(_obj.gettt_lk_nlc()))
                .addValue("p_tt_lk_nbh", parseInt(_obj.gettt_lk_nbh()))
                .addValue("p_tg_lk", parseInt(_obj.gettg_lk()))
                .addValue("p_tt_lk_nbb_ntg_nlc_nbh", parseInt(_obj.gettt_lk_nbb_ntg_nlc_nbh()))
                .addValue("p_kham_nghiem_hien_truong_ko", parseInt(_obj.getKham_nghiem_hien_truong_ko()))
                .addValue("p_nhan_dang_ko", parseInt(_obj.getNhan_dang_ko()))
                .addValue("p_kham_xet_ko", parseInt(_obj.getKham_xet_ko()))
                .addValue("p_kham_nghiem_tu_thi_ko", parseInt(_obj.getKham_nghiem_tu_thi_ko()))
                .addValue("p_nhan_biet_giong_noi_ko", parseInt(_obj.getNhan_biet_giong_noi_ko()))
                .addValue("p_thuc_nghiem_dieu_tra_ko", parseInt(_obj.getThuc_nghiem_dieu_tra_ko()))
                .addValue("p_doi_chat_ko", parseInt(_obj.getDoi_chat_ko()))
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromDate()), Types.DATE)
                .addValue("p_settime",  _obj.getSettime())
                .addValue("p_esettime", _obj.getEsettime())
                .addValue("p_finishdate", Utils.getSqlDate(_obj.getFinishdate()), Types.DATE)
                .addValue("p_signname", _obj.getSignname())
                .addValue("p_signoffice", _obj.getSignoffice())
                .addValue("p_denouncement_id", _obj.getDenouncementid())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if(Utils.StringIsNullOrEmpty(_result) && !_obj.getLstInvestment().isEmpty()){
            _result = updOrInsertInvestment(_obj.getLstInvestment(),_obj.getCasecode());
        }
        if(Utils.StringIsNullOrEmpty(_result) && !_obj.getLstInvecode().isEmpty()){
            _result = deleteInvestment(_obj.getLstInvecode(),_obj.getCasecode());
        }
        if (Utils.StringIsNullOrEmpty(_result)) {

            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("FN_CHECK_WARN_CASETYPE");
            paramMap = new MapSqlParameterSource()
                    .addValue("P_CASECODE", _obj.getCasecode())
                    .addValue("P_SPPID", sppId)
            ;
            _result = jdbcCall.executeFunction(String.class, paramMap);
        } else {
//            conn.rollback();
//            throw new Exception(_result);
        }
        return _result;
    }

    @Override
    public String insertwithwarn(SppCase _obj, Boolean isTachva, String sppId, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_insert_2020")
                .withReturnValue();

        String beginofficeid = _obj.getActualBeginOfficeId();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_beginsetnum", _obj.getBegin_setnum())
                .addValue("p_beginindate", Utils.getSqlDate(_obj.getBegin_indate()), Types.DATE)
                .addValue("p_beginoffice", _obj.getBegin_office())
                .addValue("p_beginofficeid", beginofficeid)
                .addValue("p_casecode", _obj.getCasecode())
                .addValue("p_casename", _obj.getCasename())
                .addValue("p_spccasecode", _obj.getSpccasecode())
                .addValue("p_casetype", _obj.getCasetype())
                .addValue("p_crimwhere", _obj.getAtxLocation() != null ? _obj.getAtxLocation().getLocaid() : null)
                .addValue("p_crimwhere1", _obj.getCrimwhere1())
                .addValue("p_crimdate", Utils.getSqlDate(_obj.getCrimdate()), Types.DATE)
                .addValue("p_crimdate1", _obj.getCrimdate1())
                .addValue("p_crimtime", _obj.getCrimtime().equals("__:__") ? "" : _obj.getCrimtime())
                .addValue("p_address", _obj.getAddress())
                .addValue("p_remark", _obj.getRemark())
                .addValue("p_lawcode",  _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawcode() : null)
                .addValue("p_lawid", _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawid() : null)
                .addValue("p_autolaw", _obj.isAutolaw() ? "1" : "0")
                .addValue("p_sppid", sppId)
                .addValue("p_crtuser", userId)
                .addValue("p_tachva", isTachva ? "1" : "0")
                .addValue("p_ghihinh", _obj.isGhihinh() ? "Y" : "N")
                .addValue("p_dienthoai", _obj.isDienthoai() ? "Y" : "N")
                .addValue("p_dientu", _obj.isDientu() ? "Y" : "N")
                .addValue("p_kham_nghiem_hien_truong", parseInt(_obj.getKham_nghiem_hien_truong()))
                .addValue("p_nhan_dang", parseInt(_obj.getNhan_dang()))
                .addValue("p_kham_xet", parseInt(_obj.getKham_xet()))
                .addValue("p_kham_nghiem_tu_thi", parseInt(_obj.getKham_nghiem_tu_thi()))
                .addValue("p_nhan_biet_giong_noi", parseInt(_obj.getNhan_biet_giong_noi()))
                .addValue("p_thuc_nghiem_dieu_tra", parseInt(_obj.getThuc_nghiem_dieu_tra()))
                .addValue("p_doi_chat", parseInt(_obj.getDoi_chat()))
                .addValue("p_vks_y_c_khoi_to", _obj.isvks_y_c_khoi_to() ? "Y" : "N")
                .addValue("p_tt_hoi_cung", parseInt(_obj.gettt_hoi_cung()))
                .addValue("p_tt_lk_nbd_ds", parseInt(_obj.gettt_lk_nbd_ds()))
                .addValue("p_tg_hoi_cung", parseInt(_obj.gettg_hoi_cung()))
                .addValue("p_tt_lk_bb_tg", parseInt(_obj.gettt_lk_bb_tg()))
                .addValue("p_tt_lk_nlc", parseInt(_obj.gettt_lk_nlc()))
                .addValue("p_tt_lk_nbh", parseInt(_obj.gettt_lk_nbh()))
                .addValue("p_tg_lk", parseInt(_obj.gettg_lk()))
                .addValue("p_tt_lk_nbb_ntg_nlc_nbh", parseInt(_obj.gettt_lk_nbb_ntg_nlc_nbh()))
                .addValue("p_kham_nghiem_hien_truong_ko", parseInt(_obj.getKham_nghiem_hien_truong_ko()))
                .addValue("p_nhan_dang_ko", parseInt(_obj.getNhan_dang_ko()))
                .addValue("p_kham_xet_ko", parseInt(_obj.getKham_xet_ko()))
                .addValue("p_kham_nghiem_tu_thi_ko", parseInt(_obj.getKham_nghiem_tu_thi_ko()))
                .addValue("p_nhan_biet_giong_noi_ko", parseInt(_obj.getNhan_biet_giong_noi_ko()))
                .addValue("p_thuc_nghiem_dieu_tra_ko", parseInt(_obj.getThuc_nghiem_dieu_tra_ko()))
                .addValue("p_doi_chat_ko", parseInt(_obj.getDoi_chat_ko()))
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromDate()), Types.DATE)
                .addValue("p_settime",  _obj.getSettime())
                .addValue("p_esettime", _obj.getEsettime())
                .addValue("p_finishdate", Utils.getSqlDate(_obj.getFinishdate()), Types.DATE)
                .addValue("p_signname", _obj.getSignname())
                .addValue("p_signoffice", _obj.getSignoffice())
                .addValue("p_denouncement_id", _obj.getDenouncementid())
                ;

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (Utils.StringIsNullOrEmpty(_result)) {

            String _casecode = (String)results.get("P_CASECODE");
            _obj.setCasecode(_casecode);
            _obj.setCasename((String)results.get("P_CASENAME"));
            if (_obj.getAtxLocation() != null) {
                _obj.setCrimwhere_txt(_obj.getAtxLocation().getRemark());
            }
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("FN_CHECK_WARN_CASETYPE");
            paramMap = new MapSqlParameterSource()
                    .addValue("P_CASECODE", _casecode)
                    .addValue("P_SPPID", sppId)
            ;
            _result = jdbcCall.executeFunction(String.class, paramMap);
            LOGGER.info("Casecode and Create Date and SPPID: " + _obj.getCasecode() + " " + DateCommon.convertDateToStringByPattern(new Date(),"dd/MM/yyyy") + " " + _obj.getSppid());
            if(Utils.StringIsNullOrEmpty(_result) && !ArrayListCommon.isNullOrEmpty(_obj.getLstInvestment())){
                _result = updOrInsertInvestment(_obj.getLstInvestment(),_casecode);
            }
        } else {
//            conn.rollback();
//            throw new Exception(_result);
        }
        return (String)results.get("P_CASECODE");
    }

    @Override
    public String insert(SppCase _obj, Boolean isTachva, String sppId, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_insert_2020")
                .withReturnValue();

        String beginofficeid = _obj.getActualBeginOfficeId();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_beginsetnum", _obj.getBegin_setnum())
                .addValue("p_beginindate", Utils.getSqlDate(_obj.getBegin_indate()), Types.DATE)
                .addValue("p_beginoffice", _obj.getBegin_office())
                .addValue("p_beginofficeid", beginofficeid)
                .addValue("p_casecode", _obj.getCasecode())
                .addValue("p_casename", _obj.getCasename())
                .addValue("p_spccasecode", _obj.getSpccasecode())
                .addValue("p_casetype", _obj.getCasetype())
                .addValue("p_crimwhere", _obj.getAtxLocation() != null ? _obj.getAtxLocation().getLocaid() : null)
                .addValue("p_crimwhere1", _obj.getCrimwhere1())
                .addValue("p_crimdate", Utils.getSqlDate(_obj.getCrimdate()), Types.DATE)
                .addValue("p_crimdate1", _obj.getCrimdate1())
                .addValue("p_crimtime", _obj.getCrimtime().equals("__:__") ? "" : _obj.getCrimtime())
                .addValue("p_address", _obj.getAddress())
                .addValue("p_remark", _obj.getRemark())
                .addValue("p_lawcode",  _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawcode() : null)
                .addValue("p_lawid", _obj.getAtxLaw() != null ? _obj.getAtxLaw().getLawid() : null)
                .addValue("p_autolaw", _obj.isAutolaw() ? "1" : "0")
                .addValue("p_sppid", sppId)
                .addValue("p_crtuser", userId)
                .addValue("p_tachva", isTachva ? "1" : "0")
                .addValue("p_ghihinh", _obj.isGhihinh() ? "Y" : "N")
                .addValue("p_dienthoai", _obj.isDienthoai() ? "Y" : "N")
                .addValue("p_dientu", _obj.isDientu() ? "Y" : "N")
                .addValue("p_kham_nghiem_hien_truong", parseInt(_obj.getKham_nghiem_hien_truong()))
                .addValue("p_nhan_dang", parseInt(_obj.getNhan_dang()))
                .addValue("p_kham_xet", parseInt(_obj.getKham_xet()))
                .addValue("p_kham_nghiem_tu_thi", parseInt(_obj.getKham_nghiem_tu_thi()))
                .addValue("p_nhan_biet_giong_noi", parseInt(_obj.getNhan_biet_giong_noi()))
                .addValue("p_thuc_nghiem_dieu_tra", parseInt(_obj.getThuc_nghiem_dieu_tra()))
                .addValue("p_doi_chat", parseInt(_obj.getDoi_chat()))
                .addValue("p_vks_y_c_khoi_to", _obj.isvks_y_c_khoi_to() ? "Y" : "N")
                .addValue("p_tt_hoi_cung", parseInt(_obj.gettt_hoi_cung()))
                .addValue("p_tt_lk_nbd_ds", parseInt(_obj.gettt_lk_nbd_ds()))
                .addValue("p_tg_hoi_cung", parseInt(_obj.gettg_hoi_cung()))
                .addValue("p_tt_lk_bb_tg", parseInt(_obj.gettt_lk_bb_tg()))
                .addValue("p_tt_lk_nlc", parseInt(_obj.gettt_lk_nlc()))
                .addValue("p_tt_lk_nbh", parseInt(_obj.gettt_lk_nbh()))
                .addValue("p_tg_lk", parseInt(_obj.gettg_lk()))
                .addValue("p_tt_lk_nbb_ntg_nlc_nbh", parseInt(_obj.gettt_lk_nbb_ntg_nlc_nbh()))
                .addValue("p_kham_nghiem_hien_truong_ko", parseInt(_obj.getKham_nghiem_hien_truong_ko()))
                .addValue("p_nhan_dang_ko", parseInt(_obj.getNhan_dang_ko()))
                .addValue("p_kham_xet_ko", parseInt(_obj.getKham_xet_ko()))
                .addValue("p_kham_nghiem_tu_thi_ko", parseInt(_obj.getKham_nghiem_tu_thi_ko()))
                .addValue("p_nhan_biet_giong_noi_ko", parseInt(_obj.getNhan_biet_giong_noi_ko()))
                .addValue("p_thuc_nghiem_dieu_tra_ko", parseInt(_obj.getThuc_nghiem_dieu_tra_ko()))
                .addValue("p_doi_chat_ko", parseInt(_obj.getDoi_chat_ko()))
                .addValue("p_fromdate", Utils.getSqlDate(_obj.getFromDate()), Types.DATE)
                .addValue("p_settime",  _obj.getSettime())
                .addValue("p_esettime", _obj.getEsettime())
                .addValue("p_finishdate", Utils.getSqlDate(_obj.getFinishdate()), Types.DATE)
                .addValue("p_signname", _obj.getSignname())
                .addValue("p_signoffice", _obj.getSignoffice())
                .addValue("p_denouncement_id", _obj.getDenouncementid())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        String _casecode = null;
        if (Utils.StringIsNullOrEmpty(_result)) {

            _casecode = (String)results.get("P_CASECODE");
            _obj.setCasecode(_casecode);
            _obj.setCasename((String)results.get("P_CASENAME"));
            if (_obj.getAtxLocation() != null)
                _obj.setCrimwhere_txt(_obj.getAtxLocation().getRemark());
            if(Utils.StringIsNullOrEmpty(_result) && !ArrayListCommon.isNullOrEmpty(_obj.getLstInvestment())){
                _result = updOrInsertInvestment(_obj.getLstInvestment(),_casecode);
            }
        } else {
//            conn.rollback();
//            throw new Exception(_result);
        }
        LOGGER.info("Casecode and Create Date and SPPID: " + _casecode + " " + DateCommon.convertDateToStringByPattern(new Date(),"dd/MM/yyyy") + " " + _obj.getSppid());
        return _casecode;
    }

    private String parseInt(String s){
        int ret = 0;
        try{
            ret = Integer.parseInt(s.trim());
        } catch (Exception e){
        }
        return (ret+"").trim();
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCaswlaw(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("FN_SEARCHCASELAWUPDATEINFO");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex", rowIndex)
                .addValue("p_pagesize", pageSize)
                .addValue("p_sortfield", sortField)
                .addValue("p_sortorder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_casecode", casecode)
                .addValue("p_userfor", userfor);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction(List.class, paramMap);
    }
    @Override
    public String getTransidByCase(String casecode, String usefor, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_check_transid")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("P_CASECODE", casecode)
                .addValue("P_USERFOR", usefor)
                .addValue("P_SPPID", sppid)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return  _result;
    }

    @Override
    public List<LstLaw> searchLawByCase(String casecode, String userfor) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_searchLaw_by_case");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_userfor",userfor)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLaw>>)(Class)List.class, paramMap);
    }

    @Override
    public String updateCaselawcodewithwarn(SppCase _case, LstLaw law, String userId, String sppId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_update_caselaw")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", _case.getCasecode())
                .addValue("p_lawtype", law.getLawtype())
                .addValue("p_lawcode", law.getLawcode())
                .addValue("p_lawid", law.getLawid())
                .addValue("p_crtuser", userId)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (!Utils.StringIsNullOrEmpty(_result))
            return _result;
        else{
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("FN_CHECK_WARN_CASETYPE")
                    .withReturnValue();

            paramMap = new MapSqlParameterSource()
                    .addValue("P_CASECODE", _case.getCasecode())
                    .addValue("P_SPPID", sppId)
            ;
            results = jdbcCall.execute(paramMap);
            return  (String) results.get("return");
        }
    }

    @Override
    public ProcessSppCaseResponse insertUpdateDeleteCaseLaw(SppCase _case, String action, String lawCode, String userId, String sppId, String userfor) {
        ProcessSppCaseResponse ret = new ProcessSppCaseResponse();
        ret.sppCase = _case;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_add_caselaw")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_casecode", _case.getCasecode())
                .addValue("p_caselawname", _case.getLawcode_txt())
                .addValue("p_casetype", _case.getCasetype())
                .addValue("p_caselawcode", _case.getLawcode())
                .addValue("p_caselawid", _case.getLawid())
                .addValue("p_lawcode", lawCode)
                .addValue("p_crtuser", userId)
                .addValue("p_userfor",userfor)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (!Utils.StringIsNullOrEmpty(_result)){
            ret.result = _result;
            return ret;
        }
        else{
            _case.setLawcode_txt((String)results.get("p_caselawname"));
            _case.setCasetype((String)results.get("p_casetype"));
            _case.setLawcode((String)results.get("p_caselawcode"));
            _case.setLawid((String)results.get("p_caselawid"));

            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("FN_CHECK_WARN_CASETYPE")
                    .withReturnValue();

            paramMap = new MapSqlParameterSource()
                    .addValue("P_CASECODE", _case.getCasecode())
                    .addValue("P_SPPID", sppId)
            ;
            results = jdbcCall.execute(paramMap);
            ret.result = (String) results.get("return");
            return ret;
        }
    }

    @Override
    public ProcessSppCaseResponse deleteCaseLawUpdateInfo(SppCase _case, String action, String lawCode, String userId, String userfor) {
        ProcessSppCaseResponse ret = new ProcessSppCaseResponse();
        ret.sppCase = _case;
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_add_caselaw")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_action", action)
                .addValue("p_casecode", _case.getCasecode())
                .addValue("p_caselawname", _case.getLawcode_txt())
                .addValue("p_casetype", _case.getCasetype())
                .addValue("p_caselawcode", _case.getLawcode())
                .addValue("p_caselawid", _case.getLawid())
                .addValue("p_lawcode", lawCode)
                .addValue("p_crtuser", userId)
                .addValue("p_userfor",userfor)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (!Utils.StringIsNullOrEmpty(_result)){
            ret.result = _result;
            return ret;
        }
        else{
            _case.setLawcode_txt((String)results.get("p_caselawname"));
            _case.setCasetype((String)results.get("p_casetype"));
            _case.setLawcode((String)results.get("p_caselawcode"));
            _case.setLawid((String)results.get("p_caselawid"));

            ret.result = _result;
            return ret;
        }
    }

    @Override
    public String delete(String casecode, String userId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("P_USER", userId)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public List<SppStaticcBegin> searchCaseStatic(String casecode, String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_search_casestaticc");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppStaticcBegin>>)(Class)List.class, paramMap);
    }

    @Override
    public List<CaseHeroin> searchHeroin(String casecode, String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_search_caseheroin");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<CaseHeroin>>)(Class)List.class, paramMap);
    }

    @Override
    public List<CaseExhibit> searchExhibit(String casecode, String lawcode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_search_caseexhibit");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                ;

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<CaseExhibit>>)(Class)List.class, paramMap);
    }

    @Override
    public String insertStaticcBegin(String casecode, String lawcode, List<SppStaticcBegin> lstStaticcBegin, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_deleteall_casestaticc")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (!Utils.StringIsNullOrEmpty(_result)) {
            return _result;
        } else {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("fn_insert_casestaticc")
                    .withReturnValue();
            for (SppStaticcBegin staticc: lstStaticcBegin){
                paramMap = new MapSqlParameterSource()
                        .addValue("p_casecode", casecode)
                        .addValue("p_lawcode", lawcode)
                        .addValue("p_statid", staticc.getStatid())
                        .addValue("p_amount", staticc.getAmount())
                        .addValue("p_crtuser", userid)
                ;
                results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
                if (!Utils.StringIsNullOrEmpty(_result)) {
                    break;
                }
            }
            if (Utils.StringIsNullOrEmpty(_result)) {
                jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                        .withCatalogName("PKG_SPP_CASE") //package name
                        .withFunctionName("fn_casestaticc_getwarning")
                        .withReturnValue();
                paramMap = new MapSqlParameterSource()
                        .addValue("p_casecode", casecode)
                        .addValue("p_lawcode", lawcode)
                ;
                results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
            }
            return _result;
        }
    }

    @Override
    public String insertCaseHeroin(String casecode, String lawcode, CaseHeroin record, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_insert_caseheroin")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                .addValue("p_heroinid", record.getHeroinid())
                .addValue("p_amount", record.getAmount())
                .addValue("p_unit", record.getUnit())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String updateCaseHeroin(String casecode, String lawcode, CaseHeroin record, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_update_caseheroin")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                .addValue("p_heroinid", record.getHeroinid())
                .addValue("p_amount", record.getAmount())
                .addValue("p_unit", record.getUnit())
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        return _result;
    }

    @Override
    public String insertCaseExhibit(String casecode, String lawcode, List<CaseExhibit> lstCaseExhibit, String userid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE") //package name
                .withFunctionName("fn_deleteall_caseexhibit")
                .withReturnValue();

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode", casecode)
                .addValue("p_lawcode", lawcode)
                ;
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");
        if (!Utils.StringIsNullOrEmpty(_result)) {
            return _result;
        } else {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_CASE") //package name
                    .withFunctionName("fn_insert_caseexhibit")
                    .withReturnValue();
            for (CaseExhibit exh: lstCaseExhibit){
                paramMap = new MapSqlParameterSource()
                        .addValue("p_casecode", casecode)
                        .addValue("p_lawcode", lawcode)
                        .addValue("p_exhid", exh.getExhid())
                        .addValue("p_amount", exh.getAmount())
                ;
                results = jdbcCall.execute(paramMap);
                _result = (String) results.get("return");
                if (!Utils.StringIsNullOrEmpty(_result)) {
                    return _result;
                }
            }
            return _result;
        }
    }

    @Override
    public List<SppInvestment> searchInvestment(String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE")
                .withFunctionName("fn_search_investment");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_casecode",casecode);
        return jdbcCall.executeFunction((Class<List<SppInvestment>>)(Class) List.class,paramMap);
    }

    @Override
    public LinkedCaseInsensitiveMap getSppCaseByCasecode(String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE")
                .withFunctionName("fn_get");

        SqlParameterSource param = new MapSqlParameterSource()
                .addValue("p_casecode", casecode);
        return jdbcCall.executeFunction((Class<List<LinkedCaseInsensitiveMap>>) (Class) List.class, param).stream().findFirst().orElse(new LinkedCaseInsensitiveMap());
    }

    private String deleteInvestment(List<String> lstInvecode, String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE")
                .withFunctionName("fn_delete_investment")
                .withReturnValue();
        for(String invecode : lstInvecode){
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_invecode",invecode)
                    .addValue("p_casecode",casecode);
            Map results = jdbcCall.execute(paramMap);
            String res = (String) results.get("return");
            if (!Utils.StringIsNullOrEmpty(res)) {
                return res;
            }
        }
        return null;
    }

    private String updOrInsertInvestment(List<SppInvestment> lstInvestment, String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE")
                .withFunctionName("fn_updateorinsert_investment")
                .withReturnValue();
        for(SppInvestment investment : lstInvestment){
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_invecode",investment.getInvecode())
                    .addValue("p_invetype",investment.getInvetype())
                    .addValue("p_has_inspector",investment.isHas_inspector()?"Y":"N")
                    .addValue("p_reason",investment.getReason())
                    .addValue("p_inveDate",Utils.getSqlDate(investment.getInvedate()), Types.DATE)
                    .addValue("p_invetype_name",investment.getInvetype_name())
                    .addValue("p_investor",investment.getInvestor())
                    .addValue("p_inspcode",investment.getInspcode())
                    .addValue("p_identify",investment.getIdentify())
                    .addValue("p_content_results",investment.getContent_results())
                    .addValue("p_remark",investment.getRemark())
                    .addValue("p_casecode",casecode)
                    .addValue("p_insp_fullname",investment.getInsp_fullname());
            Map result = jdbcCall.execute(paramMap);
            String res = (String) result.get("return");
            if (!Utils.StringIsNullOrEmpty(res)) {
                return res;
            }
        }
        return null;
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchListCaseLaw(String casecode, LstLaw req, int index, int pageSize, String sortField, String sortOrder) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_CASE")
                .withFunctionName("FN_SEARCH_LAW");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_rowindex",index)
                .addValue("p_pagesize",pageSize)
                .addValue("p_sortfield",sortField)
                .addValue("p_sortorder","ASC".equals(sortOrder) ? "ASC" : "DESC")
                .addValue("p_lawid", StringCommon.isNullOrBlank(req.getLawid()) ? null : req.getLawid().trim())
                .addValue("p_item",StringCommon.isNullOrBlank(req.getItem()) ? null : req.getItem().trim())
                .addValue("p_point",StringCommon.isNullOrBlank(req.getPoint()) ? null : req.getPoint().trim())
                .addValue("p_lawname",StringCommon.isNullOrBlank(req.getLawname()) ? null : req.getLawname().trim())
                .addValue("p_groupid",StringCommon.isNullOrBlank(req.getGroupid()) ? null : req.getGroupid().trim())
                .addValue("p_codeid",StringCommon.isNullOrBlank(req.getCodeid()) ? null : req.getCodeid().trim())
                .addValue("p_fromdate", req.getFromdate() == null ? null : Utils.convertDateToString(req.getFromdate(),"yyyy-MM-dd"))
                .addValue("p_todate", req.getTodate() == null ? null : Utils.convertDateToString(req.getTodate(),"yyyy-MM-dd"))
                .addValue("p_casecode",casecode);

        return jdbcCall.executeFunction(List.class, paramMap);
    }
}
