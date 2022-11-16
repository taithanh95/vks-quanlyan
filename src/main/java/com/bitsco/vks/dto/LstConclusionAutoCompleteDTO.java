package com.bitsco.vks.dto;

import java.io.Serializable;

public class LstConclusionAutoCompleteDTO implements Serializable {
    private String concid;
    private String concname;

    public LstConclusionAutoCompleteDTO() { }

    public String getConcid() { return concid; }

    public void setConcid(String concid) { this.concid = concid; }

    public String getConcname() { return concname; }

    public void setConcname(String concname) { this.concname = concname; }
}
