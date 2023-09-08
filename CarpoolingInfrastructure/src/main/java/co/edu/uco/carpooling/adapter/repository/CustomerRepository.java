package co.edu.uco.carpooling.adapter.repository;

import co.edu.uco.carpooling.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    @Query(value = "SELECT * FROM public.customer WHERE phone = ?1", nativeQuery = true)
    Optional<CustomerEntity> findPhone(int phone);

    @Query(value = "SELECT * FROM public.customer WHERE dni = ?1", nativeQuery = true)
    Optional<CustomerEntity> findDni(String dni);

    @Query(value = "SELECT * FROM public.customer WHERE email = ?1", nativeQuery = true)
    Optional<CustomerEntity> findEmail(String email);
}
