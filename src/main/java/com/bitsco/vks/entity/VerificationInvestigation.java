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
@Table(name = "denounce_verification_investigation", schema = "spp_report")
public class VerificationInvestigation implements Recordable {

    @Id
    @Column(name = "verification_investigation_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "verification_investigation_id_gen")
    @SequenceGenerator(name = "verification_investigation_id_gen", sequenceName = "verification_investigation_id_seq", schema = "spp_report", allocationSize = 1)
    private Long id;

    @Column(name = "verification_investigation_code")
    private String verificationInvestigationCode;

    @Column(name = "verification_date")
    private Date verificationDate;

    @Column(name = "procurators_request")
    private String procuratorsRequest;

    @Column(name = "procurators_request_id")
    private String procuratorsRequestId;

    @Column(name = "content_request")
    private String contentRequest;

    @Column(name = "result")
    private String result;

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
