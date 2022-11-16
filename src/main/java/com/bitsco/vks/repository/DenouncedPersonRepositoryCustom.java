package com.bitsco.vks.repository;

import com.bitsco.vks.entity.DenouncedPerson;

import java.util.List;
import java.util.Optional;


public interface DenouncedPersonRepositoryCustom {

    Optional<List<DenouncedPerson>> findByIdCustom(Long id);
}
