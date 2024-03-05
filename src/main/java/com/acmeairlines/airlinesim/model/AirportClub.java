package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "airport_club")
@Data
public class AirportClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int clubId;

    @ManyToOne
    @JoinColumn(name = "airport_id", referencedColumnName = "airportId")
    private Airport airport;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String locationDescription;

    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private AccessTier accessTier;

    // Constructors, getters, and setters are handled by Lombok's @Data

    public enum AccessTier {
        Bronze, Silver, Gold, Platinum
    }
}

