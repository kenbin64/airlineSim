package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Gate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GateRepository extends JpaRepository<Gate, Integer> {
}
