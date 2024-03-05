package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Route")
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer routeID;

    @ManyToOne
    @JoinColumn(name = "DepartureAirportID", referencedColumnName = "AirportID")
    private Airport departureAirport;

    @ManyToOne
    @JoinColumn(name = "ArrivalAirportID", referencedColumnName = "AirportID")
    private Airport arrivalAirport;

    private Integer distanceMiles;
}
