package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "AirportClub")
public class AirportClub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer clubId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AirportID")
    private Airport airport;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String locationDescription;

    @Enumerated(EnumType.STRING)
    private AccessTier accessTier;

    public enum AccessTier {
        Bronze,
        Silver,
        Gold,
        Platinum
    }
}
