package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.DenouncementDTO;
import com.bitsco.vks.dto.ParamBO;
import com.bitsco.vks.entity.Denouncement;
import com.bitsco.vks.entity.InvestigationActivity;
import com.bitsco.vks.entity.SettlementDecision;
import com.bitsco.vks.entity.VerificationInvestigation;
import com.bitsco.vks.repository.DenouncementRepositoryCustom;
import com.bitsco.vks.utils.DataUtil;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DenouncementRepositoryImpl implements DenouncementRepositoryCustom {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public List<Object[]> getLstDenounce(DenouncementDTO denouncementDTO, boolean count, Pageable pageable) {
        StringBuilder strQuery = new StringBuilder();
        List<ParamBO> listParameter = new ArrayList<>();
        strQuery.append(" WITH b as( ");
        strQuery.append(" select * from spp_report.DENOUNCE_settlement_decision b where (b.DENOUNCEMENT_ID, b.EXECUTE_ORDER) in ( ");
        strQuery.append(" select a.DENOUNCEMENT_ID, MAX(a.EXECUTE_ORDER) from spp_report.DENOUNCE_settlement_decision a  ");
        strQuery.append(" where 1=1 and a.status=1  ");
        strQuery.append(" group by DENOUNCEMENT_ID) and b.status =1  ");
        strQuery.append(" )select * from ( ");
        strQuery.append(" select   d.DENOUNCEMENT_ID,d.SPPID,d.SHARE_INFO_LEVEL,d.DENOUNCEMENT_CODE,d.TAKEN_OVER_DATE,d.R_REPORTER, ");
        strQuery.append(" (select LISTAGG(dp.FULL_NAME,',') from spp_report.DENOUNCE_denounced_person dp where dp.DENOUNCEMENT_ID = d.DENOUNCEMENT_ID and dp.STATUS =1) full_name ,");
        strQuery.append("  case when b.DENOUNCEMENT_ID is null then null WHEN d.IPN_CLASSIFIED_NEWS IS NOT NULL and d.IPN_CLASSIFIED_NEWS = '2' and d.fn_code IS NOT NULL THEN 'Đã chuyển tin' else b.DECISION_NAME end DECISION_NAME ,");
        strQuery.append("   case when  (d.IPN_CLASSIFIED_NEWS is null or d.IPN_CLASSIFIED_NEWS = '2') and d.fn_code is null and trunc(d.settlement_term) < trunc(sysdate)  ");
        strQuery.append("  and (d.SETTLEMENT_STATUS <> 2 and d.SETTLEMENT_STATUS <>3 and d.SETTLEMENT_STATUS<>4 )  then 5 ");
        strQuery.append("   when  (d.IPN_CLASSIFIED_NEWS is null or d.IPN_CLASSIFIED_NEWS in ('1','2'))  and trunc(d.settlement_term) < trunc(sysdate)   ");
        strQuery.append("   and (d.SETTLEMENT_STATUS <> 2 and d.SETTLEMENT_STATUS <>3 and d.SETTLEMENT_STATUS<>4 )  then 5  ");
        strQuery.append("  else d.SETTLEMENT_STATUS  end status_Value,");
        strQuery.append("  b.DECISION_ID, d.status,d.crime_report_source,d.CREATE_USER ");
        strQuery.append(" from b RIGHT join spp_report.denounce_denouncement d ");
        strQuery.append("  on b.DENOUNCEMENT_ID =d.DENOUNCEMENT_ID ");
        strQuery.append(" ) d where 1=1  ");
        if(!DataUtil.isNullOrZero(denouncementDTO.getDenouncementCode())){
            strQuery.append(" and d.DENOUNCEMENT_CODE =:denouncementCode  ");
            listParameter.add(new ParamBO("denouncementCode",denouncementDTO.getDenouncementCode()));
        }
        if(null != denouncementDTO.getFromDate()){
            strQuery.append(" and trunc(d.taken_over_date) >=trunc(:fromDate) ");
            listParameter.add(new ParamBO("fromDate",denouncementDTO.getFromDate()));
        }
        if(null != denouncementDTO.getToDate()){
            strQuery.append(" and trunc(d.taken_over_date) <=trunc(:toDate) ");
            listParameter.add(new ParamBO("toDate",denouncementDTO.getToDate()));
        }
        if(!DataUtil.isNullOrEmpty(denouncementDTO.getListOfSelectedValue())){
            strQuery.append(" and d.crime_report_source in(:listOfSelectedValue )");
            listParameter.add(new ParamBO("listOfSelectedValue",denouncementDTO.getListOfSelectedValue()));
        }
        if(!DataUtil.isNullOrEmpty(denouncementDTO.getDelatorOrAccused())){
            strQuery.append(" and (LOWER(d.r_reporter) like :delatorOrAccused ");
            strQuery.append(" or exists (select 1 from spp_report.DENOUNCE_denounced_person dp where LOWER(dp.full_name) like LOWER(:delatorOrAccused) and d.DENOUNCEMENT_ID = dp.DENOUNCEMENT_ID and dp.status=1)) ");
            listParameter.add(new ParamBO("delatorOrAccused","%"+denouncementDTO.getDelatorOrAccused().toLowerCase().trim()
                    .replace("\\", "\\\\").replace("_", "\\_").replace("%", "\\%")+"%"));
        }
        if(!DataUtil.isNullOrEmpty(denouncementDTO.getLstSettlementResultsSelected())){
            strQuery.append("  and d.DECISION_ID in(:lstSettlementResultsSelected)  ");
            listParameter.add(new ParamBO("lstSettlementResultsSelected",denouncementDTO.getLstSettlementResultsSelected()));
        }
        if(!DataUtil.isNullOrEmpty(denouncementDTO.getLstDenouncementStatusSelected())){
            strQuery.append(" and d.status_value in(:lstDenouncementStatusSelected)");
            listParameter.add(new ParamBO("lstDenouncementStatusSelected",denouncementDTO.getLstDenouncementStatusSelected()));
        }
        strQuery.append(" and  d.SPPID=:sppId ");
        listParameter.add(new ParamBO("sppId",denouncementDTO.getSppId()));
        strQuery.append(" and ((d.CREATE_USER <> :userName and SHARE_INFO_LEVEL <> 2) or d.CREATE_USER =:userName)");
        listParameter.add(new ParamBO("userName",denouncementDTO.getCreateUser()));
        strQuery.append(" and  d.status=1 ");
        Query query;
        if (count){
            String strCount ="select count(*) from (" +strQuery.toString() +")";
             query = em.createNativeQuery(strCount);
        }else {
            String orderTaken = "order by TAKEN_OVER_DATE DESC";
            for (Sort.Order order : pageable.getSort())
            {
                if(DataUtil.safeEqual(denouncementDTO.getSortField(),"s_date_receive")){
                    if(order.getProperty().equals("descend")){
                        orderTaken ="order by TAKEN_OVER_DATE  DESC";
                    }else {
                        orderTaken ="order by TAKEN_OVER_DATE ASC";
                    }
                }else if(DataUtil.safeEqual(denouncementDTO.getSortField(),"s_status")){
                    if(order.getProperty().equals("descend")){
                        orderTaken ="order by status_value  DESC";
                    }else {
                        orderTaken ="order by status_value ASC";
                    }
                }
            }

            String strSearchPagging = " select c.*,rownum as r2  from (select b.* , rownum r  from (";
            strSearchPagging += strQuery.toString();
            strSearchPagging += ")b " + orderTaken + " OFFSET ((:pageNumber) *:pageSize ) ROWS FETCH NEXT (:pageSize) ROWS ONLY " ;
            strSearchPagging +=")c ";
            query = em.createNativeQuery(strSearchPagging);
            listParameter.add(new ParamBO("pageSize", pageable.getPageSize()));
            listParameter.add(new ParamBO("pageNumber", pageable.getPageNumber()));
        }
        for (ParamBO paramBO:listParameter){
            query.setParameter(paramBO.getName(),paramBO.getValue());
        }
        List<Object[]> result = query.getResultList();

        return result;
    }

    @Override
    public Long getDenounceCodeInYear(int year) {
        StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT MAX(denouncement_code) FROM spp_report.denounce_denouncement ");
        strQuery.append("where :year = extract(YEAR from TAKEN_OVER_DATE) ");
        BigDecimal code = (BigDecimal) em.createNativeQuery(strQuery.toString())
                .setParameter("year", year)
                .getSingleResult();
        if (code == null) {
            return 1L;
        }
        return code.longValue() + 1;
    }

    @Override
    public Optional<Denouncement> findByIdCustom(Long id) {
        String queryStr = "SELECT d FROM Denouncement d LEFT JOIN FETCH d.denouncedPeople dp WHERE d.id = :id";
        TypedQuery<Denouncement> denouncementTypedQuery =
            this.em.createQuery(queryStr, Denouncement.class);
        denouncementTypedQuery.setParameter("id", id);
        Denouncement denouncement = denouncementTypedQuery.getSingleResult();

        String queryVerificationInvestigation = "SELECT vi FROM VerificationInvestigation vi WHERE vi.denouncementId = :id AND vi.status = 1";
        TypedQuery<VerificationInvestigation> verificationInvestigationTypedQuery =
            this.em.createQuery(queryVerificationInvestigation, VerificationInvestigation.class);
        verificationInvestigationTypedQuery.setParameter("id", id);
        denouncement.setVerificationInvestigations(verificationInvestigationTypedQuery.getResultList());

        String querySettlementDecision = "SELECT sd FROM SettlementDecision sd WHERE sd.denouncementId = :id AND sd.status = 1 ORDER BY sd.executeOrder";
        TypedQuery<SettlementDecision> settlementDecisionTypedQuery =
            this.em.createQuery(querySettlementDecision, SettlementDecision.class);
        settlementDecisionTypedQuery.setParameter("id", id);
        denouncement.setSettlementDecisions(settlementDecisionTypedQuery.getResultList());

        String queryInvestigationActivity = "SELECT ia FROM InvestigationActivity ia WHERE ia.denouncementId = :id AND ia.status = 1";
        TypedQuery<InvestigationActivity> investigationActivityTypedQuery =
            this.em.createQuery(queryInvestigationActivity, InvestigationActivity.class);
        investigationActivityTypedQuery.setParameter("id", id);
        denouncement.setInvestigationActivities(investigationActivityTypedQuery.getResultList());
        return Optional.of(denouncement);
    }

    @Override
    public Integer getDefaultLevelShareInfoBySppId(String sppId) {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DEFAULT_SHARE_INFO_LVL FROM spp_report.DENOUNCE_SPP_SHARE_INFO_LVL ");
            sql.append("WHERE SPPID=:sppId");
            BigDecimal result = (BigDecimal) em.createNativeQuery(sql.toString()).setParameter("sppId", sppId).getSingleResult();
            return result.intValue();
        } catch (NoResultException e) {
            return 0;
        }
    }
}
