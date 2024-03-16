package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "airport")
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer trip_id;

    @OneToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @OneToMany(mappedBy = "trip")
    private Set<TripFlight> tripFlights = new HashSet<>();


}
