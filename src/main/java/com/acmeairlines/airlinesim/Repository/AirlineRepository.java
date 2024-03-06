package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Integer> {
}
