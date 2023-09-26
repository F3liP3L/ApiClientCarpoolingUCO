package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepositoryPostgresSQL extends JpaRepository<DriverEntity, UUID> {
    Optional<DriverEntity> findByCustomerEntityId(UUID id);
}
