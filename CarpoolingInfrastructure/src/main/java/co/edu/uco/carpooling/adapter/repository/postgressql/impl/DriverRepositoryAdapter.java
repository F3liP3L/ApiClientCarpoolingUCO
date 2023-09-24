package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.DriverRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    @Override
    public Optional<DriverEntity> getDriverByCustomer(UUID idCustomer) {
        return driverRepositoryPostgresSQL.findByCustomerEntityId(idCustomer);
    }

    @Override
    public void deleteById(UUID id) {
        driverRepositoryPostgresSQL.deleteById(id);
    }

    @Override
    public List<DriverEntity> findAllDriver() {
        return driverRepositoryPostgresSQL.findAll();
    }

    @Override
    public void save(DriverEntity driverEntity) {
        driverRepositoryPostgresSQL.save(driverEntity);
    }
}
