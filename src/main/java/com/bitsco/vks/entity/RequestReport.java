package com.bitsco.vks.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 29/12/2021
 * Time: 1:36 PM
 */
@Getter
@Setter
public class RequestReport {
    private Long requestReportId;
    private Date period;
    private String sppId;
    private String sppName;
    private String stage;
    private String statisticalViolation;
    private String tieuChiMot;
    private String tieuChiHai;
    private String status;
    private String note;
    private String reportCode;
    private Date createdAt;
    private String createdBy;
    private Date updatedAt;
    private String updatedBy;
    private String option;
    private Integer pageIndex;
    private Integer pageSize;
    private Integer rowCount;
}
