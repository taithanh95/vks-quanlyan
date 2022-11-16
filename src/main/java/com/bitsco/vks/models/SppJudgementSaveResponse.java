package com.bitsco.vks.models;

import lombok.Data;

@Data
public class SppJudgementSaveResponse extends BaseListRequest{
    public SppJudgementSaveResponse(){super();}
    public String warning;
    public String result;
}
