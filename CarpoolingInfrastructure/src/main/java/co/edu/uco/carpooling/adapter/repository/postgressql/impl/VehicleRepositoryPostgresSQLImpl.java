package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.VehicleRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class VehicleRepositoryPostgresSQLImpl implements VehicleRepository {

    @Override
    public Optional<VehicleEntity> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<VehicleEntity> findAll() {
        return null;
    }

    @Override
    public Optional<VehicleEntity> findByPlate(String plate) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public VehicleEntity save(VehicleEntity entity) {
        return null;
    }
}
