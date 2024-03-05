package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "flight_manifest")
public class FlightManifest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int manifestId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ManifestStatus status;

    public enum ManifestStatus {
        CheckedIn, Boarded, NoShow, Bumped, Standby, Confirmed
    }
}
