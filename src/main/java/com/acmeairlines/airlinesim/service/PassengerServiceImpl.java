package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Passenger;
import com.acmeairlines.airlinesim.repository.PassengerRepository;
import com.acmeairlines.airlinesim.service.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerServiceImpl implements PassengerService {

    private final PassengerRepository passengerRepository;

    @Autowired
    public PassengerServiceImpl(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    @Override
    public Passenger savePassenger(Passenger passenger) {
        return passengerRepository.save(passenger);
    }

    @Override
    public Optional<Passenger> getPassengerById(Integer id) {
        return passengerRepository.findById(id.longValue());
    }

    @Override
    public void deletePassenger(Integer id) {
        passengerRepository.deleteById(id.longValue());
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }
}
