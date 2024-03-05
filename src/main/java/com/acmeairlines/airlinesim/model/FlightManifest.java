package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class FlightManifest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer manifestID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FlightID")
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PassengerID")
    private Passenger passenger;

    @Enumerated(EnumType.STRING)
    private ManifestStatus status;

    public enum ManifestStatus {
        Checked_in, Boarded, No_Show, Bumped, Standby, Confirmed
    }
}

