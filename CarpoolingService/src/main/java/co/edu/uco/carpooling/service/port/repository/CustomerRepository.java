package co.edu.uco.carpooling.service.port.repository;

import co.edu.uco.carpooling.entity.CustomerEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    Optional<CustomerEntity> findById(UUID id);

    List<CustomerEntity> findAll();

    Optional<CustomerEntity> findByCompanyEmail(String email);

    void deleteById(UUID id);

    CustomerEntity save(CustomerEntity entity);


}
