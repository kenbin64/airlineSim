package com.acmeairlines.airlinesim.service;
import com.acmeairlines.airlinesim.model.Route;
import java.util.List;
import java.util.Optional;

public interface RouteService {
    Route saveRoute(Route route);
    Optional<Route> findRouteById(Integer id);
    List<Route> findAllRoutes();
    void deleteRoute(Integer id);
}
