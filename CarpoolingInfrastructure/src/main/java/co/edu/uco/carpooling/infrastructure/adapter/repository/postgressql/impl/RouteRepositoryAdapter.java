package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.RouteEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.RouteRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RouteRepositoryAdapter implements RouteRepository {
    private static final String STATUS_SAVE = "Activa";
    @Autowired
    private RouteRepositoryPostgresSQL routeRepository;
    @Override
    public void save(RouteEntity route) {
        routeRepository.save(route);
    }

    @Override
    public List<RouteEntity> findRouteActive() {
        return routeRepository.findRouteEntityByStatusAndRouteTimeGreaterThan(STATUS_SAVE, LocalDateTime.now());
    }

    @Override
    public Optional<RouteEntity> findByRoute(UUID id) {
        return routeRepository.findById(id);
    }
}
