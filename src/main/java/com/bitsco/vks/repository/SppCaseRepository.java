package com.bitsco.vks.repository;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.ProcessSppCaseResponse;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCaseRepository {
    List<SppCase> searchUpdateInfo1(String sppId, int rowIndex, int pageSize, String sortField, String sortOrder,
                                    SppCase sppcase, SppAccused accu, SppRegister register, SppCentence centence,
                                    String userfor);
    String updatewithwarn(SppCase _obj, String sppId, String userId);
    String insertwithwarn(SppCase _obj, Boolean isTachva, String sppId, String userId);
    String insert(SppCase _obj, Boolean isTachva, String sppId, String userId);
    List<LinkedCaseInsensitiveMap> searchCaswlaw(int rowIndex, int pageSize, String sortField, String sortOrder, String casecode, String userfor);
    String getTransidByCase(String casecode, String usefor, String sppid);

    List<LstLaw> searchLawByCase(String casecode, String userfor);

    String updateCaselawcodewithwarn(SppCase sppCase, LstLaw lstLaw, String userId, String sppId);
    ProcessSppCaseResponse insertUpdateDeleteCaseLaw(SppCase _case, String action, String lawCode, String userId, String sppId, String userfor);
    ProcessSppCaseResponse deleteCaseLawUpdateInfo(SppCase _case, String action, String lawCode, String userId, String userfor);
    String delete(String casecode, String userId);

    List<SppStaticcBegin> searchCaseStatic(String casecode, String lawcode);

    List<CaseHeroin> searchHeroin(String casecode, String lawcode);

    List<CaseExhibit> searchExhibit(String casecode, String lawcode);

    String insertStaticcBegin(String casecode, String lawcode, List<SppStaticcBegin> lstStaticcBegin, String userid);

    String insertCaseHeroin(String casecode, String lawcode, CaseHeroin heroin, String userid);

    String updateCaseHeroin(String casecode, String lawcode, CaseHeroin heroin, String userid);

    String insertCaseExhibit(String casecode, String lawcode, List<CaseExhibit> lstCaseExhibit, String userid);

    List<SppInvestment> searchInvestment(String casecode);

    LinkedCaseInsensitiveMap getSppCaseByCasecode(String casecode);

    List<LinkedCaseInsensitiveMap> searchListCaseLaw(String casecode, LstLaw req, int index, int pageSize, String sortField, String sortOrder);
}
