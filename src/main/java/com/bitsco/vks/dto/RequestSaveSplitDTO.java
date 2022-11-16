package com.bitsco.vks.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSaveSplitDTO implements Serializable {
    private String accucode1;
    private String accucode2;
    private String casecode1;
    private String casecode2;
    private Date splitdate;
    private String tvatype;
    private String choicetype;
}
