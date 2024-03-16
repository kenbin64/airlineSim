package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Gate;

import java.util.List;
import java.util.Optional;

public interface GateService {
    Gate saveGate(Gate gate);
    Optional<Gate> findGateById(Integer id);
    List<Gate> findAllGates();
    void deleteGate(Integer id);
}
