package com.acmeairlines.airlinesim.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FlightID")
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PassengerID")
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FareID")
    private Fare fare;

    private String seatNumber;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public enum BookingStatus {
        Booked, Checked_in, Boarded, No_Show, Bumped, Standby, Confirmed
    }
}

