package co.edu.uco.carpooling.repository;

import co.edu.uco.carpooling.entity.DriverEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface Iprueba extends JpaRepository<DriverEntity, UUID> {
}
