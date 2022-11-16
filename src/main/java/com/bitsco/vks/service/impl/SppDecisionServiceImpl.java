package com.bitsco.vks.service.impl;

import com.bitsco.vks.entity.LstDecisionEntity;
import com.bitsco.vks.entity.SppDecision;
import com.bitsco.vks.models.SppDecisionSearchRequest;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.repository.SppDecisionRepository;
import com.bitsco.vks.service.SppDecisionService;
import com.bitsco.vks.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
public class SppDecisionServiceImpl implements SppDecisionService {
    @Autowired
    private SppDecisionRepository sppDecisionRepository;
    @Autowired
    private LstSignerRepository lstSignerRepository;

    @Override
    public String insertUpdate(String action, SppDecision _obj, String userid, String sppid) {
        String decicode = sppDecisionRepository.insertUpdate(action, _obj, userid);
        lstSignerRepository.insert(_obj.getSignname(), _obj.getSignoffice(),
                _obj.getBegin_office().equalsIgnoreCase("SPC") ? Constants.DONVIRAQD_SPC :
                _obj.getBegin_office().equalsIgnoreCase("SPP") ? Constants.DONVIRAQD_SPP : _obj.getBegin_office()
                , _obj.getBegin_officeid(), sppid, userid);
        return  decicode;
    }
    @Override
    public String insertUpdateAcc(String action, SppDecision _obj, String userid, String sppid) {
        String decicode = sppDecisionRepository.insertUpdateAcc(action, _obj, userid);
        return  decicode;
    }

    @Override
    public List<SppDecision> search(SppDecisionSearchRequest request, Pageable pageable) {
        return sppDecisionRepository.search(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder, request.regicode, request.applyfor
        , request.casecode, request.usefor);
    }

    @Override
    public List<LstDecisionEntity> searchDecitypeHS(String applyfor, String userfor) {
        return sppDecisionRepository.searchDecitypeHS(applyfor, userfor);
    }

    @Override
    public String delete(SppDecision decision) {
        return sppDecisionRepository.delete(decision);
    }
    @Override
    public String deleteAcc(String decicode) {
        return sppDecisionRepository.deleteAcc(decicode);
    }

    @Override
    public List<LstDecisionEntity> search_gh(String usefor, String applyfor, String deciid) {
        return sppDecisionRepository.search_gh(usefor,applyfor,deciid);
    }

    @Override
    public LinkedCaseInsensitiveMap getDeciDetail(String decicode) {
        return sppDecisionRepository.getDecidetail(decicode);
    }
}
