package com.bitsco.vks.entity;

import java.util.Date;

public class SppSpcPol {
    public SppSpcPol() {
        super();
    }

    private String transcode;
    private String casecode;
    private Date transdate;
    private String spcid;
    private String polid;
    private String policeid;
    private String sppid;
    private String sender;
    private String receipter;
    private String transtype;
    private String remark;
    private String transfix;
    private String regicode;
    private String  userfor;
    private String status;
    private String  statustype;
    private boolean statuscheck;

    private String[] lststatus;
    private LstPolice atxPol;
    private LstSPP  atxSpp;
    private LstSPC  atxSpc;
    private LstArmyEntity atxArmy;
    private LstRanger atxRanger;
    private LstBorderGuards atxBorderGuards;
    private LstCustoms atxCustoms;
    private String spcname;
    private String sppname;
    private String polname;
    private String regisetnum;
    private String spcpol;
    private String changeid_txt;
    private String evidence;
    private Integer num_of_pen;

    private String changeid; //01 VKS-TA     02 TA-VKS    03 VKS-CQQD       04 CQQD-VKS

    public void setTranscode(String transcode) {
        this.transcode = transcode;
    }

    public String getTranscode() {
        return transcode;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setTransdate(Date transdate) {
        this.transdate = transdate;
    }

    public Date getTransdate() {
        return transdate;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setPolid(String polid) {
        this.polid = polid;
    }

    public String getPolid() {
        return polid;
    }

    public void setPoliceid(String policeid) {
        this.policeid = policeid;
    }

    public String getPoliceid() {
        return policeid;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getSender() {
        return sender;
    }

    public void setReceipter(String receipter) {
        this.receipter = receipter;
    }

    public String getReceipter() {
        return receipter;
    }

    public void setTranstype(String transtype) {
        this.transtype = transtype;
    }

    public String getTranstype() {
        return transtype;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setTransfix(String transfix) {
        this.transfix = transfix;
    }

    public String getTransfix() {
        return transfix;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setAtxPol(LstPolice atxPol) {
        this.atxPol = atxPol;
    }

    public LstPolice getAtxPol() {
        return atxPol;
    }

    public void setAtxSpp(LstSPP atxSpp) {
        this.atxSpp = atxSpp;
    }

    public LstSPP getAtxSpp() {
        return atxSpp;
    }

    public void setAtxSpc(LstSPC atxSpc) {
        this.atxSpc = atxSpc;
    }

    public LstSPC getAtxSpc() {
        return atxSpc;
    }

    public void setChangeid(String changeid) {
        this.changeid = changeid;
    }

    public String getChangeid() {
        return changeid;
    }

    public void setSpcname(String spcname) {
        this.spcname = spcname;
    }

    public String getSpcname() {
        return spcname;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setPolname(String polname) {
        this.polname = polname;
    }

    public String getPolname() {
        return polname;
    }

    public void setRegisetnum(String regisetnum) {
        this.regisetnum = regisetnum;
    }

    public String getRegisetnum() {
        return regisetnum;
    }

    public void setSpcpol(String spcpol) {
        this.spcpol = spcpol;
    }

    public String getSpcpol() {
        return spcpol;
    }

    public void setAtxArmy(LstArmyEntity atxArmy) {
        this.atxArmy = atxArmy;
    }

    public LstArmyEntity getAtxArmy() {
        return atxArmy;
    }

    public void setAtxRanger(LstRanger atxRanger) {
        this.atxRanger = atxRanger;
    }

    public LstRanger getAtxRanger() {
        return atxRanger;
    }

    public void setChangeid_txt(String changeid_txt) {
        this.changeid_txt = changeid_txt;
    }

    public String getChangeid_txt() {
        return changeid_txt;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatuscheck(boolean statuscheck) {
        this.statuscheck = statuscheck;
    }

    public boolean isStatuscheck() {
        return statuscheck;
    }


    public void setStatustype(String statustype) {
        this.statustype = statustype;
    }

    public String getStatustype() {
        return statustype;
    }

    public void setLststatus(String[] lststatus) {
        this.lststatus = lststatus;
    }

    public String[] getLststatus() {
        return lststatus;
    }

    public void setAtxBorderGuards(LstBorderGuards atxBorderGuards) {
        this.atxBorderGuards = atxBorderGuards;
    }

    public LstBorderGuards getAtxBorderGuards() {
        return atxBorderGuards;
    }

    public void setAtxCustoms(LstCustoms atxCustoms) {
        this.atxCustoms = atxCustoms;
    }

    public LstCustoms getAtxCustoms() {
        return atxCustoms;
    }

    public String getEvidence() {return evidence;}

    public void setEvidence(String evidence) {this.evidence = evidence;}

    public Integer getNum_of_pen() {return num_of_pen;}

    public void setNum_of_pen(Integer num_of_pen) {this.num_of_pen = num_of_pen;}
}
