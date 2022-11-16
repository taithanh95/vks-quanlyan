package com.bitsco.vks.entity;

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
@Table(name = "denounce_spp_share_info_lvl", schema = "spp_report")
public class DenouncementShareInfoLevel {

    @Id
    @Column(name = "sppid")
    private Long id;

    @Column(name = "default_share_info_lvl")
    private String defaultShareInfoLvl;

}
