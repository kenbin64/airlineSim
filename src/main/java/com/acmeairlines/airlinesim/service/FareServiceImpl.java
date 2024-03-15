package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Fare;
import com.acmeairlines.airlinesim.repository.FareRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class FareServiceImpl implements FareService {

    private final FareRepository fareRepository;

    @Autowired
    public FareServiceImpl(FareRepository fareRepository) {
        this.fareRepository = fareRepository;
    }

    @Override
    public Fare saveFare(Fare fare) {
        fareRepository.insertOrUpdateFare(fare.getFareId(), fare.getRouteId(), fare.getAmount(), fare.getClassOfService().toString());
        // After calling the stored procedure, you might need to refresh or retrieve the fare object again if you need the updated state.
        return fare; // Note: This may not reflect changes from the stored procedure if it alters data.
    }

    @Override
    public Fare findFareById(Integer id) {
        Optional<Fare> fare = fareRepository.findById(id);
        return fare.orElse(null);
    }

    @Override
    public List<Fare> findAllFares() {
        return fareRepository.findAll();
    }

    @Override
    public void deleteFare(Integer id) {
        fareRepository.deleteById(id);
    }
}
