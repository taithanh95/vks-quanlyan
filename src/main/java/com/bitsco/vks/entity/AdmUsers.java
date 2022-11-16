package com.bitsco.vks.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.sql.DataSource;
import java.util.Date;

public class AdmUsers {

    private String userid;
    private String password;
    private String inspcode;
    private boolean locked;
    private String lockedvalue; // dÃ¹ng Ä‘á»ƒ hiá»ƒn thá»‹ khi view detail
    private boolean expired;
    private String fullname;
    private Date expiredate;
    private String sppid;
    private String orgsppid;
    private String sppname; // dÃ¹ng Ä‘á»ƒ hiá»ƒn thá»‹ tÃªn VKS khi view detail
    private String groupid;
    private String groupnames; // dÃ¹ng Ä‘á»ƒ hiá»ƒn thá»‹ khi view detail
    private LstSPP atxtSppid; // chá»©a giÃ¡ trá»‹ cá»§a autocomplete textbox
    private boolean delothers = false;
    private String delothersname;
    private String departid;
    private String spplevel;
    // duclm8 add 14.04.2016
    private String spcid;
    private String spclevel;
    private boolean isdepart;
    private String crtuser;
    private String mdfuser;
    private Date crtdate;
    private Date mdfdate;

    public Date getMdfdate(){return  mdfdate;}
    public void setMdfdate(Date mdfdate){this.mdfdate = mdfdate;}

    public Date getCrtDate(){return  crtdate;}
    public void setCrtDate(Date crtDate){this.crtdate = crtDate;}

    public String getMdfuser(){return  mdfuser;}
    public void setMdfuser(String mdfuser){this.mdfuser = mdfuser;}

    public String getCrtuser() {return  crtuser;}
    public void setCrtuser(String crtuser){this.crtuser = crtuser;}

    public AdmUsers() {
        super();
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getUserid() {
        return userid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setExpiredate(Date expiredate) {
        this.expiredate = expiredate;
    }

    public Date getExpiredate() {
        return expiredate;
    }

    public void setSppname(String sppname) {
        this.sppname = sppname;
    }

    public String getSppname() {
        return sppname;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupnames(String groupnames) {
        this.groupnames = groupnames;
    }

    public String getGroupnames() {
        return groupnames;
    }

    public void setAtxtSppid(LstSPP atxtSppid) {
        this.atxtSppid = atxtSppid;
    }

    public LstSPP getAtxtSppid() {
        return atxtSppid;
    }

    public void setInspcode(String inspcode) {
        this.inspcode = inspcode;
    }

    public String getInspcode() {
        return inspcode;
    }

    public void setLocked(boolean locked) {
        this.locked = locked;
//        this.lockedvalue =
//                (locked ? Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.YesNo, "Y") : Utils.getTextFromBundle(Constants.BUNDLE_QLA,
//                        Constants.CATEGORIES.YesNo,
//                        "N"));
    }

    public boolean isLocked() {
        return locked;
    }

    public String getLockedvalue() {
        return lockedvalue;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setDelothers(boolean delothers) {
        this.delothers = delothers;
//        this.delothersname =
//                (delothers ? Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.YesNo, "Y") :
//                        Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.YesNo, "N"));
    }

    public boolean isDelothers() {
        return delothers;
    }

    public String getDelothersname() {
        return delothersname;
    }

    public void setDepartid(String departid) {
        this.departid = departid;
    }

    public String getDepartid() {
        return departid;
    }

    public void setSpplevel(String spplevel) {
        this.spplevel = spplevel;
    }

    public String getSpplevel() {
        return spplevel;
    }

    public void setOrgsppid(String orgsppid) {
        this.orgsppid = orgsppid;
    }

    public String getOrgsppid() {
        return orgsppid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setSpclevel(String spclevel) {
        this.spclevel = spclevel;
    }

    public String getSpclevel() {
        return spclevel;
    }

    public void setIsdepart(boolean isdepart) {
        this.isdepart = isdepart;
    }

    public boolean getIsdepart() {
        return isdepart;
    }
}
