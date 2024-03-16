package com.acmeairlines.airlinesim.service;
import com.acmeairlines.airlinesim.model.Seat;
import com.acmeairlines.airlinesim.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository){

        this.seatRepository = seatRepository;
    }

    @Override
    public Seat saveSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public List<Seat> getAllSeats() {
        return seatRepository.findAll();
    }

    @Override
    public Optional<Seat> getSeatById(Integer id) {
        return seatRepository.findById(id.longValue());
    }

    @Override
    public Seat updateSeat(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public void deleteSeat(Integer id) {

        Optional<Seat> seat = seatRepository.findById(id.longValue());
        seatRepository.delete(seat.get());
    }
}

