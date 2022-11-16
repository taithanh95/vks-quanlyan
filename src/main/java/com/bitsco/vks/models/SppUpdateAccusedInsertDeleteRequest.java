package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstInspector;
import com.bitsco.vks.entity.SppAccused;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SppUpdateAccusedInsertDeleteRequest implements Serializable {
    public List<SppAccused> sppAccusedsDeleted;
    public List<SppAccused> sppAccusedsInserted;
    public List<LstInspector> lstInspectorsDeleted;
    public  List<LstInspector> lstInspectorsInserted;
    public String for_type;
}
