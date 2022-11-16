package com.bitsco.vks.entity;

public class LstPrison {
    private String prisonid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String ptype;
    private String sppid;
    private String sppname;
    private LstSPP selectedspp;

    private String action;

    public void setPrisonid(String prisonid) {
        this.prisonid = prisonid;
    }

    public String getPrisonid() {
        return prisonid == null ? prisonid : prisonid.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? name : name.trim() ;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr == null ? addr : addr.trim();
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel == null ? tel : tel.trim();
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax == null ? fax : fax.trim();
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    public String getPtype() {
        return ptype;
    }
    public String getAction() {
        return action;
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

    public void setSelectedspp(LstSPP selectedspp) {
        this.selectedspp = selectedspp;
    }

    public LstSPP getSelectedspp() {
        return selectedspp;
    }
}
