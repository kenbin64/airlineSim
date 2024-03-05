package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "baggage")
@Data
public class Baggage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int baggageId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @Column(nullable = false)
    private int numberOfBags;

    @Column(precision = 10, scale = 2)
    private BigDecimal costOfCheckedBags;

    @Column(nullable = false)
    private int maxFreeBaggageAllowed;

    @Column(length = 255)
    private String locationDescription;

    @Column(nullable = false)
    private boolean reportedLostOrStolen;

    @Column(length = 255)
    private String contactAddress;

    @Column(length = 20)
    private String contactPhone;

    @Column(nullable = false)
    private boolean containsPet;

    @Column(nullable = false)
    private boolean containsHumanRemains;

    @Column(nullable = false)
    private boolean hasInsurance;

    @Column(length = 255)
    private String descriptionOfBag;

    @Column(nullable = false)
    private boolean containsFirearms;

    @Column(nullable = false)
    private boolean containsPerishables;

    @Column(nullable = false)
    private boolean containsToxicOrDangerousObjects;
}
