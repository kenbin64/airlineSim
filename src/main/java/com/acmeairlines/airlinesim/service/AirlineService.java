package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    List<Airline> findAllAirline();
    Optional<Airline> findAirlineById(Integer id);
    Airline saveAirline(Airline airline);
    void deleteAirline(Integer id);
    // Additional methods as needed, for example, finding airlines by country, etc.
}