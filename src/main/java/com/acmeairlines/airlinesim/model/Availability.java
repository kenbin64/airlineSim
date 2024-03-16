package com.acmeairlines.airlinesim.model;

public enum Availability {
    AVAILABLE("Available"),
    BOOKED("Booked");

    private final String status;

    Availability(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}