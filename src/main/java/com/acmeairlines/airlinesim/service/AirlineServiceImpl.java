package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Airline;
import com.acmeairlines.airlinesim.repository.AirlineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AirlineServiceImpl implements AirlineService {

    private final AirlineRepository airlineRepository;

    @Autowired
    public AirlineServiceImpl(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public List<Airline> getAllAirlines() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<Airline> getAirlineById(Integer id) {
        return airlineRepository.findById(id);
    }

    @Override
    public Airline updateAirline(Airline airline) {
        if (airline != null && airline.getAirlineId() != null && airlineRepository.existsById(airline.getAirlineId())) {
            return airlineRepository.save(airline);
        } else {
            // Here you should handle the case where the airline is null or does not exist
            throw new IllegalArgumentException("Airline is null or does not exist.");
        }
    }

    @Override
    public void deleteAirline(Integer id) {
        airlineRepository.deleteById(id);
    }
}

