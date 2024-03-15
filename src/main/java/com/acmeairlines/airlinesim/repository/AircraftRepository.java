package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Aircraft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AircraftRepository extends JpaRepository<Aircraft, Long> {
}
