package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstSigner;

import java.util.List;

public interface LstSignerService {
    List<LstSigner> autocomplete(String query, String polid, String officeid, String sppid, int limit);
}
