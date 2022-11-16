package com.bitsco.vks.dto;

import java.util.Date;
import javax.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApParamDTO {

    private Long id;

    private String paramCode;

    private String paramName;

    private String paramValue;

    private String createUser;

    private Date createDate;

    private String updateUser;

    private Date updateDate;

    private Integer status;

}
