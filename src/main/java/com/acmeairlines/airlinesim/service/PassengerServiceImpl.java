package com.acmeairlines.airlinesim.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.acmeairlines.airlinesim.model.Passenger;
import com.acmeairlines.airlinesim.repository.PassengerRepository;
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
        // You can add additional logic here if needed before saving the passenger
        return passengerRepository.save(passenger);
    }

    @Override
    public List<Passenger> getAllPassengers() {
        return passengerRepository.findAll();
    }

    @Override
    public Optional<Passenger> getPassengerById(Integer id) {
        return passengerRepository.findById(id);
    }

    @Override
    public Passenger updatePassenger(Passenger passenger) {
        // Ensure the passenger exists and is valid before updating
        if (passenger != null && passenger.getPassengerId() != null && passengerRepository.existsById(passenger.getPassengerId())) {
            return passengerRepository.save(passenger);
        } else {
            // Handle the case where the passenger is null or does not exist
            throw new IllegalArgumentException("Passenger is null or does not exist.");
        }
    }

    @Override
    public void deletePassenger(Integer id) {
        if (passengerRepository.existsById(id)) {
            passengerRepository.deleteById(id);
        } else {
            // Handle the case where the passenger does not exist
            throw new IllegalArgumentException("Passenger with id " + id + " does not exist.");
        }
    }
}

