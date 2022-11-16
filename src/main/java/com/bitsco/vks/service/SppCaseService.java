package com.bitsco.vks.service;

import com.bitsco.vks.entity.*;
import com.bitsco.vks.models.*;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCaseService {
    List<SppCase> doSearch(UpdateInfoRequest request);
    String insert(SppCaseInsertRequest request);
    String update(SppCaseInsertRequest request);
    List<LinkedCaseInsensitiveMap> searchCaswlaw(UpdateInfoSearchRequest request, Pageable pageable);
    String getTransidByCase(String casecode, String usefor, String sppid);

    List<LstLaw> searchLawByCase(String casecode, String userfor);

    String updateCaselawcodewithwarn(UpdateCaseLawWithWarnRequest request, String username);
    ProcessSppCaseResponse insertUpdateDeleteCaseLaw(ProcessCaseLawRequest request, String username);
    ProcessSppCaseResponse deleteCaseLawUpdateInfo(ProcessCaseLawRequest request, String username);
    String delete(String casecode, String userId);

    List<SppStaticcBegin> searchCaseStatic(String casecode, String lawcode);

    List<CaseHeroin> searchHeroin(String casecode, String lawcode);

    List<CaseExhibit> searchExhibit(String casecode, String lawcode);

    String insertStaticcBegin(ProcessStaticcBeginRequest request, String userid);

    String insertCaseHeroin(ProcessCaseHeroinRequest request, String userid);

    String updateCaseHeroin(ProcessCaseHeroinRequest request, String userid);

    String insertCaseExhibit(ProcessCaseExhibitRequest request, String userid);

    List<SppInvestment> searchInvestment(String casecode);

    LinkedCaseInsensitiveMap getSppCaseByCaseCode(String casecode);

    List<LinkedCaseInsensitiveMap> searchListCaseLaw(SppCaseLawSearchRequest req);

}
