package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;
import java.util.List;

public class SppAppeal {

    private String appecode;
    private String casecode;
    private String casename;
    private String sppid;
    private String sppname;
    private String content;
    private Date indate;
    private String appealid;
    private String[] arrAppealid;
    private List<LstAppeal> lstAppealid;
    private String appealname;
    private String firstacc;
    private String userfor;
    private String regicode;
    private Date actdate;
    private Date regis_indate;
    private Date centindate;
    private String accucode;
    private String accuname;
    private String acctype;
    private String perapp;
    private boolean checkedit;
    private String appeafor;
    private String appeaforname;
    private String setnum;
    private Date setdate;
    private String legalper;
    private String participate;

    public SppAppeal() {
        super();
    }

    public void setAppecode(String appecode) {
        this.appecode = appecode;
    }

    public String getAppecode() {
        return appecode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setCasename(String casename) {
        this.casename = casename;
    }

    public String getCasename() {
        return casename;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setAppealid(String appealid) {
        this.appealid = appealid;
    }

    public String getAppealid() {
        return appealid;
    }

    public void setFirstacc(String firstacc) {
        this.firstacc = firstacc;
    }

    public String getFirstacc() {
        return firstacc;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setActdate(Date actdate) {
        this.actdate = actdate;
    }

    public Date getActdate() {
        return actdate;
    }

    public void setRegis_indate(Date regis_indate) {
        this.regis_indate = regis_indate;
    }

    public Date getRegis_indate() {
        return regis_indate;
    }

    public void setAppealname(String appealname) {
        this.appealname = appealname;
    }

    public String getAppealname() {
        return appealname;
    }

    public void setCentindate(Date centindate) {
        this.centindate = centindate;
    }

    public Date getCentindate() {
        return centindate;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setAcctype(String acctype) {
        this.acctype = acctype;
    }

    public String getAcctype() {
        return acctype;
    }

    public void setPerapp(String perapp) {
        this.perapp = perapp;
    }

    public String getPerapp() {
        return perapp;
    }

    public void setCheckedit(String checkedit) {
        this.checkedit = Utils.toBoolean(checkedit);
    }

    public boolean isCheckedit() {
        return checkedit;
    }

    public void setAppeafor(String appeafor) {
        this.appeafor = appeafor;
//        this.appeaforname =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Appeafor, this.appeafor);
    }

    public String getAppeafor() {
        return appeafor;
    }

    public void setAppeaforname(String appeaforname) {
        this.appeaforname = appeaforname;
    }

    public String getAppeaforname() {
        return appeaforname;
    }

    public void setSetnum(String setnum) {
        this.setnum = setnum;
    }

    public String getSetnum() {
        return setnum;
    }

    public void setSetdate(Date setdate) {
        this.setdate = setdate;
    }

    public Date getSetdate() {
        return setdate;
    }

    public void setAccuname(String accuname) {
        this.accuname = accuname;
    }

    public String getAccuname() {
        return accuname;
    }

    public void setArrAppealid(String[] arrAppealid) {
        this.arrAppealid = arrAppealid;
    }

    public String[] getArrAppealid() {
        return arrAppealid;
    }

    public void setLstAppealid(List<LstAppeal> lstAppealid) {
        this.lstAppealid = lstAppealid;
    }

    public List<LstAppeal> getLstAppealid() {
        return lstAppealid;
    }

    public String getLegalper() { return legalper; }

    public void setLegalper(String legalper) { this.legalper = legalper; }

    public String getParticipate() { return participate; }

    public void setParticipate(String participate) { this.participate = participate; }
}