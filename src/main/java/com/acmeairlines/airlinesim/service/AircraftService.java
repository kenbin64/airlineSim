package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Aircraft;

import java.util.List;
import java.util.Optional;

public interface AircraftService {

    Aircraft saveAircraft(Aircraft aircraft);

    Optional<Aircraft> getAircraftById(Long id);

    List<Aircraft> getAllAircrafts();

    Aircraft updateAircraft(Long id, Aircraft aircraftDetails);

    void deleteAircraft(Long id);
}
