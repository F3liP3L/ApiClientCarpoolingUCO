package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.VehicleRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleRepositoryAdapter implements VehicleRepository {
    @Autowired
    private VehicleRepositoryPostgresSQL vehicleRepositoryPostgresSQL;

    @Override
    public Optional<VehicleEntity> findById(UUID id) {
        return vehicleRepositoryPostgresSQL.findById(id);
    }

    @Override
    public List<VehicleEntity> findAll() {
        return vehicleRepositoryPostgresSQL.findAll();
    }

    @Override
    public Optional<VehicleEntity> findByPlate(String plate) {
        return vehicleRepositoryPostgresSQL.findByPlate(plate);
    }

    @Override
    public void deleteById(UUID id) {
        vehicleRepositoryPostgresSQL.deleteById(id);
    }

    @Override
    public VehicleEntity save(VehicleEntity entity) {
        return vehicleRepositoryPostgresSQL.save(entity);
    }
}
