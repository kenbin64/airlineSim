package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Data
@Entity
@Table(name = "seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seatId;

    @ManyToOne
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @Column(nullable = false)
    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private SeatType seatType;
}