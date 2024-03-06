package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.PassengerType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerTypeRepository extends JpaRepository<PassengerType, Integer> {
}