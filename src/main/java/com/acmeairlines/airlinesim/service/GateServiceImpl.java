package com.acmeairlines.airlinesim.service.impl;

import com.acmeairlines.airlinesim.model.Gate;
import com.acmeairlines.airlinesim.repository.GateRepository;
import com.acmeairlines.airlinesim.service.GateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GateServiceImpl implements GateService {

    private final GateRepository gateRepository;

    @Autowired
    public GateServiceImpl(GateRepository gateRepository) {
        this.gateRepository = gateRepository;
    }

    @Override
    public Gate saveGate(Gate gate) {
        return gateRepository.save(gate);
    }

    @Override
    public Optional<Gate> findGateById(Integer id) {
        return gateRepository.findById(id);
    }

    @Override
    public List<Gate> findAllGates() {
        return gateRepository.findAll();
    }

    @Override
    public void deleteGate(Integer id) {
        gateRepository.deleteById(id);
    }
}

