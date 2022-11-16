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
public class InvestigationActivityDTO {

    private Long id;

    @NotBlank(message = "Hoạt động điều tra là bắt buộc")
    private String investigationActivityType;

    private Boolean procuracyParticipated;

    private Date executionDate;

    private String investigator;

    private String participatedProcurator;

    private String participatedProcuratorId;

    private String reasonForNotParticipating;

    private String assessment;

    private String result;

//    @NotNull(message = "Xử lý báo là bắt buộc")
//    private String processType;

    private String note;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private Long denouncementId;
}
