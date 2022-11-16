package com.bitsco.vks.repository;

import com.bitsco.vks.entity._LstInspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface _LstInspectorRepository extends JpaRepository<_LstInspector, String> {
    @Query(value = "SELECT * FROM Lst_Inspector n where n.sppid = ?1 AND n.status = 'Y'", nativeQuery = true)
    List<_LstInspector> getListLstInspectorBySppId(String sppId);

    @Query(value = "SELECT * FROM Lst_Inspector n where n.sppid = ?1 AND n.status = 'Y' AND n.position LIKE ?2", nativeQuery = true)
    List<_LstInspector> getListLstInspectorBySppIdAndPosition(String sppId, String position);

    @Query(value = "SELECT * FROM Lst_Inspector n where n.sppid = ?1 AND n.status = 'Y' "+
            " AND n.position LIKE ?2 AND (?3 IS NULL OR UPPER(n.fullname) LIKE UPPER(?3) OR (n.inspCode) LIKE UPPER(?3))", nativeQuery = true)
    List<_LstInspector> getListInspectorByPositionSearchKey(String sppId, String position, String key);
}

