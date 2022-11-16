package com.bitsco.vks.repository;

import com.bitsco.vks.entity.*;

import java.util.List;

public interface SppAccusedRepository {
    List<SppAccused> search_bc(int rowIndex, int pageSize, String sortField, String sortOrder, String regicode, String sppid, String casecode);
    String insertUpdate(String action, String casecode, SppAccused ac, LstLocation address, LstLocation locaid, String regicode, LstSPC spc, LstSPP spp, LstPolice police
            , LstArmyEntity army, LstCustoms customs, LstRanger ranger, LstBorderGuards border, LstCountryEntity country, String sppid, List<LstLaw> lawcode, String phapnhan, String userId);
    String delete(String code);
    List<LstLaw> findLawcodeByAccused(String accucode);
    List<String> findAccusedCodeByArresteeId(String arresteeId);
}
