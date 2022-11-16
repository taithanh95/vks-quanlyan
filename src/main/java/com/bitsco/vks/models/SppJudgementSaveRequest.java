package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppPenalty;
import lombok.Data;

import java.util.List;

@Data
public class SppJudgementSaveRequest extends BaseListRequest{
    public String accucode;
    public String centcode;
    public List<SppPenalty> listSppPenalty;
    public boolean isCheckspppenal;
    public String action;
    public String regicode;
}
