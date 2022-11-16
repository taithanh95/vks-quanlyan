package com.bitsco.vks.models;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class SppStattisticaSaveRequest extends BaseListRequest{
    public String regicode;
    public String centcode;
    public String accucode;
    public String lawcode;
    public String Locaid;
    public Date crimdate;
    public String crimtime;
    public String userfor;
    public List<String> listStatistics;
}
