package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Flight;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public interface FlightService {

    /**
     * Create a new flight in the system.
     *
     * @param flight the flight to add
     * @return the saved flight
     */
    Flight createFlight(Flight flight);

    /**
     * Retrieve a flight by its ID.
     *
     * @param flightId the ID of the flight
     * @return an optional containing the flight if found, or empty otherwise
     */
    Optional<Flight> getFlightById(Integer flightId);

    /**
     * Update an existing flight's details.
     *
     * @param flight the flight with updated details
     * @return the updated flight
     */
    Flight updateFlight(Flight flight);

    /**
     * Delete a flight from the system.
     *
     * @param flightId the ID of the flight to delete
     */
    void deleteFlight(Integer flightId);

    /**
     * Check flight availability for a given route and optional time.
     *
     * @param routeId       the ID of the route
     * @param dateStr       the date as a string in the format YYYY-MM-DD
     * @param preferredTime an optional preferred time to filter flights around (±2 hours)
     * @return a list of available flights
     */
    List<Flight> checkFlightAvailability(Integer routeId, String dateStr, LocalTime preferredTime);
}
