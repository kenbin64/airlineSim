package com.acmeairlines.airlinesim.Repository;

import com.acmeairlines.airlinesim.model.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteRepository extends JpaRepository<Route, Integer> {
}
