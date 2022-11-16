package com.bitsco.vks.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 11/05/2022
 * Time: 3:42 PM
 */
@Data
public class LstCodeDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String CODEID;
    private String CODENAME;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
}
