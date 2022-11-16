package com.bitsco.vks.entity;

public class LstSPC {
    private String spcid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String spclevel;
    private String spcparent;
    private String spccode;
    private String ordercode;
    private LstLocation location;
    private String newspcid;
    private String locaid;

    public LstSPC() {
        super();
    }


    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getTel() {
        return tel;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFax() {
        return fax;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDirector() {
        return director;
    }


    public void setSpclevel(String spclevel) {
        this.spclevel = spclevel;
    }

    public String getSpclevel() {
        return spclevel;
    }


//    public Map<String, String> getListOfIsworking() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.YesNo);
//    }


    public void setSpcparent(String spcparent) {
        this.spcparent = spcparent;
    }

    public String getSpcparent() {
        return spcparent;
    }

    public void setSpccode(String spccode) {
        this.spccode = spccode;
    }

    public String getSpccode() {
        return spccode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setLocation(LstLocation location) {
        this.location = location;
    }

    public LstLocation getLocation() {
        return location;
    }

    public String toString() {
        if (spcid != null)
            return this.spcid + " - " + this.name;
        else
            return "";
    }

    public void setNewspcid(String newspcid) {
        this.newspcid = newspcid;
    }

    public String getNewspcid() {
        return newspcid;
    }

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getLocaid() {
        return locaid;
    }
}
