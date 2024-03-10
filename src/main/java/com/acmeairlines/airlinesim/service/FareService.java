package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Fare;

import java.util.List;
import java.util.Optional;

public interface FareService {
    Fare saveFare(Fare fare);
    List<Fare> getAllFares();
    Optional<Fare> getFareById(Integer id);
    Fare updateFare(Fare fare);
    void deleteFare(Integer id);
    // Additional methods can be defined here as needed, such as finding fares by flight ID, etc.
}

