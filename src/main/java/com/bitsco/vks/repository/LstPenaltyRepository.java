package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstPenaltyDTO;
import com.bitsco.vks.entity.LstPenalty;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 16/05/2022
 * Time: 3:24 PM
 */
public interface LstPenaltyRepository {
    List<LstPenaltyDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String penaltyid, String penaltyname, String penaltyfor);

    String insertUpdate(LstPenalty req, String username);

    String delete(LstPenalty req);

    List<LstPenalty> getListPenalty(String query, Integer rownum);
}
