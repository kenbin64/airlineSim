package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name="flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightId;

    @ManyToOne
    @JoinColumn(name = "route_id", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @Column(nullable = false)
    private LocalDateTime departureTime;

    @Column(nullable = false)
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightStatus status; // Assuming an enum for statuses like On Time, Delayed, Cancelled

    private String delayReason;

    @ManyToOne
    @JoinColumn(name = "terminal_id", nullable = true) // Assuming a flight might not always have a terminal assigned
    private Terminal terminal;

    @ManyToOne
    @JoinColumn(name = "gate_id", nullable = true) // Assuming a flight might not always have a gate assigned
    private Gate gate;

    // Constructors, getters, and setters
}


