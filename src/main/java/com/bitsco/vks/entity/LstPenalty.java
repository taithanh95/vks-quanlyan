package com.bitsco.vks.entity;

import lombok.Data;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 16/05/2022
 * Time: 3:20 PM
 */
@Data
public class LstPenalty {
    private String action;
    private String penaltyid;
    private String penaltyname;
    private String nameOfPenaltyfor;
    private String nameOfPenaltytype;
    private String penaltyfor;
    private String status;
    private String penaltytype;
    private Integer monthmax;
    private Integer yearmax;
    private Integer daymax;
    /**
     * Các biến khai báo để load cột động Tra cứu thông tin Hình phạt
     * */
    private String casecode;
    private String casename;
    private String setnum;
    private Date actdate;
}
