package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "frequent_flyer_account")
@Data
public class FrequentFlyerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int frequentFlyerId;

    @ManyToOne
    @JoinColumn(name = "airline_id", referencedColumnName = "airlineId")
    private Airline airline;

    @Column(nullable = false)
    private int points = 0;

    @Column(name = "priority_points", nullable = false)
    private int priorityPoints = 0;

    @Column(nullable = false)
    private boolean active = true;

    @Column(length = 255)
    private String comments;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tier tier;

    // Enum for frequent flyer tiers
    public enum Tier {
        BRONZE, SILVER, GOLD, PLATINUM
    }

    // Constructors, getters, and setters are managed by Lombok's @Data
}

