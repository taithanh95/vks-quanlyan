package com.bitsco.vks.repository;

import com.bitsco.vks.entity.ApParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApParamRepository extends JpaRepository<ApParam, Long> {

    List<ApParam> findApParamsByParamCodeAndStatus(String code, Integer status);

}
