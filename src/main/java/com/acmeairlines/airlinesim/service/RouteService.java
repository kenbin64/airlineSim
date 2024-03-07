package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {

    Route saveRoute(Route route);

    Optional<Route> getRouteById(Long id);

    List<Route> getAllRoutes();

    Route updateRoute(Long id, Route routeDetails);

    void deleteRoute(Long id);
}
