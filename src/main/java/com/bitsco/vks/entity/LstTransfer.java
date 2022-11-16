package com.bitsco.vks.entity;

public class LstTransfer {
    public LstTransfer() {
        super();
    }
    private String transid;
    private String transname;
    private String fromto;
    private String fromToName;

    public void setTransid(String transid) {
        this.transid = transid;
    }

    public String getTransid() {
        return transid;
    }

    public void setTransname(String transname) {
        this.transname = transname;
    }

    public String getTransname() {
        return transname == null ? transname : transname.trim();
    }

//    public void setFromto(String fromto) {
//        this.fromto = fromto;
//        this.fromToName = Utils.getTextFromBundle(Constants.BUNDLE_QLA, Constants.CATEGORIES.FromTo, this.fromto);
//    }

    public String getFromto() {
        return fromto;
    }

    public void setFromToName(String fromToName) {
        this.fromToName = fromToName;
    }

    public String getFromToName() {
        return fromToName;
    }
}
