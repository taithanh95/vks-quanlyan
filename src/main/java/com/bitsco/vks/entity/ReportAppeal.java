package com.bitsco.vks.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 9:55 AM
 */
@Getter
@Setter
public class ReportAppeal {
    private Long reportAppealId;
    private Integer setnum;
    private Date indate;
    private String content;
    private Integer status;
    private String casecode;
    private String regicode;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    private String option;
}
