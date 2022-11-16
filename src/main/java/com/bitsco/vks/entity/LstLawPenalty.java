package com.bitsco.vks.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 17/05/2022
 * Time: 1:30 PM
 */
@Data
public class LstLawPenalty {
    private String action;
    private String lawcode;
    private String penaltyid;
    private int fromamount;
    private int toamount;
    private String lawid;
    private String item;
    private String point;
    private String groupid;
    private String groupname;
    private String codeid;
    private String codename;
    private String lawname;
    private String lawnamecut;
    private String penaltyname;
    private Date lawdate;
    private String lawtype;
    private String lawtypename;
}
