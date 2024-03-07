package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Flight;

import java.util.List;
import java.util.Optional;

public interface FlightService {

    Flight createFlight(Flight flight);

    Optional<Flight> findFlightById(Long id);

    List<Flight> findAllFlights();

    Flight updateFlight(Long id, Flight flightDetails);

    void deleteFlight(Long id);

    // Additional method to update flight status could be defined here
    Flight updateFlightStatus(Long id, String status);
}
