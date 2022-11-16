package com.bitsco.vks.service;

import com.bitsco.vks.entity.LstInspector;

import java.util.List;

public interface AdmUsersService {

    List<LstInspector> getLstInspectors(String sppid);

}
