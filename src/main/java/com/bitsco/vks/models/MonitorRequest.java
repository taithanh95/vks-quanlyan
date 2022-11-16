package com.bitsco.vks.models;

import com.bitsco.vks.utils.ArrayListCommon;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/07/2022
 * Time: 1:55 PM
 */
@Data
public class MonitorRequest implements Serializable {
    private String sortField;
    private String sortOrder;
    private int pageSize;
    private int pageIndex;

    // Thụ lý
    private Date fdateRegister;
    private Date tdateRegister;
    private String usefor;
    private String sppid;
    private Boolean underlevel;
    private Date flagdate;
    private Boolean special;
    private Boolean lawyer;
    private Boolean movement;
    private String typeregister;
    private String inspcode;
    private List<String> sppidList;

    public String getSppIdList() {
        if (ArrayListCommon.isNullOrEmpty(sppidList))
            return null;
        else {
            String rs = sppidList.get(0);
            if (sppidList.size() > 1)
                for (int i = 1; i < sppidList.size(); i++) {
                    rs += ";" + sppidList.get(i);
                }
            return rs;
        }
    }

    // Vụ án
    private Date regfdate;
    private Date regtdate;
    private String typecase;
    private String codeid;
    private String lawcode;
    private String groupcase;

    // Điều luật
    private Date fdateLaw;
    private Date tdateLaw;
    private String lawid;
    private Boolean booCorrup;

    // Bị can, bị cáo
    private Date fdateAccused;
    private Date tdateAccused;

    //Bàn giao
    private Date fdateTransfer;
    private Date tdateTransfer;
    private String type;
    private String sppidfTransfer;
    private String sppidtTransfer;

    //Kiểm tra dữ liệu
    private Date fdateVerify;
    private Date tdateVerify;
    private String verifyId;

    // Hình phạt
    private Date fdatePenalty;
    private Date tdatePenalty;
    private String penaltyid;
    private Boolean suspended;

    // quyết định
    private Date fdateDecision;
    private Date tdateDecision;
    private Date utildate;
    private String deciid;
    private String reasonid;

    // Kháng nghị - Kháng cáo
    private Date fdateAgainsts;
    private Date tdateAgainsts;
    private Date fdateAppeals;
    private Date tdateAppeals;
}
