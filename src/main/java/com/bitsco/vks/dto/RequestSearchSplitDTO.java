package com.bitsco.vks.dto;

import com.bitsco.vks.models.BaseListRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestSearchSplitDTO extends BaseListRequest {

    private String temp;
    private String casecodeout;

    private String choicetype; // Loại tách vụ
    private String choice; // Trạng thái

    private String casecode; // Mã vụ án
    private String casename; // Tên vụ án

    private String accucode; // Mã bị can
    private String fullname; // Tên bị can

    private String sppid; // Đơn vị người tìm kiếm
    private String identify; // CMND

    private String atxtLocaid; // Nơi ĐKHKTT
    private String atxtAddressid; // Nơi cư trú
    private String atxtNatiid; // Dân tộc
    private String atxtCounid; // Quốc tịch
    private String atxtLevelid; // Trình độ học vấn

    // PAGE
    private int rowIndex;
    private int pageSize;

    // Date
    private Date crimdatef;
    private Date crimdatet;
}
