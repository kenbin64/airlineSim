package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Aircraft;
import java.util.List;
import java.util.Optional;

public interface AircraftService {
    List<Aircraft> findAllAircraft();
    Optional<Aircraft> findAircraftById(Integer id);
    Aircraft saveAircraft(Aircraft aircraft);
    void deleteAircraft(Integer id);
}
