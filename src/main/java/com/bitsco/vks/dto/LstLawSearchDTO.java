package com.bitsco.vks.dto;

import java.io.Serializable;
import java.util.Date;

public class LstLawSearchDTO implements Serializable {
    private Long rowCount;
    private Integer rNum;
    private String lawCode;
    private String lawId;
    private String item;
    private String point1;
    private String lawName;
    private Date lawDate;
    private Integer priority;
    private Integer setOrder;
    private String groupId;
    private String status;
    private String crtUser;
    private Date crtDate;
    private Date mdfDate;
    private String mdfUser;
    private String codeId;
    private String point;
    private String lawType;
    private String lawCodeParrent;
    private String sync;
    private String lawNameTxt;
    private String codeName;
    private String label;

    public LstLawSearchDTO(){

    }

    public Long getRowCount() {
        return rowCount;
    }

    public void setRowCount(Long rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getRNum() {
        return rNum;
    }

    public void setRNum(Integer rNum) {
        this.rNum = rNum;
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

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPoint1() {
        return point1;
    }

    public void setPoint1(String point1) {
        this.point1 = point1;
    }

    public String getLawName() {
        return lawName;
    }

    public void setLawName(String lawName) {
        this.lawName = lawName;
    }

    public Date getLawDate() {
        return lawDate;
    }

    public void setLawDate(Date lawDate) {
        this.lawDate = lawDate;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getSetOrder() {
        return setOrder;
    }

    public void setSetOrder(Integer setOrder) {
        this.setOrder = setOrder;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCrtUser() {
        return crtUser;
    }

    public void setCrtUser(String crtUser) {
        this.crtUser = crtUser;
    }

    public Date getMdfDate() {
        return mdfDate;
    }

    public void setMdfDate(Date mdfDate) {
        this.mdfDate = mdfDate;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
    }

    public String getMdfUser() {
        return mdfUser;
    }

    public void setMdfUser(String mdfUser) {
        this.mdfUser = mdfUser;
    }

    public String getCodeId() {
        return codeId;
    }

    public void setCodeId(String codeId) {
        this.codeId = codeId;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    public String getLawType() {
        return lawType;
    }

    public void setLawType(String lawType) {
        this.lawType = lawType;
    }

    public String getLawCodeParrent() {
        return lawCodeParrent;
    }

    public void setLawCodeParrent(String lawCodeParrent) {
        this.lawCodeParrent = lawCodeParrent;
    }

    public String getSync() {
        return sync;
    }

    public void setSync(String sync) {
        this.sync = sync;
    }

    public String getLawNameTxt() {
        return lawNameTxt;
    }

    public void setLawNameTxt(String lawNameTxt) {
        this.lawNameTxt = lawNameTxt;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
