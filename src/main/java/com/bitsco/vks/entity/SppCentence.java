package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;

public class SppCentence {
    public SppCentence() {
        super();
    }

    private String centcode; //varchar2 9
    private String setnum;  //nvarchar2 9
    private Date trialdate;
    private Date indate;
    private Date actdate;
    private Date receivedate;
    private String content; //nvarchar2 2000
    private String signname; //nvarchar2 50
    private String signoffice; //nvarchar2 50
    private String status; //nvarchar2 1
    private String remark; //nvarchar2 2000
    private String regicode; //nvarchar2 9
    private String casecode;
    private String sppid; //nvarchar2 40
    private String concid; //varchar2 2
    private String concid_txt;
    private String concidspp; //varchar2 2
    private String movement; //varchar2 1
    private String movementname; //varchar2 1
    private String userfor; //varchar2 2
    private String spcid;
    private Boolean centtype;
    private Integer spcdiffspp;
    private Integer sppnext;
    private Integer sppeq;
    private Integer sppback;
    private String statusname;
    private String sppname;
    private Date indatefrom;
    private Date indateto;
    private String setnum1;  //nvarchar2 9
    private Date indatefrom1;
    private Date indateto1;
    private Date actdatefrom;
    private Date actdateto;
    private LstConclusion atxCoucid;
    private boolean checkedit;

    private LstSPC atxSpc;

    private boolean xetxurutkn;
    private boolean xetxurutknvks;
    private boolean xetxurutgon;
    private Double thiethaitaisan;
    private Double thiethaithamnhung;


    public void setCentcode(String centcode) {
        this.centcode = centcode;
    }

    public String getCentcode() {
        return centcode;
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

    public void setTrialdate(Date trialdate) {
        this.trialdate = trialdate;
    }

    public Date getTrialdate() {
        return trialdate;
    }

    public void setActdate(Date actdate) {
        this.actdate = actdate;
    }

    public Date getActdate() {
        return actdate;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setSignname(String signname) {
        this.signname = signname;
    }

    public String getSignname() {
        return signname;
    }

    public void setSignoffice(String signoffice) {
        this.signoffice = signoffice;
    }

    public String getSignoffice() {
        return signoffice;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setConcid(String concid) {
        this.concid = concid;
    }

    public String getConcid() {
        return concid;
    }

    public void setMovement(String movement) {
        this.movement = movement;
    }

    public String getMovement() {
        return movement;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor;
    }

    public void setSpcdiffspp(Integer spcdiffspp) {
        this.spcdiffspp = spcdiffspp;
    }

    public Integer getSpcdiffspp() {
        return spcdiffspp;
    }

    public void setSppnext(Integer sppnext) {
        this.sppnext = sppnext;
    }

    public Integer getSppnext() {
        return sppnext;
    }

    public void setSppeq(Integer sppeq) {
        this.sppeq = sppeq;
    }

    public Integer getSppeq() {
        return sppeq;
    }

    public void setSppback(Integer sppback) {
        this.sppback = sppback;
    }

    public Integer getSppback() {
        return sppback;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getStatusname() {
//        this.statusname =  Utils.getTextFromBundle(Constants.BUNDLE_QLA,Constants.CATEGORIES.SppCentenceStatus, this.getStatus());
        return statusname;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setCasecode(String casecode) {
        this.casecode = casecode;
    }

    public String getCasecode() {
        return casecode;
    }

    public void setMovementname(String movementname) {
        this.movementname = movementname;
    }

    public String getMovementname() {
//        this.movementname = Utils.getTextFromBundle(Constants.BUNDLE_QLA,Constants.CATEGORIES.SppCentenceMovement,this.getMovement()); ;
        return movementname;
    }

    public void setAtxCoucid(LstConclusion atxCoucid) {
        this.atxCoucid = atxCoucid;
    }

    public LstConclusion getAtxCoucid() {
        return atxCoucid;
    }

    public void setConcid_txt(String concid_txt) {
        this.concid_txt = concid_txt;
    }

    public String getConcid_txt() {
        return concid_txt;
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

    public void setIndatefrom(Date indatefrom) {
        this.indatefrom = indatefrom;
    }

    public Date getIndatefrom() {
        return indatefrom;
    }

    public void setIndateto(Date indateto) {
        this.indateto = indateto;
    }

    public Date getIndateto() {
        return indateto;
    }

    public void setActdatefrom(Date actdatefrom) {
        this.actdatefrom = actdatefrom;
    }

    public Date getActdatefrom() {
        return actdatefrom;
    }


    public void setActdateto(Date actdateto) {
        this.actdateto = actdateto;
    }

    public Date getActdateto() {
        return actdateto;
    }

    public void setSetnum1(String setnum1) {
        this.setnum1 = setnum1;
    }

    public String getSetnum1() {
        return setnum1;
    }

    public void setIndatefrom1(Date indatefrom1) {
        this.indatefrom1 = indatefrom1;
    }

    public Date getIndatefrom1() {
        return indatefrom1;
    }

    public void setIndateto1(Date indateto1) {
        this.indateto1 = indateto1;
    }

    public Date getIndateto1() {
        return indateto1;
    }

    public void setReceivedate(Date receivedate) {
        this.receivedate = receivedate;
    }

    public Date getReceivedate() {
        return receivedate;
    }

    public void setConcidspp(String concidspp) {
        this.concidspp = concidspp;
    }

    public String getConcidspp() {
        return concidspp;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }


    public void setAtxSpc(LstSPC atxSpc) {
        this.atxSpc = atxSpc;
    }

    public LstSPC getAtxSpc() {
        return atxSpc;
    }

    //    public void setCenttype(Boolean centtype) {
//        this.centtype = centtype;
//    }
    public void setCenttype(String centtype) {
        this.centtype = Utils.toBoolean(centtype);
    }

    public Boolean getCenttype() {
        return centtype;
    }

    //    public void setXetxurutkn(boolean xetxurutkn) {
//        this.xetxurutkn = xetxurutkn;
//    }
    public void setXetxurutkn(String xetxurutkn) {
        this.xetxurutkn = Utils.toBoolean(xetxurutkn);
    }

    public Boolean getXetxurutkn() {
        return xetxurutkn;
    }

    public boolean isXetxurutkn() {
        return xetxurutkn;
    }


    //    public void setXetxurutknvks(boolean xetxurutknvks) {
//        this.xetxurutknvks = xetxurutknvks;
//    }
    public void setXetxurutknvks(String xetxurutknvks) {
        this.xetxurutknvks = Utils.toBoolean(xetxurutknvks);
    }

    public Boolean getXetxurutknvks() {
        return xetxurutknvks;
    }

    public boolean isXetxurutknvks() {
        return xetxurutknvks;
    }


    //    public void setXetxurutgon(boolean xetxurutgon) {
//        this.xetxurutgon = xetxurutgon;
//    }
    public void setXetxurutgon(String xetxurutgon) {
        this.xetxurutgon = Utils.toBoolean(xetxurutgon);
    }

    public Boolean getXetxurutgon() {
        return xetxurutgon;
    }

    public boolean isXetxurutgon() {
        return xetxurutgon;
    }

    public void setThiethaithamnhung(Double thiethaithamnhung) {
        this.thiethaithamnhung = thiethaithamnhung;
    }

    public Double getThiethaithamnhung() {
        return thiethaithamnhung;
    }

    public void setThiethaitaisan(Double thiethaitaisan) {
        this.thiethaitaisan = thiethaitaisan;
    }

    public Double getThiethaitaisan() {
        return thiethaitaisan;
    }
}
