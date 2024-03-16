package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;


@Entity
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passenger_id;

    private String first_name;
    private String last_name;
    private String passport_number;

    @ManyToMany
    @JoinTable(
            name = "passenger_passenger_type",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "passenger_type_id"))
    private Set<PassengerType> passengerTypes = new HashSet<>();

    // Getters, Setters
}