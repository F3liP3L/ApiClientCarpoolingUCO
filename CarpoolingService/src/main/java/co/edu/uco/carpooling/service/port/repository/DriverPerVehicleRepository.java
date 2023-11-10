package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverPerVehicleRepository {
    Optional<DriverPerVehicleEntity> findDriverPerVehicleEntityById(UUID id);
    Optional<DriverPerVehicleEntity> getVehicleByDriver(UUID idDriver);
    List<DriverPerVehicleEntity> findAll();
    void save(DriverPerVehicleEntity driverPerVehicle);
    void deleteById(UUID id);
}
