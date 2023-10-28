package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.RouteEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface RouteRepository {
    void save(RouteEntity route);
    List<RouteEntity> findRouteActive();
    Optional<RouteEntity> findByRoute(UUID id);

}
