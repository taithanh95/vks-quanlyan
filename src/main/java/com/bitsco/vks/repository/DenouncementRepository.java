package com.bitsco.vks.repository;

import com.bitsco.vks.entity.Denouncement;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DenouncementRepository extends JpaRepository<Denouncement, Long>, DenouncementRepositoryCustom {

    @EntityGraph("denouncement.fetchNone")
    List<Denouncement> findAll();

    @EntityGraph("denouncement.fetchNone")
    Page<Denouncement> findAll(Pageable pageable);

//    @EntityGraph("denouncement.fetchAll")
//    @Query("SELECT d FROM Denouncement d LEFT JOIN d.denouncedPeople dp"
//        + " LEFT JOIN d.verificationInvestigations vi "
//        + " LEFT JOIN d.investigationActivities ia "
//        + " LEFT JOIN d.settlementDecisions sd "
//        + " WHERE dp.status = 1 AND vi.status = 1 AND ia.status = 1 AND sd.status = 1 AND d.id = :id")
//    Optional<Denouncement> findById(@Param("id") Long id);

}
