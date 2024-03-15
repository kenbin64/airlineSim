package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "route_id")
    private Integer routeId;

    @ManyToOne
    @JoinColumn(name = "origin_airport_id", referencedColumnName = "airport_id")
    private Airport originAirport;

    @ManyToOne
    @JoinColumn(name = "destination_airport_id", referencedColumnName = "airport_id")
    private Airport destinationAirport;

    // Constructors, getters, and setters
    // Lombok @Data annotation generates these
}


