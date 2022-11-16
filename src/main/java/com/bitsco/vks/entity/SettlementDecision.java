package com.bitsco.vks.entity;

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
import org.hibernate.annotations.Where;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause="status=1")
@Table(name = "denounce_settlement_decision", schema = "spp_report")
public class SettlementDecision implements Recordable {

    @Id
    @Column(name = "settlement_decision_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "settlement_decision_id_gen")
    @SequenceGenerator(name = "settlement_decision_id_gen", sequenceName = "settlement_decision_id_seq", schema = "spp_report", allocationSize = 1)
    private Long id;

    @Column(name = "decision_number")
    private String decisionNumber;

    @Column(name = "decision_id")
    private String decisionId;

    @Column(name = "decision_name")
    private String decisionName;

    @Column(name = "description")
    private String description;

    @Column(name = "decision_date")
    private Date decisionDate;

    @Column(name = "decision_making_agency")
    private String decisionMakingAgency;

    @Column(name = "decision_making_unit_id")
    private String decisionMakingUnitId;

    @Column(name = "decision_making_unit")
    private String decisionMakingUnit;

    @Column(name = "effect_start_date")
    private Date effectStartDate;

    @Column(name = "effect_end_date")
    private Date effectEndDate;

    @Column(name = "signer")
    private String signer;

    @Column(name = "position")
    private String position;

    @Column(name = "execute_order")
    private Long executeOrder;

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

    @Column(name = "denouncement_id")
    private Long denouncementId;

}
