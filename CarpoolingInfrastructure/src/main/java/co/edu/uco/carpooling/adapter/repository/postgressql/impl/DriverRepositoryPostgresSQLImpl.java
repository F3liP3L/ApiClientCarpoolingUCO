package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.DriverRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public class DriverRepositoryPostgresSQLImpl implements DriverRepository {
    @Autowired
    private DriverRepositoryPostgresSQL repositoryPostgresSQL;
    @Override
    public Optional<DriverEntity> findById(UUID id) {
        return repositoryPostgresSQL.findById(id);
    }
}
