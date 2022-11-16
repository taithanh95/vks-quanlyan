package com.bitsco.vks.models;

import java.io.Serializable;
import java.util.Date;

public class RegisterDecisionResponse implements Serializable {
    private Long id;
    private String userFor;
    private Date inDate;
    private String deciId;
    private String deciName;
    private Integer setNum;
    private Date fromDate;
    private Date toDate;
    private String sppId;
    private String sppName;
    private String spcId;
    private String polId;
    private String applyFor;
    private Integer denouncementCode;
    private String caseCode;
    private String caseName;
    private Short isFirstAcc;
    private String lawCode;
    private String lawId;
    private Date crtDate;
    private Date mdfDate;
    private String crtUser;
    private String mdfUser;
    private Character status;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public String getDeciId() {
        return deciId;
    }

    public void setDeciId(String deciId) {
        this.deciId = deciId;
    }

    public String getDeciName() {
        return deciName;
    }

    public void setDeciName(String deciName) {
        this.deciName = deciName;
    }

    public Integer getSetNum() {
        return setNum;
    }

    public void setSetNum(Integer setNum) {
        this.setNum = setNum;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }

    public String getSppName() {
        return sppName;
    }

    public void setSppName(String sppName) {
        this.sppName = sppName;
    }

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getPolId() {
        return polId;
    }

    public void setPolId(String polId) {
        this.polId = polId;
    }

    public String getApplyFor() {
        return applyFor;
    }

    public void setApplyFor(String applyFor) {
        this.applyFor = applyFor;
    }

    public Integer getDenouncementCode() {
        return denouncementCode;
    }

    public void setDenouncementCode(Integer denouncementCode) {
        this.denouncementCode = denouncementCode;
    }

    public String getCaseCode() {
        return caseCode;
    }

    public void setCaseCode(String caseCode) {
        this.caseCode = caseCode;
    }

    public String getCaseName() {
        return caseName;
    }

    public void setCaseName(String caseName) {
        this.caseName = caseName;
    }

    public Short getIsFirstAcc() {
        return isFirstAcc;
    }

    public void setIsFirstAcc(Short isFirstAcc) {
        this.isFirstAcc = isFirstAcc;
    }

    public String getLawCode() {
        return lawCode;
    }

    public void setLawCode(String lawCode) {
        this.lawCode = lawCode;
    }

    public String getLawId() {
        return lawId;
    }

    public void setLawId(String lawId) {
        this.lawId = lawId;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public Date getMdfDate() {
        return mdfDate;
    }

    public void setMdfDate(Date mdfDate) {
        this.mdfDate = mdfDate;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public String getMdfUser() {
        return mdfUser;
    }

    public void setMdfUser(String mdfUser) {
        this.mdfUser = mdfUser;
    }

    public Character getStatus() {
        return status;
    }

    public void setStatus(Character status) {
        this.status = status;
    }
}
