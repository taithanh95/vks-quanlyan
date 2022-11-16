package com.bitsco.vks.models;

import com.bitsco.vks.utils.ArrayListCommon;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
public class LookupRequest {
    private String sortField;
    private String sortOrder;

    private String casecode;
    private String casename;
    private String sppid;
    private Date fromdate;
    private Date todate;
    private Boolean underlevel;
    private String casetype;
    private int rowIndex;
    private int pageSize;

    private List<String> sppidList;

    public String getSppIdList() {
        if (ArrayListCommon.isNullOrEmpty(sppidList))
            return null;
        else {
            String rs = sppidList.get(0);
            if (sppidList.size() > 1)
                for (int i = 1; i < sppidList.size(); i++) {
                    rs += ";" + sppidList.get(i);
                }
            return rs;
        }
    }

    //REGISTER
    private String userfor;
    private String setnum;
    //DECISION
    private String applyfor;
    private String decicode;
    private String deciname;
    private String deciid;
    private Date fromdatedeci;
    private Date todatedeci;
    private String regicode;
    //AGAINST
    private Date fromdateagainst;
    private Date todateagainst;
    private String sppspc;
    private String usefor;
    //APPEAL
    private String appealid;
    private String appealname;
    private Date fromdateappeal;
    private Date todateappeal;
    //ACCUSED
    private String fullname;
    private String identify;
    private Date birthdayfrom;
    private Date birthdayto;
    private String locaid;
    private String address;
    private String natiid;
    private String counid;
    private String occuid;
    private String sex;
    private Integer conviction;
    private Integer offence;
    private List<String> partyid;
    private List<String> officeid;

    public String getPartyid() {
        if (ArrayListCommon.isNullOrEmpty(partyid))
            return null;
        else {
            String rs = partyid.get(0);
            if (partyid.size() > 1)
                for (int i = 1; i < partyid.size(); i++) {
                    rs += ";" + partyid.get(i);
                }
            return rs;
        }
    }

    public String getOfficeid() {
        if (ArrayListCommon.isNullOrEmpty(officeid))
            return null;
        else {
            String rs = officeid.get(0);
            if (officeid.size() > 1)
                for (int i = 1; i < officeid.size(); i++) {
                    rs += ";" + officeid.get(i);
                }
            return rs;
        }
    }

    // LAW
    private Boolean booCorrup;
    private Date fromdatecen;
    private Date todatecen;
    private String codeid;
    private String lawid;
    private String item;
    private String point;

    private String penaltyid;

    //PENALTY

    // TRANSFER
    private String transfrom;
    private String transto;
    private Date fromdatetrans;
    private Date todatetrans;
    private String select;
    private String centcode;
}
