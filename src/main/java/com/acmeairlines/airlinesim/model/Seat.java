package com.acmeairlines.airlinesim.model;

import lombok.Data;
import jakarta.persistence.*;

@Entity
@Data
@Table(name="seat")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer seat_id;

    private Integer aircraft_id; // Consider changing to Aircraft type if you have an Aircraft entity

    private String seat_number;

    @Enumerated(EnumType.STRING)
    private SeatType seat_type; // Enum for SeatType
}