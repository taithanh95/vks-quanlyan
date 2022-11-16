package com.bitsco.vks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SppJoinSearchRequest extends BaseListRequest{
    private int rowIndex;
    private int pageSize;
    private String sppid;
    private String choice;
    private String casecode;
    private String casename;
    private String begin_setnum;
    private Date fromdate;
    private Date todate;
    private Date crimdatef;
    private Date crimdatet;
}
