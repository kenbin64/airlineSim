package com.acmeairlines.airlinesim.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "FrequentFlyerAccount")
public class FrequentFlyerAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer frequentFlyerId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AirlineID", nullable = false)
    private Airline airline;

    @Column(nullable = false)
    private Integer points;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Tier tier;

    public enum Tier {
        BRONZE, SILVER, GOLD, PLATINUM
    }
}
