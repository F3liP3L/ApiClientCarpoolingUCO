package co.edu.uco.carpooling.service.facade.user;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.facade.UpdateUseCaseFacade;

import java.util.UUID;

public interface UpdateUserFacade extends UpdateUseCaseFacade<UUID,CustomerDTO> {
}
