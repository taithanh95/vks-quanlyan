package com.bitsco.vks.entity;

import com.bitsco.vks.utils.Utils;

public class LstSPP {
    public LstSPP() {
        super();
    }

    private String sppid;
    private String name;
    private String addr;
    private String tel;
    private String fax;
    private String director;
    private String position;
    private int spplevel;
    private String sppparent;
    private String sppcode;
    private String ordercode;
    private String newsppid;
    private String spcid;
    private String polid;
    private String spcname;
    private LstSPC atxtspc;
    private String locaid;
    private boolean isdepart;
    private String sppidfox;

    public void setLocaid(String locaid) {
        this.locaid = locaid;
    }

    public String getLocaid() {
        return locaid == null ? locaid : locaid.trim();
    }

    public void setSppid(String sppid) {
        this.sppid = sppid;
    }

    public String getSppid() {
        return sppid == null ? sppid : sppid.trim();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name == null ? name : name.trim();
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

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPosition() {
        return position == null ? position : position.trim();
    }

    public void setSpplevel(int spplevel) {
        this.spplevel = spplevel;
    }

    public int getSpplevel() {
        return spplevel;
    }

    public String toString() {
        if (sppid != null)
            return this.sppid + " - " + this.name;
        else
            return "";
    }

    public void setSppparent(String sppparent) {
        this.sppparent = sppparent;
    }

    public String getSppparent() {
        return sppparent;
    }

    public void setSppcode(String sppcode) {
        this.sppcode = sppcode;
    }

    public String getSppcode() {
        return sppcode;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setNewsppid(String newsppid) {
        this.newsppid = newsppid;
    }

    public String getNewsppid() {
        return newsppid;
    }

    public void setSpcid(String spcid) {
        this.spcid = spcid;
    }

    public String getSpcid() {
        return spcid;
    }

    public void setSpcname(String spcname) {
        this.spcname = spcname;
    }

    public String getSpcname() {
        return spcname;
    }

    public void setAtxtspc(LstSPC atxtspc) {
        this.atxtspc = atxtspc;
    }

    public LstSPC getAtxtspc() {
        return atxtspc;
    }

    public void setPolid(String polid) {
        this.polid = polid;
    }

    public String getPolid() {
        return polid;
    }

    public void setIsdepart(String isdepart) {
        this.isdepart = Utils.toBoolean(isdepart);
    }

    public boolean getIsdepart() {
        return isdepart;
    }

    public void setSppidfox(String sppidfox) {
        this.sppidfox = sppidfox;
    }

    public String getSppidfox() {
        return sppidfox;
    }

    /* @Override
    public void readExternal(PofReader pofReader) throws IOException {
        int i = 0;
        this.setSppid(pofReader.readString(i++));
        this.setName(pofReader.readString(i++));
        this.setIsdepart(pofReader.readBoolean(i++));
        this.setSppparent(pofReader.readString(i++));
        this.setLocaid(pofReader.readString(i++));
        this.setSpcid(pofReader.readString(i++));
        this.setSpplevel(pofReader.readInt(i++));
        this.setOrdercode(pofReader.readString(i++));
        this.setAddr(pofReader.readString(i++));
        this.setTel(pofReader.readString(i++));
        this.setFax(pofReader.readString(i++));
    }

    @Override
    public void writeExternal(PofWriter pofWriter) throws IOException {
        int i = 0;
        pofWriter.writeString(i++, this.getSppid());
        pofWriter.writeString(i++, this.getName());
        pofWriter.writeBoolean(i++, this.getIsdepart());
        pofWriter.writeString(i++, this.getSppparent());
        pofWriter.writeString(i++, this.getLocaid());
        pofWriter.writeString(i++, this.getSpcid());
        pofWriter.writeInt(i++, this.getSpplevel());
        pofWriter.writeString(i++, this.getOrdercode());
        pofWriter.writeString(i++, this.getAddr());
        pofWriter.writeString(i++, this.getTel());
        pofWriter.writeString(i++, this.getFax());
    } */
}
