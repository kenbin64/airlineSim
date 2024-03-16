package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "terminal")
public class TripFlight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trip_flight_id;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @JoinColumn(name = "flight_id")
    private Flight flight;

}
