package com.bitsco.vks.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplineViolationDTO {

    private Long id;

    private Date violationDate;

    private Long arresteeId;

    private String punishmentType;

    private String violationContent;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;
}
