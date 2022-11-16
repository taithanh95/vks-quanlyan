package com.bitsco.vks.repository.impl;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.repository.SppAccusedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Map;

@Repository
public class SppAccusedRepositoryImpl implements SppAccusedRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<SppAccused> search_bc(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String sppid, String casecode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED_UPDATE") //package name
                .withFunctionName("fn_search_forupdateregister");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_index", rowIndex)
                .addValue("p_pageSize", pageSize)
                .addValue("p_sortField", sortField)
                .addValue("p_sortOrder", sortOrder.equals("ASC") ? "ASC" : "DESC")
                .addValue("p_regicode", regicode)
                .addValue("p_sppid", sppid)
                .addValue("p_casecode", casecode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<SppAccused>>) (Class) List.class, paramMap);
    }

    @Override
    public String insertUpdate(String action, String casecode, SppAccused ac, LstLocation address, LstLocation locaid, String regicode, LstSPC spc, LstSPP spp, LstPolice police
            , LstArmyEntity army, LstCustoms customs, LstRanger ranger, LstBorderGuards border, LstCountryEntity country, String sppid, List<LstLaw> lawcode, String phapnhan, String userId) {

        String functionName = action.equals("I") ? "fn_insert_v2" : "fn_update_v2";
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED") //package name
                .withFunctionName(functionName)
                .withReturnValue();
        StringBuilder sb = new StringBuilder();
        if (lawcode != null) {
            for (LstLaw l : lawcode) {
                sb.append(l.getLawcode());
                sb.append(",");
            }
        }
        String begin_officeid = "";
        if ("SPC".equals(ac.getBegin_office())) {
            begin_officeid = spc.getSpcid();
        } else if ("SPP".equals(ac.getBegin_office())) {
            begin_officeid = spp.getSppid();
        } else if ("02".equals(ac.getBegin_office())) {
            begin_officeid = police.getPoliceid();
        } else if ("04".equals(ac.getBegin_office())) {
            begin_officeid = army.getArmyid();
        } else if ("06".equals(ac.getBegin_office())) {
            begin_officeid = customs.getCustomid();
        } else if ("08".equals(ac.getBegin_office())) {
            begin_officeid = ranger.getRangid();
        } else if ("09".equals(ac.getBegin_office())) {
            begin_officeid = border.getBorguaid();
        }

        SqlParameterSource paramMap = new MapSqlParameterSource()
                //.addValue("p_casecode", casecode)
                .addValue("p_fullname", ac.getFullname())
                .addValue("p_othername", ac.getOthername())
                .addValue("p_aliasname", ac.getAliasname())
                .addValue("p_address", address.getLocaid())
                .addValue("p_locaid", locaid.getLocaid())
                .addValue("p_birthday", ac.getBirthday())
                .addValue("p_sex", ac.getSex())
                .addValue("p_identify", ac.getIdentify())
                .addValue("p_identifyd", ac.getIdentifyd())
                .addValue("p_inparty", ac.getPartyid() == null || ac.getPartyid().isEmpty() ? "N" : "Y")
                .addValue("p_natiid", ac.getNatiid())
                .addValue("p_religion", ac.getReligion())
                .addValue("p_heroin", ac.getHeroin() ? "Y" : "N")
                .addValue("p_conviction", ac.getConviction())
                .addValue("p_offence", ac.getOffence())
                .addValue("p_counid", country.getCounid())
                .addValue("p_occuid", ac.getOccuid())
                .addValue("p_levelid", ac.getLevelid())
                .addValue("p_officeid", ac.getOfficeid())
                .addValue("p_partyid", ac.getPartyid())
                .addValue("p_wander", ac.getWander() ? "Y" : "N")
                .addValue("p_begin_setnum", ac.getBegin_setnum())
                .addValue("p_begin_indate", ac.getBegin_indate())
                .addValue("p_begin_office", ac.getBegin_office())
                .addValue("p_begin_officeid", begin_officeid)
                .addValue("p_unoccupation", ac.getUnoccupation() ? "Y" : "N")
                .addValue("p_occuteler", ac.getOccuteler() ? "Y" : "N")
                .addValue("p_occudishonest", ac.getOccudishonest() ? "Y" : "N")
                .addValue("p_occureeducate", ac.getOccureeducate() ? "Y" : "N")
                .addValue("p_occusoldier", ac.getOccusoldier() ? "Y" : "N")
                .addValue("p_occustudent", ac.getOccustudent() ? "Y" : "N")
                .addValue("p_occuofficer", ac.getOccuofficer() ? "Y" : "N")
                .addValue("p_DPVNDTN", ac.getDpvndtn() ? "Y" : "N")
                .addValue("p_TEN_NBC", ac.getTen_nbc())
                .addValue("p_sppid", sppid)
                .addValue("p_addrname", ac.getAddrname())
                .addValue("p_locaname", ac.getLocaname())
                .addValue("p_user", userId)
                .addValue("p_bday", ac.getBday())
                .addValue("p_bmonth", ac.getBmonth())
                .addValue("p_byear", ac.getByear())
                .addValue("p_regicode", regicode)
                .addValue("p_firstacc", "Y".equals(ac.getFirstacc()) ? "Y" : "N")
                .addValue("p_phapnhan", phapnhan)
                .addValue("p_baochua", ac.getBaochua() ? "Y" : "N")
                .addValue("p_bcvnd", ac.getBcvnd() ? "Y" : "N")
                .addValue("p_tgvpl", ac.getTgvpl() ? "Y" : "N")
                .addValue("p_lawcode", sb.toString())
                .addValue("p_preventivemeasuresid", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getPreventiveMeasuresId())
                .addValue("p_deadday", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getDeadDay())
                .addValue("p_causeofdeath", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getCauseOfDeath())
                .addValue("p_dayofhiding", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getDayOfHiding())
                .addValue("p_reasonforhiding", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getReasonForHiding())
                .addValue("p_recapturedate", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getRecaptureDate())
                .addValue("p_moveoutdate", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getMoveOutdate())
                .addValue("p_moveindate", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getMoveInDate())
                .addValue("p_reason", ac.getSppAccadditioninfo() == null ? null : ac.getSppAccadditioninfo().getReason())
                .addValue("p_arrestee_id",ac.getArresteeId());
        if (ac.getSppAccadditioninfo() != null && ac.getSppAccadditioninfo().getDead() != null) {
            ((MapSqlParameterSource) paramMap).addValue("p_dead", ac.getSppAccadditioninfo().getDead() ? "Y" : "N");
        } else {
            ((MapSqlParameterSource) paramMap).addValue("p_dead", null);
        }
        if (ac.getSppAccadditioninfo() != null && ac.getSppAccadditioninfo().getFled() != null) {
            ((MapSqlParameterSource) paramMap).addValue("p_fled", ac.getSppAccadditioninfo().getFled() ? "Y" : "N");
        } else {
            ((MapSqlParameterSource) paramMap).addValue("p_fled", null);
        }
        if (ac.getSppAccadditioninfo() != null && ac.getSppAccadditioninfo().getMoveToOtherPlace() != null) {
            ((MapSqlParameterSource) paramMap).addValue("p_movetootherplace", ac.getSppAccadditioninfo().getMoveToOtherPlace() ? "Y" : "N");
        } else {
            ((MapSqlParameterSource) paramMap).addValue("p_movetootherplace", null);
        }
        if (ac.getSppAccadditioninfo() != null && ac.getSppAccadditioninfo().getMovedToAnotherPlace() != null) {
            ((MapSqlParameterSource) paramMap).addValue("p_movedtoanotherplace", ac.getSppAccadditioninfo().getMovedToAnotherPlace() ? "Y" : "N");
        } else {
            ((MapSqlParameterSource) paramMap).addValue("p_movedtoanotherplace", null);
        }
        if (action.equals("I"))
            ((MapSqlParameterSource) paramMap).addValue("p_casecode", casecode);
        else
            ((MapSqlParameterSource) paramMap).addValue("p_accucode", ac.getAccucode());

        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        if (_result != null && (_result.contains("error"))) {

        } else if (_result != null && (_result.contains("ORA"))) {

        } else {
            if (action.equals("I")) {

                if (regicode != null && !regicode.isEmpty()) {
                    addBc(regicode, _result, sppid);
                }

            } else {

            }

        }

        return _result;
    }

    private void addBc(String regicode, String accucode, String sppid) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED") //package name
                .withFunctionName("fn_add_bc");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_regicode", regicode)
                .addValue("p_accucode", accucode)
                .addValue("p_user", sppid);
        Map results = jdbcCall.execute(paramMap);
    }

    @Override
    public String delete(String code) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED") //package name
                .withFunctionName("fn_delete")
                .withReturnValue();
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_accucode", code);
        Map results = jdbcCall.execute(paramMap);
        String _result = (String) results.get("return");

        return _result;
    }

    @Override
    public List<LstLaw> findLawcodeByAccused(String accucode) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_ACCUSED") //package name
                .withFunctionName("fn_find_lawcode_by_accused");

        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_accucode", accucode);

        //First parameter is function output parameter type.
        return jdbcCall.executeFunction((Class<List<LstLaw>>) (Class) List.class, paramMap);
    }

    @Override
    public List<String> findAccusedCodeByArresteeId(String arresteeId){
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT CASECODE FROM SPP_ACCUSED WHERE N_ARRESTEE_ID =:id");
        return (List<String>) em.createNativeQuery(sql.toString()).setParameter("id", arresteeId).getResultList();
    }
}
