package com.bitsco.vks.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SppViolantion {
    private Long id;
    private String caseCode;
    private String accuCode;
    private String violcode;
    private String typeName;
    private Date dateOfViolation;
    private Integer timeOfViolation;
    private String contentViolations;
    private String processing;
    private Integer typeOfViolations;
}
