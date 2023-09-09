package co.edu.uco.carpooling.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DriverRepositoryPostgresSQL extends JpaRepository<DriverEntity, UUID> {
}
