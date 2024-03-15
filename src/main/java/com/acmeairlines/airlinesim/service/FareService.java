package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Fare;
import java.util.List;

public interface FareService {
    Fare saveFare(Fare fare);
    Fare findFareById(Integer id);
    List<Fare> findAllFares();
    void deleteFare(Integer id);
}
