package com.bitsco.vks.dto;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LawOffenseDTO {

    private Long id;

    private String lawId;

    private Long arresteeId;

    private String lawName;

    private String enactmentId;

    private String enactmentName;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;
}
