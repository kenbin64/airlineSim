package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Booking;
import com.acmeairlines.airlinesim.repository.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;

    @Autowired
    public BookingServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking saveBooking(Booking booking) {
        // Additional business logic before saving can be added here
        return bookingRepository.save(booking);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    @Override
    public Booking updateBooking(Booking booking) {
        // Make sure the booking exists and is valid before updating
        if (booking != null && booking.getBookingID() != null && bookingRepository.existsById(booking.getBookingID())) {
            return bookingRepository.save(booking);
        } else {
            // Handle the case where the booking is null or doesn't exist
            throw new IllegalArgumentException("Booking is null or does not exist.");
        }
    }

    @Override
    public void deleteBooking(Integer id) {
        // Ensure the booking exists before attempting to delete
        if (bookingRepository.existsById(id)) {
            bookingRepository.deleteById(id);
        } else {
            // Handle the case where the booking does not exist
            throw new IllegalArgumentException("Booking with id " + id + " does not exist.");
        }
    }
}

