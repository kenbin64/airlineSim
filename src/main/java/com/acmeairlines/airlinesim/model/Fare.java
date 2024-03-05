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

import java.math.BigDecimal;

@Entity
@Table(name = "fare")
@Data
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fareId;

    @ManyToOne
    @JoinColumn(name = "route_id", referencedColumnName = "routeId")
    private Route route;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private CabinClass cabinClass;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal basePrice;

    // Constructors, getters, and setters are handled by Lombok's @Data

    public enum CabinClass {
        First, Business, PremiumEconomy, Economy
    }
}
