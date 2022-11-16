package com.bitsco.vks.dto;

import java.io.Serializable;
import java.util.Date;

public class RegisterDecisionListResponse implements Serializable {
    private Long id;
    private String caseCode;
    private String caseName;
    private String userFor;
    private String deciId;
    private String deciName;
    private String fullName;
    private Long setNum;
    private Date inDate;
    private Date fromDate;
    private Date toDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getUserFor() {
        return userFor;
    }

    public void setUserFor(String userFor) {
        this.userFor = userFor;
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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Long getSetNum() {
        return setNum;
    }

    public void setSetNum(Long setNum) {
        this.setNum = setNum;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
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
}
