package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.Repository.AircraftRepository;
import com.acmeairlines.airlinesim.model.Aircraft;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AircraftServiceImpl implements AircraftService {

    private final AircraftRepository aircraftRepository;

    @Autowired
    public AircraftServiceImpl(AircraftRepository aircraftRepository) {
        this.aircraftRepository = aircraftRepository;
    }

    @Override
    public Aircraft saveAircraft(Aircraft aircraft) {
        return aircraftRepository.save(aircraft);
    }

    @Override
    public Optional<Aircraft> getAircraftById(Long id) {
        return aircraftRepository.findById(id.intValue());
    }

    @Override
    public List<Aircraft> getAllAircrafts() {
        return aircraftRepository.findAll();
    }

    @Override
    public Aircraft updateAircraft(Long id, Aircraft aircraftDetails) {
        Aircraft aircraft = aircraftRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found for this id :: " + id));

        aircraft.setModel(aircraftDetails.getModel());
        aircraft.setTotalSeats(aircraftDetails.getTotalSeats());
        aircraft.setFirstClassSeats(aircraftDetails.getFirstClassSeats());
        aircraft.setBusinessClassSeats(aircraftDetails.getBusinessClassSeats());
        aircraft.setPremiumEconomySeats(aircraftDetails.getPremiumEconomySeats());
        aircraft.setEconomySeats(aircraftDetails.getEconomySeats());

        return aircraftRepository.save(aircraft);
    }

    @Override
    public void deleteAircraft(Long id) {
        Aircraft aircraft = aircraftRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Aircraft not found for this id :: " + id));
        aircraftRepository.delete(aircraft);
    }
}

