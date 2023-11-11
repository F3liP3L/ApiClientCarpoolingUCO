package co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.impl;

import co.edu.uco.carpooling.entity.StatusEntity;
import co.edu.uco.carpooling.infrastructure.adapter.repository.postgressql.StatusPostgresSQL;
import co.edu.uco.carpooling.service.port.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class StatusRepositoryAdapter implements StatusRepository {

    @Autowired
    private StatusPostgresSQL statusPostgresSQL;

    @Override
    public Optional<StatusEntity> findById(UUID uuid) {
        return statusPostgresSQL.findStatusEntitiesById(uuid);
    }
}
