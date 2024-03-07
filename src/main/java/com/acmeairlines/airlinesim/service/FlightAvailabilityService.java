package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Flight;

import java.time.LocalDate;
import java.util.List;

public interface FlightAvailabilityService {
    List<Flight> checkAvailability(String departureAirportCode, String arrivalAirportCode,
                                   LocalDate departureDate, String classOfService);
}