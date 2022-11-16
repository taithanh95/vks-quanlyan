package com.bitsco.vks.dto;

import com.bitsco.vks.entity.SppRegister;

import java.io.Serializable;
import java.util.Date;

public class SppRegisterSearchDTO extends SppRegister {
    public SppRegisterSearchDTO() {
        super();
    }

    private Integer rowcount;
    private Integer rnum;

    public Integer getRowcount() {
        return rowcount;
    }

    public void setRowcount(Integer rowcount) {
        this.rowcount = rowcount;
    }

    public Integer getRnum() {
        return rnum;
    }

    public void setRnum(Integer rnum) {
        this.rnum = rnum;
    }

}
