package com.bitsco.vks.repository;

import com.bitsco.vks.entity.DenouncedPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DenouncedPersonRepository extends JpaRepository<DenouncedPerson, Long>,DenouncedPersonRepositoryCustom {

}
