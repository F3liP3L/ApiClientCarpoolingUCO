package co.edu.uco.carpooling.adapter.repository;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import co.edu.uco.carpooling.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<DriverEntity, UUID> {

    @Query(value = "SELECT * FROM public.driver WHERE customer_id = ?1", nativeQuery = true)
    Optional<DriverEntity> getDriverByCustomer(UUID customerId);

    @Query(value = "SELECT * FROM public.authorized_category WHERE  id = ?1", nativeQuery = true)
    Optional<AuthorizedCategoryEntity> getAuthorizedCategory(UUID id);
}
