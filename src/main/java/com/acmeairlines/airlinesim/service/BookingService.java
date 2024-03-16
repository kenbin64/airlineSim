package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {
    Booking saveBooking(Booking booking);
    Optional<Booking> getBookingById(Integer id);
    List<Booking> getAllBookings();
    Booking updateBooking(Integer id, Booking bookingDetails);
    void deleteBooking(Integer id);
}
