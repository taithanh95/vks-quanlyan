package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppCentAccu;
import com.bitsco.vks.entity.SppCentence;
import com.bitsco.vks.models.ProcessCentenceRequest;
import com.bitsco.vks.models.SppCentenceDeleteRequest;
import com.bitsco.vks.models.SppCentenceSaveRequest;
import com.bitsco.vks.models.SppCentenceSearchRequest;
import com.bitsco.vks.repository.LstSignerRepository;
import com.bitsco.vks.repository.SppCentenceRepository;
import com.bitsco.vks.service.SppCentenceService;
import com.bitsco.vks.utils.Constants;
import com.bitsco.vks.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.Collections;
import java.util.List;

@Service
public class SppCentenceServiceImpl implements SppCentenceService {
    @Autowired
    private SppCentenceRepository sppCentenceRepository;
    @Autowired
    private LstSignerRepository lstSignerRepository;

    @Override
    public List<SppCentence> search(SppCentenceSearchRequest request, Pageable pageable) {
        List list = Collections.emptyList();
        if (!Utils.StringIsNullOrEmpty(request.getRegicode())) {
//            if (request.getUserfor().equals("G1")) {
                list =
                        sppCentenceRepository.searchupdateinfo(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder
                                , request.getRegicode(), request.userfor, request.sppid);
//            }
        } else {
            if (request.getCasecode() != null)
                list =
                        sppCentenceRepository.searchcase(pageable.getPageNumber(), pageable.getPageSize(), request.sortField, request.sortOrder
                                , request.getCasecode(), request.userfor, request.sppid);
        }

        return list;
    }

    @Override
    public InsertUpdateCentenceDTO insertUpdateUpdateInfo(SppCentenceSaveRequest request) {
        InsertUpdateCentenceDTO ret = sppCentenceRepository.insertUpdateUpdateInfo(request.action, request.regicode, request.centence, request.userfor, request.userId, request.sppId);

        if (Utils.StringIsNullOrEmpty(ret.result)) {
            if (request.userfor.equals("G1")) {
                lstSignerRepository.insert(request.centence.getSignname(), request.centence.getSignoffice(), request.beginOffice,
                        request.beginOfficeId, request.sppId, request.userId);
            } else if (request.userfor.equals("G2")) {
                lstSignerRepository.insert(request.centence.getSignname(), request.centence.getSignoffice(), Constants.DONVIRAQD_SPP,
                        request.sppId, request.sppId, request.userId);
            } else {
                lstSignerRepository.insert(request.centence.getSignname(), request.centence.getSignoffice(), Constants.DONVIRAQD_SPC,
                        request.sppId, request.sppId, request.userId);
            }
        }
        return ret;
    }

    @Override
    public String delete(SppCentenceDeleteRequest request) {
        return sppCentenceRepository.delete(request.regicode, request.centence, request.conclusionId, request.sppId, request.userId);
    }

    @Override
    public List<SppAccused> getaccufromcentcode(String centcode) {
        return sppCentenceRepository.getaccufromcentcode(centcode);
    }

    @Override
    public String deleteUpdateinfo(ProcessCentenceRequest request, String userId) {
        return sppCentenceRepository.deleteUpdateinfo(request.action, request.centence, request.sppId, userId);
    }

    @Override
    public List<LinkedCaseInsensitiveMap> searchCentApped(String regicode, String type) {
        return sppCentenceRepository.searchCentApped(regicode,type);
    }

    @Override
    public LinkedCaseInsensitiveMap getCentDetail(String centcode,String sppid) {
        return sppCentenceRepository.getCentdetail(centcode,sppid);
    }

    @Override
    public LinkedCaseInsensitiveMap getCentAccu(String centcode, String accucode) {
        return sppCentenceRepository.getCentAccu(centcode,accucode);
    }

    @Override
    public String saveCentAccu(SppCentAccu req, String username) {
        return sppCentenceRepository.saveCentAccu(req,username);
    }

    @Override
    public String deleteCentAccu(String centcode, String accucode, String regicode) {
        return sppCentenceRepository.deleteCentAccu(centcode,accucode,regicode);
    }
}
