package com.bitsco.vks.service.impl;

import com.bitsco.vks.dto.RequestSaveListSplitDTO;
import com.bitsco.vks.dto.RequestSearchSplitDTO;
import com.bitsco.vks.repository.SppSppSplitRepository;
import com.bitsco.vks.service.SppSppSplitService;
import com.bitsco.vks.utils.StringCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedCaseInsensitiveMap;

import java.util.List;

@Service
@Transactional
public class SppSppSplitServiceImpl implements SppSppSplitService {

    @Autowired
    private SppSppSplitRepository sppSppSplitRepository;

    @Override
    public List<LinkedCaseInsensitiveMap> search(RequestSearchSplitDTO req) {
        if(("casedialog").equals(req.getTemp()))
            return sppSppSplitRepository.searchCase(req);
        else if (("casedialogout".equals(req.getTemp())))
            return sppSppSplitRepository.searchCase1(req);
        else
            if(("a").equals(req.getChoicetype()))
                return sppSppSplitRepository.searchCaseSplit(req);
            else
                if (("2").equals(req.getChoice()))
                    return sppSppSplitRepository.searchSplit(req);
                else
                    return sppSppSplitRepository.searchAccuSplit(req);
    }

    @Override
    public String insertOrUpdate(RequestSaveListSplitDTO req, String username) {
        final String[] _result = {""};
        try {
            req.getSppcasesplit().forEach(data -> {
                String res = sppSppSplitRepository
                        .insertUpdateAccSpilit(data,username,req.getChoice(),req.getChoiceType());
                if(StringCommon.isNullOrBlank(res))
                    _result[0] = res;
                else
                    throw new NullPointerException();
            });
        } catch (NullPointerException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }

        return _result[0];
    }

    @Override
    public String delete(RequestSaveListSplitDTO req, String choiceType) {
        try {
            req.getSppcasesplit().forEach(data -> {
                String res = sppSppSplitRepository.deleteAccSpilit(data, choiceType);
                if (!StringCommon.isNullOrBlank(res))
                    throw new NullPointerException();
            });
        } catch (NullPointerException e) {
            return e.getMessage();
        } catch (Exception e) {
            return e.getMessage();
        }

        return null;
    }
}
