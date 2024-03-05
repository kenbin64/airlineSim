package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Data
@Table(name = "Flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightID;

    @ManyToOne
    @JoinColumn(name = "RouteID", referencedColumnName = "RouteID")
    private Route route;

    @ManyToOne
    @JoinColumn(name = "AircraftID", referencedColumnName = "AircraftID")
    private Aircraft aircraft;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date departureTime;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date arrivalTime;

    private String terminal;
    private String gate;
}

