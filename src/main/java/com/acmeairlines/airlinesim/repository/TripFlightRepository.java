package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.TripFlight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripFlightRepository extends JpaRepository<TripFlight, Long> {
}
