package com.bitsco.vks.repository;

import com.bitsco.vks.entity.LstSigner;

import java.util.List;

public interface LstSignerRepository {
    String insert(String signname, String position, String polid, String officeid, String sppid, String userid);
    List<LstSigner> autocomplete(String query, String polid, String officeid, String sppid, int limit);
}
