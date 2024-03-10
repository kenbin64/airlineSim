package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    // Define any custom query methods here
}
