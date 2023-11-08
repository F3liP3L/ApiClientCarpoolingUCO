package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql;

import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorizedCategoryPostgresSQL extends JpaRepository<AuthorizedCategoryEntity, UUID> {
}
