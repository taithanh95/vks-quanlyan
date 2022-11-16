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
@Table(name = "denounce_denounced_person", schema = "spp_report")
public class DenouncedPerson implements Recordable {

    @Id
    @Column(name = "denounced_person_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "denounced_person_id_gen")
    @SequenceGenerator(name = "denounced_person_id_gen", sequenceName = "denouncement_id_seq", schema = "spp_report", allocationSize = 1)
    private Long id;

    @Column(name = "full_name")
    private String fullName;

    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @Column(name = "year_of_birth")
    private Integer yearOfBirth;

    @Column(name = "job")
    private String job;

    @Column(name = "workplace")
    private String workplace;

    @Column(name = "address")
    private String address;

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
