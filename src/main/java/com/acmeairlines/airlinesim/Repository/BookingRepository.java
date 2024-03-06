package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
}
