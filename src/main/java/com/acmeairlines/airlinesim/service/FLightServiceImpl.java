package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.Repository.FlightRepository;
import com.acmeairlines.airlinesim.model.Flight;
import com.acmeairlines.airlinesim.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FLightServiceImpl  implements FlightService{


    private final FlightRepository flightRepository;

    @Autowired
    public FLightServiceImpl(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public Flight createFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flight> findFlightById(Long id) {
        return flightRepository.findById(id.intValue());
    }

    @Override
    public List<Flight> findAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flight updateFlight(Long id, Flight flightDetails) {
        return null;
    }

    @Override
    public void deleteFlight(Long id) {
        Flight flight = flightRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found for this id :: " + id));
        flightRepository.delete(flight);
    }

    @Override
    public Flight updateFlightStatus(Long id, String status) {
        return null;
    }
}
