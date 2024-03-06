package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaggageRepository extends JpaRepository<Baggage, Integer> {
}
