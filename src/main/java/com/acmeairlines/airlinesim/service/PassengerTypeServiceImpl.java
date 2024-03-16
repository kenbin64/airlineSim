package com.acmeairlines.airlinesim.service.impl;

import com.acmeairlines.airlinesim.model.PassengerType;
import com.acmeairlines.airlinesim.repository.PassengerTypeRepository;
import com.acmeairlines.airlinesim.service.PassengerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PassengerTypeServiceImpl implements PassengerTypeService {

    private final PassengerTypeRepository passengerTypeRepository;

    @Autowired
    public PassengerTypeServiceImpl(PassengerTypeRepository passengerTypeRepository) {
        this.passengerTypeRepository = passengerTypeRepository;
    }

    @Override
    public PassengerType savePassengerType(PassengerType passengerType) {
        return passengerTypeRepository.save(passengerType);
    }

    @Override
    public Optional<PassengerType> getPassengerTypeById(Integer id) {
        return passengerTypeRepository.findById(id);
    }

    @Override
    public void deletePassengerType(Integer id) {
        passengerTypeRepository.deleteById(id);
    }

    @Override
    public List<PassengerType> getAllPassengerTypes() {
        return passengerTypeRepository.findAll();
    }
}

