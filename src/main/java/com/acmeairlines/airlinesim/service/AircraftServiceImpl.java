package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Aircraft;
import com.acmeairlines.airlinesim.repository.AircraftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftServiceImpl(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public List<Aircraft> findAllAircraft() {
        return aircraftRepository.findAll();
    }

    @Override
    public Optional<Aircraft> findAircraftById(Integer id) {
        return aircraftRepository.findById(id.longValue());
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteAircraft(Integer id) {
        aircraftRepository.deleteById(id.longValue());
    }
}

