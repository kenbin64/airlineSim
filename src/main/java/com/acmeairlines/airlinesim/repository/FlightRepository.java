package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Integer> {
    List<Flight> findByRouteIdAndDepartureTimeBetween(Integer routeId, LocalDateTime start, LocalDateTime end);
}
