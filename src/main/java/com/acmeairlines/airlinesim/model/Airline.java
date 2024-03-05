package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airlineID;

    @Column(nullable = false)
    private String name;

    private String icao;

    @Column(nullable = false, length = 3)
    private String iata;
}
