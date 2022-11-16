package com.bitsco.vks.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class LstAgainstResultSearchDTO implements Serializable {
    private Long rowcount;
    private Integer rnum;
    private String crtdate;
    private String crtuser;
    private String mdfdate;
    private String mdfuser;

    private String resultid;
    private String resultname;
}
