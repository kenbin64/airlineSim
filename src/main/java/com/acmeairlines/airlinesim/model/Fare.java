package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
@Table(name = "fare")
public class Fare {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fareId;

    @Column(name = "route_id")
    private Integer routeId;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_of_service", nullable = false)
    private ClassOfService classOfService;

    public enum ClassOfService {
        First, Business, Premium_Economy, Economy
    }
}
