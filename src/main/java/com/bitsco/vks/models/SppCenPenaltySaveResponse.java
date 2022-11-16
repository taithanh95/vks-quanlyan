package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppCenPenaltySaveResponse extends BaseListRequest{
    public SppCenPenaltySaveResponse(){super();}
    public String warning;
    public String result;
}
