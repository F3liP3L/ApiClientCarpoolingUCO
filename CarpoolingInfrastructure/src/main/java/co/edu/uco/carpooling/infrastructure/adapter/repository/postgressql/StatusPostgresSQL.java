package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface StatusPostgresSQL extends JpaRepository<StatusEntity, UUID> {
    Optional<StatusEntity> findStatusEntitiesById(UUID uuid);
}
