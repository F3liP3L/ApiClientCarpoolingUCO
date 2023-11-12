package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.DriverPerVehicleRepositoryPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.DriverPerVehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverPerVehicleRepositoryAdapter implements DriverPerVehicleRepository {
    @Autowired
    private DriverPerVehicleRepositoryPostgresSQL repositoryPostgresSQL;

    @Override
    public Optional<DriverPerVehicleEntity> findDriverPerVehicleEntityById(UUID id) {
        return repositoryPostgresSQL.findDriverPerVehicleEntityById(id);
    }

    @Override
    public List<DriverPerVehicleEntity> findAll() {
        return repositoryPostgresSQL.findAll();
    }

    @Override
    public void save(DriverPerVehicleEntity driverPerVehicle) {
        repositoryPostgresSQL.save(driverPerVehicle);
    }

    @Override
    public void deleteById(UUID id) {
        repositoryPostgresSQL.deleteById(id);
    }
}
