package com.bitsco.vks.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedAttributeNode;
import javax.persistence.NamedEntityGraph;
import javax.persistence.NamedEntityGraphs;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "status = 1")
@Table(name = "denounce_denouncement", schema = "spp_report")
@NamedEntityGraphs({
    @NamedEntityGraph(name = "denouncement.fetchNone"),
    @NamedEntityGraph(name = "denouncement.fetchDenouncedPeople", attributeNodes = {
        @NamedAttributeNode("denouncedPeople")
    }),
    @NamedEntityGraph(name = "denouncement.fetchInvestigationActivities", attributeNodes = {
        @NamedAttributeNode("investigationActivities")
    }),
    @NamedEntityGraph(name = "denouncement.fetchSettlementDecisions", attributeNodes = {
        @NamedAttributeNode("settlementDecisions")
    }),
    @NamedEntityGraph(name = "denouncement.fetchVerificationInvestigations", attributeNodes = {
        @NamedAttributeNode("verificationInvestigations")
    })
})
public class Denouncement implements Recordable {

    @Id
    @Column(name = "denouncement_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "denouncement_id_gen")
    @SequenceGenerator(name = "denouncement_id_gen", sequenceName = "denouncement_id_seq", schema = "spp_report", allocationSize = 1)
    private Long id;

    @Column(name = "denouncement_code")
    private Long denouncementCode;

    @Column(name = "taken_over_agency_code")
    private String takenOverAgencyCode;

    @Column(name = "taken_over_date")
    private Date takenOverDate;

    @Column(name = "settlement_term")
    private Date settlementTerm;

    @Column(name = "crime_report_source")
    private String crimeReportSource;

    @Column(name = "complicated_circumstance")
    private Boolean complicatedCircumstance;

    @Column(name = "taken_over_officer")
    private String takenOverOfficer;

    @Column(name = "officer_position")
    private String officerPosition;

    @Column(name = "ia_handling_unit_id")
    private String iaHandlingUnitId;

    @Column(name = "ia_handling_unit")
    private String iaHandlingUnit;

    @Column(name = "ia_handling_officer")
    private String iaHandlingOfficer;

    @Column(name = "ia_assignment_decision_number")
    private String iaAssignmentDecisionNumber;

    @Column(name = "ia_assignment_date")
    private Date iaAssignmentDate;

    @Column(name = "p_handling_date")
    private Date pHandlingDate;

    @Column(name = "p_handling_prosecutor")
    private String pHandlingProsecutor;

    @Column(name = "p_handling_prosecutor_id")
    private String pHandlingProsecutorId;

    @Column(name = "p_assignment_decision_number")
    private String pAssignmentDecisionNumber;

    @Column(name = "p_assignment_date")
    private Date pAssignmentDate;

    @Column(name = "r_reporter")
    private String rReporter;

    @Column(name = "r_date_of_birth")
    private Date rDateOfBirth;

    @Column(name = "r_year_of_birth")
    private Integer rYearOfBirth;

    @Column(name = "r_address")
    private String rAddress;

    @Column(name = "r_phone_number")
    private String rPhoneNumber;

    @Column(name = "r_delation")
    private String rDelation;

    @Column(name = "r_note")
    private String rNote;

    @Column(name = "ipn_settlement_agency")
    private String ipnSettlementAgency;

    @Column(name = "ipn_settlement_unit")
    private String ipnSettlementUnit;

    @Column(name = "ipn_settlement_unit_id")
    private String ipnSettlementUnitId;

    @Column(name = "ipn_classified_news")
    private String ipnClassifiedNews;

    @Column(name = "ipn_enactment")
    private String ipnEnactment;

    @Column(name = "ipn_enactment_id")
    private String ipnEnactmentId;

    @Column(name = "ipn_law_clause")
    private String ipnLawClause;

    @Column(name = "ipn_law_point")
    private String ipnLawPoint;

    @Column(name = "fn_code")
    private String fnCode;

    @Column(name = "fn_date")
    private Date fnDate;

    @Column(name = "fn_note")
    private String fnNote;

    @Column(name = "fn_taken_over_agency")
    private Integer fnTakenOverAgency;

    @Column(name = "fn_taken_over_unit")
    private String fnTakenOverUnit;

    @Column(name = "create_user")
    private String createUser;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "update_user")
    private String updateUser;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "status")
    private Integer status;

    @Column(name = "settlement_status")
    private Integer settlementStatus;

    @Column(name = "sppid")
    private String sppId;

    @Column(name = "share_info_level")
    private Integer shareInfoLevel;

    @Column(name = "CORRUPTION_CRIME")
    private Boolean corruptionCrime;

    @Column(name = "ECONOMIC_CRIME")
    private Boolean economicCrime;

    @Column(name = "OTHER_CRIME")
    private Boolean otherCrime;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "denouncement_id", referencedColumnName = "denouncement_id")
    private List<DenouncedPerson> denouncedPeople;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "denouncement_id", referencedColumnName = "denouncement_id")
    private List<InvestigationActivity> investigationActivities;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "denouncement_id", referencedColumnName = "denouncement_id")
    @OrderBy("executeOrder")
    private List<SettlementDecision> settlementDecisions;

//    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @JoinColumn(name = "denouncement_id", referencedColumnName = "denouncement_id")
    private List<VerificationInvestigation> verificationInvestigations;

}
