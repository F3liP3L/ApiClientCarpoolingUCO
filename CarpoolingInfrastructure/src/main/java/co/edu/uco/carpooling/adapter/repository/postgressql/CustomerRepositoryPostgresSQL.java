package co.edu.uco.carpooling.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepositoryPostgresSQL extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findByCompanyEmail(String email);
}
