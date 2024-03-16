package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
}