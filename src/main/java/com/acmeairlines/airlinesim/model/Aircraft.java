package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "aircraft")
public class Aircraft {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer aircraftId;

    @ManyToOne
    @JoinColumn(name = "airline_id", nullable = false)
    private Airline airline;

    @Column(nullable = false)
    private String model;

    @Column(nullable = false)
    private Integer totalSeats;
}

