package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.CustomerRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class CustomerRepositoryAdapter implements CustomerRepository {

    @Autowired
    private CustomerRepositoryPostgresSQL customerRepositoryPostgresSQL;
    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return customerRepositoryPostgresSQL.findById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return customerRepositoryPostgresSQL.findAll();
    }

    @Override
    public Optional<CustomerEntity> findByCompanyEmail(String email) {
        return customerRepositoryPostgresSQL.findByCompanyEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        customerRepositoryPostgresSQL.deleteById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return customerRepositoryPostgresSQL.save(entity);
    }

    @Override
    public Optional<CustomerEntity> findDni(String dni) {
        return customerRepositoryPostgresSQL.findByDni(dni);
    }

    @Override
    public Optional<CustomerEntity> findPhone(int phone) {
        return Optional.empty();
    }
}



