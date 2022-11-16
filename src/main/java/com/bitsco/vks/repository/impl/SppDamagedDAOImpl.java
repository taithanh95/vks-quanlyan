package com.bitsco.vks.repository.impl;

import com.bitsco.vks.repository.SppDamagedDAO;
import com.bitsco.vks.request.SppDamagedRequest;
import com.bitsco.vks.response.SppDamagedResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SingleColumnRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class SppDamagedDAOImpl implements SppDamagedDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void insertUpdate(SppDamagedRequest sppDamagedRequest) {
        SimpleJdbcCall jdbcCall;
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_DAMAGED") //package name
                    .withProcedureName("fn_insert");
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_damacode", sppDamagedRequest.getDamaCode())
                    .addValue("p_fullname", sppDamagedRequest.getFullName())
                    .addValue("p_othername", sppDamagedRequest.getOtherName())
                    .addValue("p_byear", sppDamagedRequest.getBYear())
                    .addValue("p_bmonth", sppDamagedRequest.getBMonth())
                    .addValue("p_bdate", sppDamagedRequest.getBDate())
                    .addValue("p_birthday", sppDamagedRequest.getBirthDay())
                    .addValue("p_counid", sppDamagedRequest.getCounId())
                    .addValue("p_natiid", sppDamagedRequest.getNatiId())
                    .addValue("p_sex", sppDamagedRequest.getSex())
                    .addValue("p_religion", sppDamagedRequest.getReligion())
                    .addValue("p_identify", sppDamagedRequest.getIdentify())
                    .addValue("p_levelid", sppDamagedRequest.getLevelId())
                    .addValue("p_locaid", sppDamagedRequest.getLocaId())
                    .addValue("p_locaname", sppDamagedRequest.getLocaName())
                    .addValue("p_address", sppDamagedRequest.getAddress())
                    .addValue("p_addrname", sppDamagedRequest.getAddrName())
                    .addValue("p_occuid", sppDamagedRequest.getOccuId())
                    .addValue("p_officeid", sppDamagedRequest.getOfficeId())
                    .addValue("p_partyid", sppDamagedRequest.getPartyId())
                    .addValue("p_conviction", sppDamagedRequest.getConviction())
                    .addValue("p_offence", sppDamagedRequest.getOffence())
                    .addValue("p_casecode", sppDamagedRequest.getCaseCode())
                    .addValue("p_regicode", sppDamagedRequest.getRegiCode())
                    .addValue("p_id", sppDamagedRequest.getId());
            if (sppDamagedRequest.getIsDisabled() != null) {
                ((MapSqlParameterSource) paramMap).addValue("p_is_disabled", sppDamagedRequest.getIsDisabled() == true ? "Y" : "N");
            } else {
                ((MapSqlParameterSource) paramMap).addValue("p_is_disabled", null);
            }
            if (sppDamagedRequest.getIsWanderer() != null) {
                ((MapSqlParameterSource) paramMap).addValue("p_is_wanderer", sppDamagedRequest.getIsWanderer() == true ? "Y" : "N");
            } else {
                ((MapSqlParameterSource) paramMap).addValue("p_is_wanderer", null);
            }
            if (sppDamagedRequest.getRelationshipWithTheAccused() != null) {
                ((MapSqlParameterSource) paramMap).addValue("p_relationship_with_the_accused", sppDamagedRequest.getRelationshipWithTheAccused() == true ? "Y" : "N");
            } else {
                ((MapSqlParameterSource) paramMap).addValue("p_relationship_with_the_accused", null);
            }
            if (sppDamagedRequest.getIsPregnant() != null) {
                ((MapSqlParameterSource) paramMap).addValue("p_is_pregnant", sppDamagedRequest.getIsPregnant() == true ? "Y" : "N");
            } else {
                ((MapSqlParameterSource) paramMap).addValue("p_is_pregnant", null);
            }
            if (sppDamagedRequest.getIsSuicide() != null) {
                ((MapSqlParameterSource) paramMap).addValue("p_is_suicide", sppDamagedRequest.getIsSuicide() == true ? "Y" : "N");
            } else {
                ((MapSqlParameterSource) paramMap).addValue("p_is_suicide", null);
            }
            jdbcCall.execute(paramMap);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void deleteByID(SppDamagedRequest sppDamagedRequest) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("PKG_SPP_DAMAGED") //package name
                .withProcedureName("fn_delete_by_id");
        SqlParameterSource paramMap = new MapSqlParameterSource()
                .addValue("p_id", sppDamagedRequest.getId());
        jdbcCall.execute(paramMap);
    }

    @Override
    public List<SppDamagedResponse> getByCaseCode(SppDamagedRequest sppDamagedRequest) {
        SimpleJdbcCall jdbcCall;
        RowMapper<SppDamagedResponse> rm = new SingleColumnRowMapper<SppDamagedResponse>() {
            @Override
            public SppDamagedResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
                SppDamagedResponse response = new SppDamagedResponse();
                response.setDamaCode(rs.getString("DAMACODE"));
                response.setFullName(rs.getString("FULLNAME"));
                response.setOtherName(rs.getString("OTHERNAME"));
                response.setByear(rs.getInt("BYEAR"));
                response.setBmonth(rs.getInt("BMONTH"));
                response.setBdate(rs.getInt("BDATE"));
                response.setBirthDay(rs.getDate("BIRTHDAY"));
                response.setCounId(rs.getString("COUNID"));
                response.setNatiId(rs.getString("NATIID"));
                response.setSex(rs.getString("SEX"));
                response.setReligion(rs.getString("RELIGION"));
                response.setIdentify(rs.getString("IDENTIFY"));
                response.setLevelId(rs.getString("LEVELID"));
                response.setLocaId(rs.getString("LOCAID"));
                response.setLocaName(rs.getString("LOCANAME"));
                response.setAddress(rs.getString("ADDRESS"));
                response.setAddrName(rs.getString("ADDRNAME"));
                response.setOccuId(rs.getString("OCCUID"));
                response.setOfficeId(rs.getString("OFFICEID"));
                response.setPartyId(rs.getString("PARTYID"));
                response.setConviction(rs.getInt("CONVICTION"));
                response.setOffence(rs.getInt("OFFENCE"));
                if(rs.getString("IS_DISABLED") != null){
                    response.setIsDisabled(rs.getString("IS_DISABLED").equals("Y") ? true : false);
                }
                if(rs.getString("IS_WANDERER") != null){
                    response.setIsWanderer(rs.getString("IS_WANDERER").equals("Y") ? true : false);
                }
                if(rs.getString("RELATIONSHIP_WITH_THE_ACCUSED") != null){
                    response.setRelationshipWithTheAccused(rs.getString("RELATIONSHIP_WITH_THE_ACCUSED").equals("Y") ? true : false);
                }
                if(rs.getString("IS_PREGNANT") != null){
                    response.setIsPregnant(rs.getString("IS_PREGNANT").equals("Y") ? true : false);
                }
                if(rs.getString("IS_SUICIDE") != null){
                    response.setIsSuicide(rs.getString("IS_SUICIDE").equals("Y") ? true : false);
                }
                response.setCaseCode(rs.getString("CASECODE"));
                response.setRegiCode(rs.getString("REGICODE"));
                response.setId(rs.getLong("ID"));
                return response;
            }
        };
        try {
            jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withCatalogName("PKG_SPP_DAMAGED") //package name
                    .withFunctionName("fn_get_by_casecode")
                    .returningResultSet("return", rm);
            SqlParameterSource paramMap = new MapSqlParameterSource()
                    .addValue("p_casecode", sppDamagedRequest.getCaseCode());
            //First parameter is function output parameter type.
            return jdbcCall.executeFunction((Class<List<SppDamagedResponse>>) (Class) List.class, paramMap);
        } catch (Exception e) {
            throw e;
        }
    }
}
