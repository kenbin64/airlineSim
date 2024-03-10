package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
    // Define any custom query methods here
}
