package com.bitsco.vks.service;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.models.LstLawGroupChapRequest;
import com.bitsco.vks.models.LstLawGroupChapSave;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:30 AM
 */
public interface LstLawGroupChapService {
    List<LstLawGroupChapDTO> search(LstLawGroupChapRequest req, Pageable pageable);

    List<LstLawGroupChapDTO> searchLstById(String id);

    String insertUpdate(LstLawGroupChapSave req, String username);

    String delete(String id, String groupid);

    String deleteAll(String id);
}
