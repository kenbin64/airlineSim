package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Fare;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.stereotype.Repository;

@Repository
public interface FareRepository extends JpaRepository<Fare, Integer> {

    @Procedure(name = "insert_update_fare")
    void insertOrUpdateFare(Integer fareId, Integer routeId, java.math.BigDecimal amount, String classOfService);
}
