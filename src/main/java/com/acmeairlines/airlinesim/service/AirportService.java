package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airport;
import java.util.List;
import java.util.Optional;

public interface AirportService {
    List<Airport> findAllAirports();
    Optional<Airport> findAirportById(Integer id);
    Airport saveAirport(Airport airport);
    void deleteAirport(Integer id);
}

