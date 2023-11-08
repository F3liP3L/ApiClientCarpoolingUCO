package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthorizedCategoryPostgresSQL extends JpaRepository<AuthorizedCategoryEntity, UUID> {
}
