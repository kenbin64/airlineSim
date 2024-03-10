package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Integer> {
    // Define any custom query methods here
}