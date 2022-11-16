package com.bitsco.vks.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LstInspectorSearchRequest  extends BaseListRequest {
    public String casecode;
    public String usefor;
    public String sppid;
    public String regicode;
    public String name;
    public String fullname;
    public String status;
    public String inspcode;
    public String position;
    public String currentsppid;
    public int  rowIndex;
    public int pageSize;
}
