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
        return bookingRepository.save(booking);
    }

    @Override
    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking updateBooking(Integer id, Booking bookingDetails) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found for this id :: " + id));
        booking.setPassenger(bookingDetails.getPassenger());
        booking.setFare(bookingDetails.getFare());
        booking.setBooking_date(bookingDetails.getBooking_date());
        booking.setIs_valid(bookingDetails.getIs_valid());
        final Booking updatedBooking = bookingRepository.save(booking);
        return updatedBooking;
    }

    @Override
    public void deleteBooking(Integer id) {
        Booking booking = bookingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Booking not found for this id :: " + id));
        bookingRepository.delete(booking);
    }
}
