package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.model.Route;
import com.acmeairlines.airlinesim.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    @Override
    public Route saveRoute(Route route) {
        // Additional logic or validations can be added here if necessary before saving the route
        return routeRepository.save(route);
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Optional<Route> getRouteById(Integer id) {
        return routeRepository.findById(id);
    }

    @Override
    public Route updateRoute(Route route) {
        // Ensure the route exists and is valid before updating
        if (route != null && route.getRouteID() != null && routeRepository.existsById(route.getRouteID())) {
            return routeRepository.save(route);
        } else {
            // Handle the case where the route is null or does not exist
            throw new IllegalArgumentException("Route is null or does not exist.");
        }
    }

    @Override
    public void deleteRoute(Integer id) {
        // Ensure the route exists before attempting deletion
        if (routeRepository.existsById(id)) {
            routeRepository.deleteById(id);
        } else {
            // Handle the case where the route does not exist
            throw new IllegalArgumentException("Route with id " + id + " does not exist.");
        }
    }
}

