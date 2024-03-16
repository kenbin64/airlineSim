package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripRepository extends JpaRepository<Trip, Integer> {
}


