package com.bitsco.vks.dto;

import java.util.Date;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SettlementDecisionDTO {

    private Long id;

    private String decisionNumber;

    @NotBlank(message = "Tên quyết định là bắt buộc")
    private String decisionId;

    @NotBlank(message = "Tên quyết định là bắt buộc")
    private String decisionName;

    private String description;

    @NotNull(message = "Ngày ra quyết định là bắt buộc")
    private Date decisionDate;

    private String decisionMakingAgency;

    @NotNull(message = "Đơn vị ra quyết định là bắt buộc")
    private String decisionMakingUnitId;

    @NotBlank(message = "Đơn vị ra quyết định là bắt buộc")
    private String decisionMakingUnit;

    @NotNull(message = "Ngày ra quyết định là bắt buộc")
    private Date effectStartDate;

    private Date effectEndDate;

    private String signer;

    private String position;

    @NotNull(message = "Thứ tự quyết định không được bỏ trống")
    private Long executeOrder;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private Long denouncementId;
}
