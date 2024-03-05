package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftID;

    @ManyToOne
    @JoinColumn(name = "AirlineID", referencedColumnName = "AirlineID")
    private Airline airline;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer totalSeats;

    private Integer firstClassSeats;
    private Integer businessClassSeats;
    private Integer premiumEconomySeats;
    private Integer economySeats;
}

