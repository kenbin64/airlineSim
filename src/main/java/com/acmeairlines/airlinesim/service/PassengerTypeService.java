package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.PassengerType;

import java.util.List;
import java.util.Optional;

public interface PassengerTypeService {
    PassengerType savePassengerType(PassengerType passengerType);
    Optional<PassengerType> getPassengerTypeById(Integer id);
    void deletePassengerType(Integer id);
    List<PassengerType> getAllPassengerTypes();
}

