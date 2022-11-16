package com.bitsco.vks.dto;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 1:33 PM
 */
@Data
public class LstLawPenaltyDTO {
    private Long ROWCOUNT;
    private Integer RNUM;
    private String LAWCODE;
    private String LAWID;
    private String ITEM;
    private String POINT;
    private String LAWNAME;
    private String LAWNAMECUT;
    private Date LAWDATE;
    private String LAWTYPE;
    private int FROMAMOUNT;
    private int TOAMOUNT;
    private String CODEID;
    private String CODENAME;
    private String GROUPID;
    private String GROUPNAME;
    private String PENALTYID;
    private String PENALTYNAME;
}
