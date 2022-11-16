package com.bitsco.vks.entity;

public class LstLocation {
    private String locaid;
    private String name;
    private String remark;
    private String stdcode;
    private String status;
    private String statusname;
    private String domain;
    private String domain_txt;
    private String locacode;
    private String localevel;
    private String locaparent;
    private String ordercode;
    private String l1name;
    private String l2name;
    private String newlocaid;


    public LstLocation() {
        this.setStatus("Y");
    }

    public String getLocaid() {
        return locaid;
    }

    public void setLocaid(String value) {
        locaid = value;
    }

    public String getName() {
        return name == null ? name : name.trim();
    }

    public void setName(String value) {
        name = value;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String value) {
        remark = value;
    }

    public String getStdcode() {
        return stdcode;
    }

    public void setStdcode(String value) {
        stdcode = value;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String value) {
        status = value;
        //this.statusname = Utils.getTextFromBundle(null, Constants.CATEGORIES.YesNo, this.status);
    }

    public String getStatusname() {
        return statusname;
    }

//    public Map<String, String> getListOfStatus() {
//        return Utils.getCategoryFromBundle(null, Constants.CATEGORIES.YesNo);
//    }

    public String getDomain() {
        return this.domain == null ? domain : domain.trim();

    }

    public void setDomain(String domain) {
        this.domain = domain;
//        if (!Utils.StringIsNullOrEmpty(domain))
//            this.domain_txt =
//                    Messages.getMessage(Constants.BUNDLE_QLA, "constants.categories.option-domain." + domain +
//                            ".text");
    }

    public String getDomain_txt() {
        return domain_txt;
    }


    public void setLocalevel(String level) {
        this.localevel = level;
    }

    public String getLocalevel() {
        return localevel;
    }

    public void setLocaparent(String parent) {
        this.locaparent = parent;
    }

    public String getLocaparent() {
        return locaparent;
    }

    public void setOrdercode(String ordercode) {
        this.ordercode = ordercode;
    }

    public String getOrdercode() {
        return ordercode;
    }

    public void setLocacode(String locacode) {
        this.locacode = locacode;
    }

    public String getLocacode() {
        return locacode;
    }


    public void setL1name(String l1name) {
        this.l1name = l1name;
    }

    public String getL1name() {
        return l1name;
    }

    public void setL2name(String l2name) {
        this.l2name = l2name;
    }

    public String getL2name() {
        return l2name;
    }

    public String toString() {
        if (locaid != null)
            return this.locaid + " - " + this.remark;
        else
            return "";
    }

    public void setNewlocaid(String newlocaid) {
        this.newlocaid = newlocaid;
    }

    public String getNewlocaid() {
        return newlocaid;
    }
}
