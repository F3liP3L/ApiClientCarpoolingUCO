package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerRepositoryPostgresSQLImpl implements CustomerRepository {
    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return Optional.empty();
    }

    @Override
    public List<CustomerEntity> findAll() {
        return null;
    }

    @Override
    public Optional<CustomerEntity> findByCompanyEmail(String email) {
        return Optional.empty();
    }

    @Override
    public void deleteById(UUID id) {

    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return null;
    }
}



