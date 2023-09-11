package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.DriverEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface DriverRepository {
    Optional<DriverEntity> findById(UUID id);
    Optional<DriverEntity> getDriverByCustomer(UUID idCustomer);
    void deleteById(UUID id);
    List<DriverEntity> findAllDriver();
    void save(DriverEntity driverEntity);
}
