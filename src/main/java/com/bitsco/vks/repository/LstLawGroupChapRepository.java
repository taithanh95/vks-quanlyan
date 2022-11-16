package com.bitsco.vks.repository;

import com.bitsco.vks.dto.LstLawGroupChapDTO;
import com.bitsco.vks.models.LstLawGroupChapSave;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: Nguyen Tai Thanh <taithanh95.dev@gmail.com>
 * Date: 12/05/2022
 * Time: 9:23 AM
 */
public interface LstLawGroupChapRepository {

    List<LstLawGroupChapDTO> search(Integer rowIndex, Integer pageSize, String sortField, String sortOrder, String id, String groupid, String fullname, String groupname);

    List<LstLawGroupChapDTO> searchLstById(String id);

    String insertUpdate(LstLawGroupChapSave req, String username);

    String insert(LstLawGroupChapSave req, String username);

    String delete(String id, String groupid);

    String deleteAll(String id);
}
