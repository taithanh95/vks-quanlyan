package com.bitsco.vks.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "LST_INSPECTOR")
public class _LstInspector {
    @Id
    @Column(name = "INSPCODE")
    private String inspCode;

    @Column(name = "SPPID")
    private String sppId;

    @Column(name = "FULLNAME")
    private String fullName;

    @Column(name = "ADDRESS")
    private String adddress;

    @Column(name = "TEL")
    private String tel;

    @Column(name = "JOBTITLE")
    private String jobTille;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "CRTDATE")
    private Date crtDate;

    @Column(name = "CRTUSER")
    private String crtUser;

    @Column(name = "MDFDATE")
    private Date mdfUser;

    @Column(name = "MDFUSER")
    private String mdfDate;

    @Column(name = "POSITION")
    private String position;

    @Column(name = "SYNC")
    private String sync;

}
