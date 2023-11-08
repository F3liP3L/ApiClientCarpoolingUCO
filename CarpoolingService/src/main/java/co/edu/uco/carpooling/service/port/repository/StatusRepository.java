package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.StatusEntity;

import java.util.Optional;
import java.util.UUID;

public interface StatusRepository {
    Optional<StatusEntity> findById(UUID uuid);
}
