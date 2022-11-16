package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

import java.util.Date;

public class SppRegister {
    public SppRegister() {
        super();
    }

    private String casecode;
    private String casename;
    private String regicode;
    private String sppid;
    private String setnum;
    private Date indate;
    private Date fromdate;
    private Date todate;
    private boolean special;
    private String userfor;
    private String remark;
    private Date finishdate;
    private String lawcode;
    private String casetype;
    private String status;
    private String statusname; //TuTD2 them vao
    private String unspecial;
    private String sppspc;
    private String appecode;
    private String againstcode;
    private String strmdeciid;
    private String transfer;
    private String transferout;
    private String statusreason;
    private String accucode;
    private String sppname;
    private String userforname;
    private String begin_setnum;
    private String fullname;
    private String updnum; // TuBn2
    private String regiclosed;
    private String editable;
    private boolean checkhasregi;
    private String spcsetnum;
    private Date spcindate;
    private boolean lawyer;
    private boolean bcvnd;
    private boolean tgvpl;

    private String bregicodetha; // lÆ°u mÃ£ thá»¥ lÃ½ thi hÃ nh Ã¡n khi á»§y thÃ¡c cho viá»‡n khÃ¡c

    public void setRegicode(String regicode) {
        this.regicode = regicode;
    }

    public String getRegicode() {
        return regicode;
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

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setFinishdate(Date finishdate) {
        this.finishdate = finishdate;
    }

    public Date getFinishdate() {
        return finishdate;
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
//        this.userforname = Utils.getTextFromBundle(null, Constants.CATEGORIES.Userfor_Regi, this.userfor);
    }

    public String getUserfor() {
        return userfor;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRemark() {
        return remark;
    }

    public void setStatus(String status) {
        this.status = status;
//        this.statusname =
//                Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.StatusRegister, this.status);
    }

    public String getStatus() {
        return status;
    }

    public void setUnspecial(String unspecial) {
        this.unspecial = unspecial;
    }

    public String getUnspecial() {
        return unspecial;
    }

    public void setSppspc(String sppspc) {
        this.sppspc = sppspc;
    }

    public String getSppspc() {
        return sppspc;
    }

    public void setAgainstcode(String againstcode) {
        this.againstcode = againstcode;
    }

    public String getAgainstcode() {
        return againstcode;
    }

    public void setStrmdeciid(String strmdeciid) {
        this.strmdeciid = strmdeciid;
    }

    public String getStrmdeciid() {
        return strmdeciid;
    }

    public void setTransfer(String transfer) {
        this.transfer = transfer;
    }

    public String getTransfer() {
        return transfer;
    }

    public void setTransferout(String transferout) {
        this.transferout = transferout;
    }

    public String getTransferout() {
        return transferout;
    }

    public void setStatusreason(String statusreason) {
        this.statusreason = statusreason;
    }

    public String getStatusreason() {
        return statusreason;
    }

    public void setAccucode(String accucode) {
        this.accucode = accucode;
    }

    public String getAccucode() {
        return accucode;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setUserforname(String userforname) {
        this.userforname = userforname;
    }

    public String getUserforname() {
        return userforname;
    }

    public void setSppname(String name) {
        this.sppname = name;
    }

    public String getSppname() {
        return sppname;
    }

    public void setLawcode(String lawcode) {
        this.lawcode = lawcode;
    }

    public String getLawcode() {
        return lawcode;
    }

    public void setCasetype(String casetype) {
        this.casetype = casetype;
    }

    public String getCasetype() {
        return casetype;
    }

    public void setAppecode(String appecode) {
        this.appecode = appecode;
    }

    public String getAppecode() {
        return appecode;
    }

    public void setBegin_setnum(String begin_setnum) {
        this.begin_setnum = begin_setnum;
    }

    public String getBegin_setnum() {
        return begin_setnum;
    }

    public void setStatusname(String statusname) {
        this.statusname = statusname;
    }

    public String getStatusname() {
        return statusname;
    }

    public void setUpdnum(String updnum) {
        this.updnum = updnum;
    }

    public String getUpdnum() {
        return updnum;
    }

    public void setRegiclosed(String regiclosed) {
        this.regiclosed = regiclosed;
    }

    public String getRegiclosed() {
        return regiclosed;
    }


    public void setEditable(String editable) {
        this.editable = editable;
    }

    public String getEditable() {
        return editable == null ? "N" : editable;
    }

//    public void setCheckhasregi(boolean checkhasregi) {
//        this.checkhasregi = checkhasregi;
    //}
    public void setCheckhasregi(String checkhasregi) {
        this.checkhasregi = Utils.toBoolean(checkhasregi);
    }

    public boolean isCheckhasregi() {
        return checkhasregi;
    }


    public void setSpcsetnum(String spcsetnum) {
        this.spcsetnum = spcsetnum;
    }

    public String getSpcsetnum() {
        return spcsetnum;
    }

    public void setSpcindate(Date spcindate) {
        this.spcindate = spcindate;
    }

    public Date getSpcindate() {
        return spcindate;
    }

//    public void setSpecial(boolean special) {
//        this.special = special;
//    }
    public void setSpecial(String special) {
        this.special = Utils.toBoolean(special);
    }

    public boolean isSpecial() {
        return special;
    }

//    public void setLawyer(boolean lawyer) {
//        this.lawyer = lawyer;
//    }
    public void setLawyer(String lawyer) {
        this.lawyer = Utils.toBoolean(lawyer);
    }

    public boolean isLawyer() {
        return lawyer;
    }

//    public void setBcvnd(boolean bcvnd) {
//        this.bcvnd = bcvnd;
//    }
    public void setBcvnd(String bcvnd) {
        this.bcvnd = Utils.toBoolean(bcvnd);
    }

    public boolean isBcvnd() {
        return bcvnd;
    }

//    public void setTgvpl(boolean tgvpl) {
//        this.tgvpl = tgvpl;
//    }
    public void setTgvpl(String tgvpl) {
        this.tgvpl = Utils.toBoolean(tgvpl);
    }

    public boolean isTgvpl() {
        return tgvpl;
    }

    public void setBregicodetha(String bregicodetha) {
        this.bregicodetha = bregicodetha;
    }

    public String getBregicodetha() {
        return bregicodetha;
    }
}
