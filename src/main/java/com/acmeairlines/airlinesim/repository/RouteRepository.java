package com.acmeairlines.airlinesim.repository;

import com.acmeairlines.airlinesim.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
    // Define any custom query methods here
}