package com.bitsco.vks.models;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:22 AM
 */
@Data
public class LstLawGroupChapSave implements Serializable {
   private String action;
   private String id;
   private String fullname;
   private List<String> lstGroupid;
}
