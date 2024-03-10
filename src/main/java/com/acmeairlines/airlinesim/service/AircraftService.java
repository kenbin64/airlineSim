package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftService {
    Aircraft saveAircraft(Aircraft aircraft);
    List<Aircraft> getAllAircrafts();
    Optional<Aircraft> getAircraftById(Integer id);
    Aircraft updateAircraft(Aircraft aircraft);
    void deleteAircraft(Integer id);
}