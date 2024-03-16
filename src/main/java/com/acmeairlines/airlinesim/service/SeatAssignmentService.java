package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.SeatAssignment;

import java.util.List;
import java.util.Optional;

import java.util.List;
import java.util.Optional;

public interface SeatAssignmentService {

    SeatAssignment createSeatAssignment(SeatAssignment seatAssignment);

    Optional<SeatAssignment> getSeatAssignmentById(Integer id);

    List<SeatAssignment> getAllSeatAssignments();

    SeatAssignment updateSeatAssignment(SeatAssignment seatAssignment);

    void deleteSeatAssignment(Integer id);
}


