package com.bitsco.vks.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 9:04 AM
 */
@Data
public class LstPenaltyDTO implements Serializable {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String PENALTYID;
    private String PENALTYNAME;
    private String PENALTYFOR;
    private String STATUS;
    private String CRTDATE;
    private String CRTUSER;
    private String MDFDATE;
    private String MDFUSER;
    private Integer YEARMAX;
    private Integer MONTHMAX;
    private Integer DAYMAX;
}
