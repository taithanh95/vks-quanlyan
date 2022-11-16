package com.bitsco.vks.models;

import com.bitsco.vks.entity.SppStaticcBegin;
import lombok.Data;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 21/02/2022
 * Time: 9:41 AM
 */
@Data
public class ProcessCaseStaticc {
    public String regicode;
    public String centcode;
    public String lawcode;
    public String userfor;
    public List<SppStaticcBegin> lstStaticcBegin;
}
