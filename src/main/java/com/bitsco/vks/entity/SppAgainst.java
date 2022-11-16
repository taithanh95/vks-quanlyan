package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;
import java.util.List;

public class SppAgainst{

    private String regicode;
    private String againstcode;
    private String casecode;
    private String casename;
    private String sppid;
    private String sppname;
    private String setnum;
    private Date indate;
    private String content;
    private String sppspc;
    private String sppspcname;
    private String againstid;
    private String[] arrAgainstid;
    private List<LstAgainstEntity> lstAgainstid;
    private String userfor;
    private String userforname;
    private String forsetnum;
    private Date   forindate;
    private String resultid;
    private String gd_tt;
    private Date crimdate_from;
    private Date crimdate_to;
    private Date regis_indate;
    private Date crimdate;
    private String againstname;
    private String resultname;
    private boolean checkedit;
    private String setnumcen;
    private String agafor;
    private String agaforname;
    private String agalevel;
    private String accucode;
    private String accuname;
    private String fullname;
    private String legalper;
    private boolean change;
    private Date changedate;
    private String changecontent;
    private boolean additional;
    private Date additionaldate;
    private String additionalcontent;
    private boolean withdraw;
    private Date withdrawdate;
    private String withdrawcontent;

    public SppAgainst() {
        super();
    }

    public void setAgainstcode(String againstcode) {
        this.againstcode = againstcode;
    }

    public String getAgainstcode() {
        return againstcode;
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

    public void setSetnum(String setnum) {
        this.setnum = setnum;
    }

    public String getSetnum() {
        return setnum;
    }

    public void setIndate(Date indate) {
        this.indate = indate;
    }

    public Date getIndate() {
        return indate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSppspc(String sppspc) {
        this.sppspc = sppspc;
//        this.sppspcname = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.SpcSpp, this.sppspc);
    }

    public String getSppspc() {
        return sppspc;
    }

    public void setAgainstid(String againstid) {
        this.againstid = againstid;
    }

    public String getAgainstid() {
        return againstid;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
//        this.userforname = Utils.getTextFromBundle(null, Constants.CATEGORIES.UseFor, this.userfor);
    }

    public String getUserfor() {
        return userfor;
    }

    public void setForsetnum(String forsetnum) {
        this.forsetnum = forsetnum;
    }

    public String getForsetnum() {
        return forsetnum;
    }

    public void setForindate(Date forindate) {
        this.forindate = forindate;
    }

    public Date getForindate() {
        return forindate;
    }

    public void setResultid(String resultid) {
        this.resultid = resultid;
    }

    public String getResultid() {
        return resultid;
    }

    public void setGd_tt(String gd_tt) {
        this.gd_tt = gd_tt;
    }

    public String getGd_tt() {
        return gd_tt;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setUserforname(String userforname) {
        this.userforname = userforname;
    }

    public String getUserforname() {
        return userforname;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setCrimdate_from(Date crimdate_from) {
        this.crimdate_from = crimdate_from;
    }

    public Date getCrimdate_from() {
        return crimdate_from;
    }

    public void setCrimdate_to(Date crimdate_to) {
        this.crimdate_to = crimdate_to;
    }

    public Date getCrimdate_to() {
        return crimdate_to;
    }

    public void setSppspcname(String sppspcname) {
        this.sppspcname = sppspcname;
    }

    public String getSppspcname() {
        return sppspcname;
    }

    public void setRegis_indate(Date regis_indate) {
        this.regis_indate = regis_indate;
    }

    public Date getRegis_indate() {
        return regis_indate;
    }

    public void setCrimdate(Date crimdate) {
        this.crimdate = crimdate;
    }

    public Date getCrimdate() {
        return crimdate;
    }

    public void setAgainstname(String againstname) {
        this.againstname = againstname;
    }

    public String getAgainstname() {
        return againstname;
    }

    public void setResultname(String resultname) {
        this.resultname = resultname;
    }

    public String getResultname() {
        return resultname;
    }

//    public void setCheckedit(boolean checkedit) {
//        this.checkedit = checkedit;
//    }
    public void setCheckedit(String checkedit) {
        this.checkedit = Utils.toBoolean(checkedit);
    }

    public boolean isCheckedit() {
        return checkedit;
    }

    public void setSetnumcen(String setnumcen) {
        this.setnumcen = setnumcen;
    }

    public String getSetnumcen() {
        return setnumcen;
    }

    public void setAgafor(String agafor) {
        this.agafor = agafor;
//        this.agaforname = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.Agafor, this.agafor);
    }

    public String getAgafor() {
        return agafor;
    }

    public void setAgaforname(String agaforname) {
        this.agaforname = agaforname;
    }

    public String getAgaforname() {
        return agaforname;
    }

    public void setAgalevel(String agalevel) {
        this.agalevel = agalevel;
    }

    public String getAgalevel() {
        return agalevel;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setAccuname(String accuname) {
        this.accuname = accuname;
    }

    public String getAccuname() {
        return accuname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setArrAgainstid(String[] arrAgainstid) {
        this.arrAgainstid = arrAgainstid;
    }

    public String[] getArrAgainstid() {
        return arrAgainstid;
    }

    public void setLstAgainstid(List<LstAgainstEntity> lstAgainstid) {
        this.lstAgainstid = lstAgainstid;
    }

    public List<LstAgainstEntity> getLstAgainstid() {
        return lstAgainstid;
    }

    public String getLegalper() { return legalper; }

    public void setLegalper(String legalper) { this.legalper = legalper; }

    public void setCheckedit(boolean checkedit) { this.checkedit = checkedit; }

    public boolean isChange() { return change; }

    public void setChange(boolean change) { this.change = change; }

    public Date getChangedate() { return changedate; }

    public void setChangedate(Date changedate) { this.changedate = changedate; }

    public String getChangecontent() { return changecontent; }

    public void setChangecontent(String changecontent) { this.changecontent = changecontent; }

    public boolean isAdditional() { return additional; }

    public void setAdditional(boolean additional) { this.additional = additional; }

    public Date getAdditionaldate() { return additionaldate; }

    public void setAdditionaldate(Date additionaldate) { this.additionaldate = additionaldate; }

    public String getAdditionalcontent() { return additionalcontent; }

    public void setAdditionalcontent(String additionalcontent) { this.additionalcontent = additionalcontent; }

    public boolean isWithdraw() { return withdraw; }

    public void setWithdraw(boolean withdraw) { this.withdraw = withdraw; }

    public Date getWithdrawdate() { return withdrawdate; }

    public void setWithdrawdate(Date withdrawdate) { this.withdrawdate = withdrawdate; }

    public String getWithdrawcontent() { return withdrawcontent; }

    public void setWithdrawcontent(String withdrawcontent) { this.withdrawcontent = withdrawcontent; }
}