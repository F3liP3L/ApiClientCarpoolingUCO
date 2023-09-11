package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.VehicleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VehicleRepository {

    Optional<VehicleEntity> findById(UUID id);

    List<VehicleEntity> findAll();

    Optional<VehicleEntity> findByPlate(String plate);

    void deleteById(UUID id);

    VehicleEntity save(VehicleEntity entity);
}
