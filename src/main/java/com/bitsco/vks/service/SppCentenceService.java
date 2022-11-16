package com.bitsco.vks.service;

import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppCentAccu;
import com.bitsco.vks.entity.SppCentence;
import com.bitsco.vks.models.ProcessCentenceRequest;
import com.bitsco.vks.models.SppCentenceDeleteRequest;
import com.bitsco.vks.models.SppCentenceSaveRequest;
import com.bitsco.vks.models.SppCentenceSearchRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCentenceService {
    List<SppCentence> search(SppCentenceSearchRequest request, Pageable pageable);

    InsertUpdateCentenceDTO insertUpdateUpdateInfo(SppCentenceSaveRequest request);

    String delete(SppCentenceDeleteRequest request);

    List<SppAccused> getaccufromcentcode(String centcode);

    String deleteUpdateinfo(ProcessCentenceRequest request, String header);

    List<LinkedCaseInsensitiveMap> searchCentApped(String regicode, String type);

    LinkedCaseInsensitiveMap getCentDetail(String centcode,String sppid);

    LinkedCaseInsensitiveMap getCentAccu(String centcode, String accucode);

    String saveCentAccu(SppCentAccu req, String username);

    String deleteCentAccu(String centcode, String accucode, String regicode);
}
