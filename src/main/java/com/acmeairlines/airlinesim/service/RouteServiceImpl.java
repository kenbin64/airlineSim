package com.acmeairlines.airlinesim.service;

import com.acmeairlines.airlinesim.Repository.RouteRepository;
import com.acmeairlines.airlinesim.model.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
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
        return routeRepository.save(route);
    }

    @Override
    public Optional<Route> getRouteById(Long id) {
        return routeRepository.findById(id.intValue());
    }

    @Override
    public List<Route> getAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public Route updateRoute(Long id, Route routeDetails) {
        Route route = routeRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found for this id :: " + id));

        route.setDepartureAirport(routeDetails.getDepartureAirport());
        route.setArrivalAirport(routeDetails.getArrivalAirport());
        route.setDistanceMiles(routeDetails.getDistanceMiles());


        return routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        Route route = routeRepository.findById(id.intValue())
                .orElseThrow(() -> new ResourceNotFoundException("Route not found for this id :: " + id));
        routeRepository.delete(route);
    }
}

