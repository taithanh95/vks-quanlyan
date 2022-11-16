package com.bitsco.vks.models;

import java.io.Serializable;
import java.util.Date;

public class RegisterDecisionCaseSearchRequest implements Serializable {
    private String caseCode;
    private String caseName;
    private String fullName;
    private Date startValue;
    private Date endValue;
    private int pageIndex;
    private int pageSize;
    private String sortField = "casecode";
    private String sortOrder = "desc";
    private String sppId;

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

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getStartValue() {
        return startValue;
    }

    public void setStartValue(Date startValue) {
        this.startValue = startValue;
    }

    public Date getEndValue() {
        return endValue;
    }

    public void setEndValue(Date endValue) {
        this.endValue = endValue;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }
}
