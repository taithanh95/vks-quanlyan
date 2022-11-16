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
public class SppAccadditioninfo {
    private Long id;
    private String accucode;
    //bo
    private String preventiveMeasures;
    private String preventiveMeasuresId;
    private Boolean dead;
    private Date deadDay;
    private Long causeOfDeath;
    private Boolean fled;
    private Date dayOfHiding;
    private String reasonForHiding;
    private Date recaptureDate;
    private Boolean moveToOtherPlace;
    private Date moveOutdate;
    private Boolean movedToAnotherPlace;
    private Date moveInDate;
    private String reason;

}
