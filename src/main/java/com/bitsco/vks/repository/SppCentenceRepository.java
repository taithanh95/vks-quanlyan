package com.bitsco.vks.repository;

import com.bitsco.vks.dto.InsertUpdateCentenceDTO;
import com.bitsco.vks.entity.SppAccused;
import com.bitsco.vks.entity.SppCentAccu;
import com.bitsco.vks.entity.SppCentence;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

public interface SppCentenceRepository {
    List<SppCentence> searchupdateinfo(int rowIndex, int pageSize, String sortField, String sortOrder,
                                       String regicode, String userfor, String sppid);

    List<SppCentence> searchcase(int rowIndex, int pageSize, String sortField, String sortOrder,
                                 String casecode, String userfor, String sppid);

    InsertUpdateCentenceDTO insertUpdateUpdateInfo(String action, String regicode, SppCentence centence,
                                                   String userfor, String userId, String sppId);

    String delete(String regicode, SppCentence centence, String conclusionId, String sppId, String userId);

    List<SppAccused> getaccufromcentcode(String centcode);

    String deleteUpdateinfo(String action, SppCentence centence, String sppId, String userId);

    List<LinkedCaseInsensitiveMap> searchCentApped(String regicode, String type);

    LinkedCaseInsensitiveMap getCentdetail(String centcode, String sppid);

    LinkedCaseInsensitiveMap getCentAccu(String centcode, String accucode);

    String saveCentAccu(SppCentAccu req, String username);

    String deleteCentAccu(String centcode, String accucode, String regicode);
}
