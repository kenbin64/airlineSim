package com.acmeairlines.airlinesim.service;
import com.acmeairlines.airlinesim.model.Route;
import com.acmeairlines.airlinesim.repository.RouteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
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
    public Optional<Route> findRouteById(Integer id) {
        return routeRepository.findById(id.longValue());
    }

    @Override
    public List<Route> findAllRoutes() {
        return routeRepository.findAll();
    }

    @Override
    public void deleteRoute(Integer id) {
        routeRepository.deleteById(id.longValue());
    }
}
