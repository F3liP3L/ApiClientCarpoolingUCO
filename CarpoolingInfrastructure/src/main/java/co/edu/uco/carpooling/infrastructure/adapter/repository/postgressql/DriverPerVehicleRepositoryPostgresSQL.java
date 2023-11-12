package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverPerVehicleRepositoryPostgresSQL extends JpaRepository<DriverPerVehicleEntity, UUID> {
    Optional<DriverPerVehicleEntity> findDriverPerVehicleEntityById(UUID id);
}
