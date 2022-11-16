package com.bitsco.vks.models;

public class LstLawSearch1Request {
    private String sortField;
    private String sortOrder;
    private String LawId;
    private String Item;
    private String Point;
    private String LawName;
    private String GroupId;
    private String CodeId;

    public LstLawSearch1Request() {
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

    public String getLawId() {
        return LawId;
    }

    public void setLawId(String lawId) {
        LawId = lawId;
    }

    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }

    public String getPoint() {
        return Point;
    }

    public void setPoint(String point) {
        Point = point;
    }

    public String getLawName() {
        return LawName;
    }

    public void setLawName(String lawName) {
        LawName = lawName;
    }

    public String getGroupId() {
        return GroupId;
    }

    public void setGroupId(String groupId) {
        GroupId = groupId;
    }

    public String getCodeId() {
        return CodeId;
    }

    public void setCodeId(String codeId) {
        CodeId = codeId;
    }
}
