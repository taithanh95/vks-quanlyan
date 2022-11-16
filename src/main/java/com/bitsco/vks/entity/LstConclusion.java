package com.bitsco.vks.entity;

public class LstConclusion {
    private String concid;
    private String concname;
    private String userfor;
    private String userforname;
    private String status;
    private String statusname;
    private String id;

    public LstConclusion() {
        super();
    }

    public void setConcid(String concid) {
        this.concid = concid;
    }

    public String getConcid() {
        return concid == null ? concid : concid.trim();
    }

    public void setConcname(String concname) {
        this.concname = concname;
    }

    public String getConcname() {
        return concname == null ? concname : concname.trim();
    }

    public void setUserfor(String userfor) {
        this.userfor = userfor;
    }

    public String getUserfor() {
        return userfor == null ? userfor : userfor.trim();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status == null ? status : status.trim();
    }

    public String getStatusname() {
//        this.statusname = Utils.getTextFromBundle(null, Constants.CATEGORIES.YesNo, this.status);
        return this.statusname;
    }

    public String getUserforname() {
//        this.userforname = Utils.getTextFromBundle(null, Constants.CATEGORIES.UseFor, this.userfor);
        return this.userforname;
    }



    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        //  this.id = this.type + this.concid;
        return id;
    }
}
