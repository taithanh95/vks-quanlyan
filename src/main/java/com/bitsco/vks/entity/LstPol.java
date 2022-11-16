package com.bitsco.vks.entity;

public class LstPol {
    private String polid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;

    private String action;

    public void setPolid(String polId) {
        this.polid = polId;
    }

    public String getPolid() {
        return polid == null ? polid : polid.trim();
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

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director == null ? director : director.trim();
    }
    public String getAction() {
        return action;
    }
}
