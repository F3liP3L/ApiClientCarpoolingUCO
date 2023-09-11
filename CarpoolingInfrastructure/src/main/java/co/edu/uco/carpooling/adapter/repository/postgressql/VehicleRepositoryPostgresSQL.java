package co.edu.uco.carpooling.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface VehicleRepositoryPostgresSQL extends JpaRepository<VehicleEntity, UUID> {
    Optional<VehicleEntity> findByPlate(String plate);
}
