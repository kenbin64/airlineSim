package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "passenger_type")
@Data
public class PassengerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passengerTypeId;

    @Column(length = 255, nullable = false)
    private String typeDescription;

    @Column(nullable = false)
    private boolean requiresConfirmedSeat;

    @Column(nullable = false)
    private boolean canFlyStandby;

    @Column(nullable = false)
    private int priority;

    // Constructors, Getters, and Setters
    // Lombok's @Data annotation generates these automatically
}

