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
    public List<Airline> findAllAirline() {
        return airlineRepository.findAll();
    }

    @Override
    public Optional<Airline> findAirlineById(Integer id) {
        return airlineRepository.findById(id.longValue());
    }

    @Override
    public Airline saveAirline(Airline airline) {
        return airlineRepository.save(airline);
    }

    @Override
    public void deleteAirline(Integer id) {
        airlineRepository.deleteById(id.longValue());
    }
    // Implement additional methods as required
}

