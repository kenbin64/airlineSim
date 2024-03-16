package com.acmeairlines.airlinesim.service.impl;

import com.acmeairlines.airlinesim.model.Flight;
import com.acmeairlines.airlinesim.repository.FlightRepository;
import com.acmeairlines.airlinesim.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightRepository flightRepository;

    @Override
    public Flight createFlight(Flight flight) {
        // Save the provided flight to the database
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> getFlightById(Integer flightId) {
        // Retrieve a flight by its ID
        return flightRepository.findById(flightId);
    }

    @Override
    public Flight updateFlight(Flight flight) {
        // Update an existing flight. This assumes the flight object contains an ID.
        return flightRepository.save(flight);
    }

    @Override
    public void deleteFlight(Integer flightId) {
        // Delete a flight by its ID
        flightRepository.deleteById(flightId);
    }

    @Override
    public List<Flight> checkFlightAvailability(Integer routeId, String dateStr, LocalTime preferredTime) {
        LocalDate date = LocalDate.parse(dateStr); // Convert String to LocalDate

        // Define the entire day if no specific time is provided
        LocalDateTime startDateTime = date.atStartOfDay();
        LocalDateTime endDateTime = date.atTime(23, 59, 59);

        // Adjust for preferred time if provided
        if (preferredTime != null) {
            startDateTime = LocalDateTime.of(date, preferredTime.minusHours(2));
            endDateTime = LocalDateTime.of(date, preferredTime.plusHours(2));
        }

        // Retrieve all flights for the given route ID within the specified date/time range
        List<Flight> flights = flightRepository.findByRouteIdAndDepartureTimeBetween(routeId, startDateTime, endDateTime);

        return flights;
    }

    // Additional methods could include more complex queries based on your application's needs
}
