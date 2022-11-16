package com.bitsco.vks.repository.impl;

import com.bitsco.vks.dto.ComboBoxDTO;
import com.bitsco.vks.repository.LstPolAndPoliceRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LstPolAndPoliceRepositoryImpl implements LstPolAndPoliceRepository {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ComboBoxDTO> searchByName(String name) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT POLID AS VALUE, NAME FROM (");
        sql.append("SELECT POLID, NAME FROM SPP.LST_POL ");
        sql.append("UNION ");
        sql.append("SELECT POLICEID, name FROM spp.lst_police) ");
        sql.append("WHERE ROWNUM <= 15 ");
        sql.append("AND (:name is null or :name = '' or  UPPER(name) LIKE '%' || UPPER(:name) ||'%') ");
        sql.append("ORDER BY name");
        Query query = entityManager.createNativeQuery(sql.toString());
        query.setParameter("name", name);
        List<Object[]> result = query.getResultList();
        List<ComboBoxDTO> comboBox = new ArrayList<>();
        for (Object[] data : result) {
            comboBox.add(new ComboBoxDTO(data[0], data[1].toString()));
        }

        return comboBox;
    }
}
