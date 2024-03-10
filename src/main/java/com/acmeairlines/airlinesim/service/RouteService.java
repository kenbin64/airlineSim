package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    Route saveRoute(Route route);
    List<Route> getAllRoutes();
    Optional<Route> getRouteById(Integer id);
    Route updateRoute(Route route);
    void deleteRoute(Integer id);
    // You can add more methods here based on your requirements, like finding routes by origin and destination, etc.
}

