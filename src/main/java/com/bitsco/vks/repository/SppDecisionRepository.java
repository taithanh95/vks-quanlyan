package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.entity.SppDecision;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppDecisionRepository {
    List<SppDecision> search(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String applyfor, String casecode, String usefor);
    String insertUpdate(String action, SppDecision _obj, String userid);
    String insertUpdateAcc(String action, SppDecision _obj, String userid);
    List<LstDecisionEntity> searchDecitypeHS(String applyfor, String userfor);

    String delete(SppDecision _obj);
    String deleteAcc(String decicode);
    List<LstDecisionEntity> search_gh(String usefor, String applyfor, String deciid);
    List<LinkedCaseInsensitiveMap> isCheckTrans(String regicode);
    LinkedCaseInsensitiveMap getDecidetail(String decicode);
}
