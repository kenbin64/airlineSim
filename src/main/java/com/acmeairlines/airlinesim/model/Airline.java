package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airline")
@Data
public class Airline {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer airlineId;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 3)
    private String icao;

    @Column(nullable = false, length = 3)
    private String iata;

    // Lombok @Data generates constructors, getters, setters, etc.
}

