package com.acmeairlines.airlinesim.model;

public enum ManifestStatus {
    BOOKED,         // Passenger has booked but not yet checked in
    CHECKED_IN,     // Passenger has checked in for the flight
    BOARDED,        // Passenger has boarded the flight
    NO_SHOW,        // Passenger did not show up for the flight
    COMPLETED       // Passenger completed the flight
}