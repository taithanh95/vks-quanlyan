package com.bitsco.vks.dto;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArrestSettlementDecisionDTO {

    private Long id;

    private Long arresteeId;

    private String decisionMakingAgency;

    private String decisionMakingUnitId;

    private String decisionMakingUnitName;

    private String decisionNumber;

    private String decisionId;

    private String decisionName;

    private Date decisionDate;

    private String reason;

    private Date effectStartDate;

    private Date effectEndDate;

    private String signer;

    private String singerPosition;

    private String note;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

}
