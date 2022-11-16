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
@Table(name = "denounce_investigation_activity", schema = "spp_report")
public class InvestigationActivity implements Recordable {

    @Id
    @Column(name = "investigation_activity_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "investigation_activity_id_gen")
    @SequenceGenerator(name = "investigation_activity_id_gen", sequenceName = "investigation_activity_id_seq", schema = "spp_report", allocationSize = 1)
    private Long id;

    @Column(name = "investigation_activity_type")
    private String investigationActivityType;

    @Column(name = "procuracy_participated")
    private Boolean procuracyParticipated;

    @Column(name = "execution_date")
    private Date executionDate;

    @Column(name = "investigator")
    private String investigator;

    @Column(name = "participated_procurator")
    private String participatedProcurator;

    @Column(name = "participated_procurator_id")
    private String participatedProcuratorId;

    @Column(name = "reason_for_not_participating")
    private String reasonForNotParticipating;

    @Column(name = "assessment")
    private String assessment;

    @Column(name = "result")
    private String result;

    @Column(name = "process_type")
    private String processType;

    @Column(name = "note")
    private String note;

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
