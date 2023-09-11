package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.DriverRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DriverRepositoryAdapter implements DriverRepository {

    @Autowired
    private DriverRepositoryPostgresSQL driverRepositoryPostgresSQL;

    @Override
    public Optional<DriverEntity> findById(UUID id) {
        return driverRepositoryPostgresSQL.findById(id);
    }
}
