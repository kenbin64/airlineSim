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
    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Optional<Aircraft> getAircraftById(Integer id) {
        return aircraftRepository.findById(id);
    }

    @Override
    public Aircraft updateAircraft(Aircraft aircraft) {

        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteAircraft(Integer id) {

        aircraftRepository.deleteById(id);
    }
}
