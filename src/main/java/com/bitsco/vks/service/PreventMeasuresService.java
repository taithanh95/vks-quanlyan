package com.bitsco.vks.service;

import com.bitsco.vks.entity.PreventMeasures;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 20/01/2022
 * Time: 4:53 PM
 */
public interface PreventMeasuresService {
    List<PreventMeasures> search(PreventMeasures preventMeasures);

    String insertOrUpdate(PreventMeasures preventMeasures, String username);

    String delete(String accucode);
}
