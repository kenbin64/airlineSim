package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airport;

import java.util.List;
import java.util.Optional;

public interface AirportService {
    Airport saveAirport(Airport airport);
    List<Airport> getAllAirports();
    Optional<Airport> getAirportById(Integer id);
    Airport updateAirport(Airport airport);
    void deleteAirport(Integer id);
}

