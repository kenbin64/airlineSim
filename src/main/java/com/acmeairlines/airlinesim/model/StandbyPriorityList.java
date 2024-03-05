package com.acmeairlines.airlinesim.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "standby_priority_list")
@Data
public class StandbyPriorityList {
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id")
    private Flight flight;

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @Column(nullable = false)
    private int priority;

    // Constructors, getters, and setters...

    public StandbyPriorityList() {
    }

    // Getters and setters...
}
