package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Passenger;

import java.util.List;
import java.util.Optional;

public interface PassengerService {
    Passenger savePassenger(Passenger passenger);
    Optional<Passenger> getPassengerById(Integer id);
    void deletePassenger(Integer id);
    List<Passenger> getAllPassengers();
}
