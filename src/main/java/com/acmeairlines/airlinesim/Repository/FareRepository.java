package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {
}
