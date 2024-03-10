package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airline;

import java.util.List;
import java.util.Optional;

public interface AirlineService {
    Airline saveAirline(Airline airline);
    List<Airline> getAllAirlines();
    Optional<Airline> getAirlineById(Integer id);
    Airline updateAirline(Airline airline);
    void deleteAirline(Integer id);
}
