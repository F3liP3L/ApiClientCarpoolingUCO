package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorizedCategoryRepository {
    List<AuthorizedCategoryEntity> findAll();
    Optional<AuthorizedCategoryEntity> findById(UUID uuid);
}
