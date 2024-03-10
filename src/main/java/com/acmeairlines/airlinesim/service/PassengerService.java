package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger savePassenger(Passenger passenger);
    List<Passenger> getAllPassengers();
    Optional<Passenger> getPassengerById(Integer id);
    Passenger updatePassenger(Passenger passenger);
    void deletePassenger(Integer id);
    // Additional methods as required, for example, findByEmail, etc.
}

