package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
}