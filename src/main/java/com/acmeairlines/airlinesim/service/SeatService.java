package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Seat;

import java.util.List;
import java.util.Optional;

public interface SeatService {
    Seat saveSeat(Seat seat);
    List<Seat> getAllSeats();
    Optional<Seat> getSeatById(Integer id);
    Seat updateSeat(Seat seat);
    void deleteSeat(Integer id);
}
