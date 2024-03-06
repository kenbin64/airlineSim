package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
}