package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.repository.SeatAvailabilityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeatAvailabilityService {

    private final SeatAvailabilityRepository seatAvailabilityRepository;


    @Autowired
    public SeatAvailabilityService(SeatAvailabilityRepository seatAvailabilityRepository) {
        this.seatAvailabilityRepository = seatAvailabilityRepository;
    }

    public boolean checkAvailabilityAndReserveIfPossible(int flightId, int seatId) {
        boolean isAvailable = seatAvailabilityRepository.checkSeatAvailability(flightId, seatId);

        if (isAvailable) {
            // Additional logic to reserve the seat, possibly involving another stored procedure or database operation
        }

        return isAvailable;
    }
}
