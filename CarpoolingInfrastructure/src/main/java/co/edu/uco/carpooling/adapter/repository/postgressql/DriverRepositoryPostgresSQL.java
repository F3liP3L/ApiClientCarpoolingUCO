package co.edu.uco.carpooling.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DriverRepositoryPostgresSQL extends JpaRepository<DriverEntity, UUID> {
}