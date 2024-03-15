package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Long> {
}
