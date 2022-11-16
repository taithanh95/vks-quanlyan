package com.bitsco.vks.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({
    "sppid", "phandlingDate", "phandlingProsecutor", "passignmentDecisionNumber", "passignmentDate", "phandlingProsecutorId",
    "rreporter", "rdateOfBirth", "ryearOfBirth", "raddress", "rphoneNumber", "rdelation", "rnote"
})
public class DenouncementDTO {

    private Long id;

    private Long denouncementCode;

    private String takenOverAgencyCode;

    @NotNull(message = "Ngày VKS tiếp nhận là bắt buộc")
    private Date takenOverDate;

    @NotNull(message = "Thời hạn giải quyết là bắt buộc")
    private Date settlementTerm;

    @NotBlank(message = "Loại tin báo là bắt buộc")
    private String crimeReportSource;

    private Boolean complicatedCircumstance;

    private String takenOverOfficer;

    private String officerPosition;

    private String iaHandlingUnitId;

    private String iaHandlingUnit;

    private String iaHandlingOfficer;

    private String iaAssignmentDecisionNumber;

    private Date iaAssignmentDate;

    @JsonProperty
    private Date pHandlingDate;

    @JsonProperty
    private String pHandlingProsecutor;

    @JsonProperty
    private String pHandlingProsecutorId;

    @JsonProperty
    private String pAssignmentDecisionNumber;

    @JsonProperty
    private Date pAssignmentDate;

    @JsonProperty
    private String rReporter;

    @JsonProperty
    private Date rDateOfBirth;

    @JsonProperty
    private Integer rYearOfBirth;

    @JsonProperty
    private String rAddress;

    @JsonProperty
    private String rPhoneNumber;

    @JsonProperty
    @NotBlank(message = "Nội dung tố giác không được bỏ trống")
    private String rDelation;

    @JsonProperty
    private String rNote;

    private String ipnSettlementAgency;

    private String ipnSettlementUnit;

    private String ipnSettlementUnitId;

    @NotBlank(message = "Phân loại tin là bắt buộc")
    private String ipnClassifiedNews;

    private String ipnEnactment;

    private String ipnEnactmentId;

    private String ipnLawClause;

    private String ipnLawPoint;

    private String fnCode;

    private Date fnDate;

    private String fnNote;

    private Integer fnTakenOverAgency;

    private String fnTakenOverUnit;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

    private Integer settlementStatus;

    @JsonProperty
    private String sppId;

    private Integer shareInfoLevel;

    private List<@Valid DenouncedPersonDTO> denouncedPeople;

    private List<@Valid InvestigationActivityDTO> investigationActivities;

    private List<@Valid SettlementDecisionDTO> settlementDecisions;

    private List<@Valid VerificationInvestigationDTO> verificationInvestigations;

    private String nameAccused;

    private Date toDate;

    private Date fromDate;
    // list value loai tin bao
    private List<Long> listOfSelectedValue;
    // list value ket qua giai quyet
    private List<Long> lstSettlementResultsSelected;
    // list value trang thai
    private List<Long> lstDenouncementStatusSelected;
    //ng to cao hoac bi to cao
    private String delatorOrAccused;

    private String decisionName;

    private String statusValue;

    public interface Group {
        interface Create {}

        interface Update {}
    }
    private Long rownum;

    private String sortField;

    private Boolean corruptionCrime;

    private Boolean economicCrime;

    private Boolean otherCrime;
}
