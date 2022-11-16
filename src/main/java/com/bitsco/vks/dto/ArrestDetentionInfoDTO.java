package com.bitsco.vks.dto;

import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrestDetentionInfoDTO {

    private Long id;

    private Integer shareInfoLvl;

    private Integer code;

    private String arrestingUnitId;

    private String arrestingUnitName;

    private Date procuracyTakenOverDate;

    private String takenOverProsecutorId;

    private String takenOverProcuratorName;

    private String procuratorAssignmentDecisionNumber;

    private Date procuratorAssignmentDate;

    private String arrestContent;

    private String arrestEnactmentId;

    private String arrestEnactmentName;

    private String lawClauseId;

    private String lawClauseName;

    private String lawPointId;

    private String lawPointName;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private List<ArresteeDTO> arrestees;
}
