package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.AuthorizedCategoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.AuthorizedCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorizedCategoryAdapter implements AuthorizedCategoryRepository {
    @Autowired
    private AuthorizedCategoryPostgresSQL categoryPostgresSQL;
    @Override
    public List<AuthorizedCategoryEntity> findAll() {
        return categoryPostgresSQL.findAll();
    }
}
