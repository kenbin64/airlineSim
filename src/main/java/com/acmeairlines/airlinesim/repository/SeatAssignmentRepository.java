package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.SeatAssignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SeatAssignmentRepository extends JpaRepository<SeatAssignment, Integer> {
    // Define any custom query methods here
}
