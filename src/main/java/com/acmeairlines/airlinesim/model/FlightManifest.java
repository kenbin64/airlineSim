package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "flight_manifest")
public class FlightManifest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer flightManifestId;

    @ManyToOne
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    private ManifestStatus status;
}
