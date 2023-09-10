package co.edu.uco.carpooling.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepositoryJpa extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByCompanyEmail(String email);
}
