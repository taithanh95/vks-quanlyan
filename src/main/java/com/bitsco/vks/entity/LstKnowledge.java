package com.bitsco.vks.entity;

public class LstKnowledge {
    public LstKnowledge(){
        super();
    }
    private String levelid;
    private String levelname;

    public void setLevelid(String levelid) {
        this.levelid = levelid;
    }

    public String getLevelid() {
        return levelid;
    }

    public void setLevelname(String levelname) {
        this.levelname = levelname;
    }

    public String getLevelname() {
        return levelname;
    }


    public String toString() {
        if (levelid == null)
            return "";
        else
            return levelid + " - " + levelname;
    }
}
