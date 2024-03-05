package com.acmeairlines.airlinesim.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "flight")
@Data
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int flightId;


    @OneToMany(mappedBy = "flight", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<StandbyPriorityList> standbyPriorityLists = new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", referencedColumnName = "routeId")
    private Route route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aircraft_id", referencedColumnName = "aircraftId")
    private Aircraft aircraft;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private FlightStatus status;

    @Column(length = 5)
    private String terminal;

    @Column(length = 5)
    private String gate;

    @Column(name = "reason_for_delay_or_cancel", length = 255)
    private String reasonForDelayOrCancel;

    // Enum for flight status
    public enum FlightStatus {
        ON_TIME, DELAYED, CANCELLED
    }

    // Constructors, getters, and setters are managed by Lombok's @Data
}

