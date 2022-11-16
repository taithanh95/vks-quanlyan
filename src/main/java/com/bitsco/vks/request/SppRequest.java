package com.bitsco.vks.request;

import java.io.Serializable;

public class SppRequest implements Serializable {
    private String sppId;
    private boolean isdepart;

    public String getSppId() {
        return sppId;
    }

    public void setSppId(String sppId) {
        this.sppId = sppId;
    }

    public boolean isIsdepart() {
        return isdepart;
    }

    public void setIsdepart(boolean isdepart) {
        this.isdepart = isdepart;
    }
}
