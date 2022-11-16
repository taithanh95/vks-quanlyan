package com.bitsco.vks.models;

import java.io.Serializable;

public class LstReligionRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private String id;
    private String name;
    private String note;

    private String action;
    private String religionid;
    private String religionname;
    private String religionnote;

    public LstReligionRequest() {
    }

    public String getSortField() {
        return sortField;
    }

    public void setSortField(String sortField) {
        this.sortField = sortField;
    }

    public String getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(String sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getReligionid() {
        return religionid;
    }

    public void setReligionid(String religionid) {
        this.religionid = religionid;
    }

    public String getReligionname() {
        return religionname;
    }

    public void setReligionname(String religionname) {
        this.religionname = religionname;
    }

    public String getReligionnote() {
        return religionnote;
    }

    public void setReligionnote(String religionnote) {
        this.religionnote = religionnote;
    }
}
