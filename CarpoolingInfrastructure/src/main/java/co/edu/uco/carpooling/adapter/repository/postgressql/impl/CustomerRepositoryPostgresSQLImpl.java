package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.adapter.repository.postgressql.CustomerRepositoryPostgresSQL;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class CustomerRepositoryPostgresSQLImpl implements CustomerRepository {

    @Autowired
    private CustomerRepositoryPostgresSQL repositoryPostgresSQL;
    @Override
    public Optional<CustomerEntity> findById(UUID id) {
        return repositoryPostgresSQL.findById(id);
    }

    @Override
    public List<CustomerEntity> findAll() {
        return repositoryPostgresSQL.findAll();
    }

    @Override
    public Optional<CustomerEntity> findByCompanyEmail(String email) {
        return repositoryPostgresSQL.findByCompanyEmail(email);
    }

    @Override
    public void deleteById(UUID id) {
        repositoryPostgresSQL.deleteById(id);
    }

    @Override
    public CustomerEntity save(CustomerEntity entity) {
        return repositoryPostgresSQL.save(entity);
    }
}
