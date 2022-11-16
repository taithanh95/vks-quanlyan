package com.bitsco.vks.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SppDamagedResponse {
    private String damaCode;
    private String fullName;
    private String otherName;
    private Integer byear;
    private Integer bmonth;
    private Integer bdate;
    private Date birthDay;
    private String counId;
    private String natiId;
    private String sex;
    private String religion;
    private String identify;
    private String levelId;
    private String locaId;
    private String locaName;
    private String address;
    private String addrName;
    private String occuId;
    private String officeId;
    private String partyId;
    private Integer conviction;
    private Integer offence;
    private Boolean isDisabled;
    private Boolean isWanderer;
    private Boolean relationshipWithTheAccused;
    private Boolean isPregnant;
    private Boolean isSuicide;
    private String caseCode;
    private String regiCode;
    private Long Id;
}
