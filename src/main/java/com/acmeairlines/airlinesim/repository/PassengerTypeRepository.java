package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerTypeRepository extends JpaRepository<PassengerType, Integer> {
}
