package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking saveBooking(Booking booking);
    List<Booking> getAllBookings();
    Optional<Booking> getBookingById(Integer id);
    Booking updateBooking(Booking booking);
    void deleteBooking(Integer id);
    // You can add more methods here depending on your application's requirements, like finding bookings by customer ID, etc.
}
