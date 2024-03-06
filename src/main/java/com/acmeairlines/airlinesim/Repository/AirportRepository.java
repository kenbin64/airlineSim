package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Integer> {
}
