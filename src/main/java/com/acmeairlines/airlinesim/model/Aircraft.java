package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "aircraft")
@Data
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aircraftId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airline_id")
    private Airline airline;

    @Column(nullable = false, length = 255)
    private String model;

    @Column(name = "total_seats", nullable = false)
    private int totalSeats;

    @Column(name = "first_class_seats")
    private Integer firstClassSeats; // Nullable, hence Integer

    @Column(name = "business_class_seats")
    private Integer businessClassSeats; // Nullable, hence Integer

    @Column(name = "premium_economy_seats")
    private Integer premiumEconomySeats; // Nullable, hence Integer

    @Column(name = "economy_seats")
    private Integer economySeats; // Nullable, hence Integer

    // Constructors, getters, and setters are managed by Lombok's @Data
}
