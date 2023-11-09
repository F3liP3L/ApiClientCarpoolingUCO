package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.AuthorizedCategoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.AuthorizedCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AuthorizedCategoryAdapter implements AuthorizedCategoryRepository {
    private AuthorizedCategoryPostgresSQL categoryRepository;
    @Override
    public List<AuthorizedCategoryEntity> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<AuthorizedCategoryEntity> findById(UUID uuid) {
        return categoryRepository.findById(uuid);
    }
}
