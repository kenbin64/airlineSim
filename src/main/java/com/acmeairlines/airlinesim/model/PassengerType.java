package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@Table(name="passenger_type")
public class PassengerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer passenger_type_id;

    private String description;
    private String code;

    @ManyToMany(mappedBy = "passengerTypes")
    private Set<Passenger> passengers = new HashSet<>();
}
