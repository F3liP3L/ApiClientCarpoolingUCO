package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.DriverEntity;

import java.util.Optional;
import java.util.UUID;

public interface DriverRepository {

    Optional<DriverEntity> findById(UUID id);
}
