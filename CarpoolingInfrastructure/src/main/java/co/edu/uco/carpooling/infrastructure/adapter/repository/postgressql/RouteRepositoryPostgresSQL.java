package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.RouteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface RouteRepositoryPostgresSQL extends JpaRepository<RouteEntity, UUID> {
    List<RouteEntity> findRouteEntityByStatusAndRouteTimeGreaterThan(String status, LocalDateTime routeTime);
}
