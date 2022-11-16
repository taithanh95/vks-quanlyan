package com.bitsco.vks.dto;

import java.io.Serializable;
import java.util.Date;

public class LstPoliceSearchDTO implements Serializable {
    private Long rowCount;
    private Integer rNum;
    private String policeId;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String status;
    private String spcId;
    private String spcName;
    private String sppId;
    private String sppName;
    private String locaId;
    private Date crtDate;
    private String crtUser;
    private Date mdfDate;
    private String mdfUser;
    private String position;
    private String shortName;
    private String locaName;
    private String policeCode;
    private String policeLevel;
    private String policeParent;
    private String orderCode;

    private String pluschildren;

    public LstPoliceSearchDTO() {
    }

    public String getPluschildren() { return pluschildren; }

    public void setPluschildren(String pluschildren) { this.pluschildren = pluschildren; }

    public Long getRowCount() {
        return rowCount;
    }

    public void setRowCount(Long rowCount) {
        this.rowCount = rowCount;
    }

    public Integer getrNum() {
        return rNum;
    }

    public void setrNum(Integer rNum) {
        this.rNum = rNum;
    }

    public String getPoliceId() {
        return policeId;
    }

    public void setPoliceId(String policeId) {
        this.policeId = policeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpcId() {
        return spcId;
    }

    public void setSpcId(String spcId) {
        this.spcId = spcId;
    }

    public String getSpcName() {
        return spcName;
    }

    public void setSpcName(String spcName) {
        this.spcName = spcName;
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

    public String getLocaId() {
        return locaId;
    }

    public void setLocaId(String locaId) {
        this.locaId = locaId;
    }

    public Date getCrtDate() {
        return crtDate;
    }

    public void setCrtDate(Date crtDate) {
        this.crtDate = crtDate;
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

    public String getMdfUser() {
        return mdfUser;
    }

    public void setMdfUser(String mdfUser) {
        this.mdfUser = mdfUser;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLocaName() {
        return locaName;
    }

    public void setLocaName(String locaName) {
        this.locaName = locaName;
    }

    public String getPoliceCode() {
        return policeCode;
    }

    public void setPoliceCode(String policeCode) {
        this.policeCode = policeCode;
    }

    public String getPoliceLevel() {
        return policeLevel;
    }

    public void setPoliceLevel(String policeLevel) {
        this.policeLevel = policeLevel;
    }

    public String getPoliceParent() {
        return policeParent;
    }

    public void setPoliceParent(String policeParent) {
        this.policeParent = policeParent;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }
}
