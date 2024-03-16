package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.SeatAssignment;
import com.acmeairlines.airlinesim.repository.SeatAssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class SeatAssignmentServiceImpl implements SeatAssignmentService {

    private final SeatAssignmentRepository seatAssignmentRepository;

    @Autowired
    public SeatAssignmentServiceImpl(SeatAssignmentRepository seatAssignmentRepository) {
        this.seatAssignmentRepository = seatAssignmentRepository;
    }

    @Override
    public SeatAssignment createSeatAssignment(SeatAssignment seatAssignment) {
        // You might want to include business logic here before saving
        return seatAssignmentRepository.save(seatAssignment);
    }

    @Override
    public Optional<SeatAssignment> getSeatAssignmentById(Integer id) {
        return seatAssignmentRepository.findById(id.longValue());
    }

    @Override
    public List<SeatAssignment> getAllSeatAssignments() {
        return seatAssignmentRepository.findAll();
    }

    @Override
    public SeatAssignment updateSeatAssignment(SeatAssignment seatAssignment) {
        // Check if the seatAssignment exists, among other possible checks
        return seatAssignmentRepository.save(seatAssignment);
    }

    @Override
    public void deleteSeatAssignment(Integer id) {
        // Check if the seatAssignment exists, among other possible validations
        seatAssignmentRepository.deleteById(id.longValue());
    }
}

