package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstLaw;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SppCaseLawSearchRequest extends BaseListRequest{
    public LstLaw law;
    public String casecode;
    public int pageindex;
    public int pagesize;
}
