package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.SeatAssignment;

import java.util.List;
import java.util.Optional;

public interface SeatAssignmentService {
    SeatAssignment assignSeat(Integer flightId, Integer passengerId, String seatPreference);
    Optional<SeatAssignment> getSeatAssignment(Integer assignmentId);
    SeatAssignment changeSeat(Integer assignmentId, String newSeatPreference);
    void cancelSeatAssignment(Integer assignmentId);
    // Additional methods as required for your application
}

