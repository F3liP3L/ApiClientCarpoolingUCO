package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;

import java.util.List;

public interface AuthorizedCategoryRepository {
    List<AuthorizedCategoryEntity> findAll();
}
