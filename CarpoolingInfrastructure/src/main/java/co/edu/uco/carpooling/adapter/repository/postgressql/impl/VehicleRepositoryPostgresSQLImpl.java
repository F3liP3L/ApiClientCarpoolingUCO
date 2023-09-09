package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.VehicleRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository
public class VehicleRepositoryPostgresSQLImpl implements VehicleRepository {
    @Autowired
    private VehicleRepositoryPostgresSQL repositoryPostgresSQL;

    @Override
    public Optional<VehicleEntity> findById(UUID id) {
        return repositoryPostgresSQL.findById(id);
    }

    @Override
    public List<VehicleEntity> findAll() {
        return repositoryPostgresSQL.findAll();
    }

    @Override
    public Optional<VehicleEntity> findByPlate(String plate) {
        return repositoryPostgresSQL.findByPlate(plate);
    }

    @Override
    public void deleteById(UUID id) {
        repositoryPostgresSQL.deleteById(id);
    }

    @Override
    public VehicleEntity save(VehicleEntity entity) {
        return repositoryPostgresSQL.save(entity);
    }
}
