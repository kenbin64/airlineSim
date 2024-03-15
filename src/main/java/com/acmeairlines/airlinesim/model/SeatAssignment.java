package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "seat_assignment")
public class SeatAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatAssignmentId;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "seat_id", nullable = false)
    private Seat seat;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;
}

