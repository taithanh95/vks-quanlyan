package com.bitsco.vks.models;

import com.bitsco.vks.entity.LstInspector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 04/04/2022
 * Time: 10:55 AM
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LstInspectorInsertRequest extends LstInspector {
    public String action;
}
