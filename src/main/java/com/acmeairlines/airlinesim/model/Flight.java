package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "flight")
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    private String delayReason;

    @ManyToOne
    @JoinColumn(name = "terminal_id")
    private Terminal terminal;

    @ManyToOne
    @JoinColumn(name = "gate_id")
    private Gate gate;
}
