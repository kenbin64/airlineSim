package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airport;
import com.acmeairlines.airlinesim.repository.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {

    private final AirportRepository airportRepository;

    @Autowired
    public AirportServiceImpl(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    @Override
    public Airport saveAirport(Airport airport) {
        return airportRepository.save(airport);
    }

    @Override
    public List<Airport> getAllAirports() {
        return airportRepository.findAll();
    }

    @Override
    public Optional<Airport> getAirportById(Integer id) {
        return airportRepository.findById(id);
    }

    @Override
    public Airport updateAirport(Airport airport) {

        return airportRepository.save(airport);
    }

    @Override
    public void deleteAirport(Integer id) {
        airportRepository.deleteById(id);
    }
}
