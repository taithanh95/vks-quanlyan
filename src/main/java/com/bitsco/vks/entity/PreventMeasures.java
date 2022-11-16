package com.bitsco.vks.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 4:42 PM
 */
@Getter
@Setter
public class PreventMeasures {
    private Long measuresId;
    private String measuresName;
    private Date measuresDate;
    private String reason;
    private String accucode;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    private String option;
}
