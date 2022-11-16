package com.bitsco.vks.models;

import com.bitsco.vks.utils.StringCommon;

import java.io.Serializable;

public class LstOccupationRequest implements Serializable {
    private String action;
    private String sortField;
    private String sortOrder;
    private String name;
    private String occuId;
    private String occuname;
    private String remark;
    private String branchJob;

    public LstOccupationRequest() {
    }

    public String getAction() {
        if (StringCommon.isNullOrBlank(action)) return "I";
        return action;
    }

    public void setAction(String action) { this.action = action; }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBranchJob() {
        return branchJob;
    }

    public void setBranchJob(String branchJob) {
        this.branchJob = branchJob;
    }

    public String getOccuId() {
        return occuId;
    }

    public void setOccuId(String occuId) {
        this.occuId = occuId;
    }

    public String getOccuname() {
        return occuname;
    }

    public void setOccuname(String occuname) {
        this.occuname = occuname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
