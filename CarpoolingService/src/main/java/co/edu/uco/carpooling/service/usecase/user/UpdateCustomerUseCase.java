package co.edu.uco.carpooling.service.usecase.user;

import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.usecase.UpdateUseCase;

import java.util.UUID;

public interface UpdateCustomerUseCase extends UpdateUseCase<UUID,CustomerDomain> {
}
