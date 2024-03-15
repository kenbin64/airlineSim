package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "airline")
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id")
    private Integer airlineId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 3)
    private String icao;

    @Column(nullable = false, length = 3)
    private String iata;

}


