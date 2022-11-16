package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppStaticcBegin;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProcessStaticcBeginRequest implements Serializable {
    public String casecode;
    public String lawcode;
    public List<SppStaticcBegin> lstStaticcBegin;
}
