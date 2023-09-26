package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepositoryPostgresSQL extends JpaRepository<CustomerEntity, UUID> {
    Optional<CustomerEntity> findByCompanyEmail(String email);
    Optional<CustomerEntity> findByDni(String dni);
    Optional<CustomerEntity> findByPhone(int phone);
}
