package co.edu.uco.carpooling.service.facade.user;

import co.edu.uco.carpooling.service.facade.UpdateUseCaseFacade;

import javax.json.JsonPatch;
import java.util.UUID;

public interface PatchUserUseCaseFacade extends UpdateUseCaseFacade<UUID, JsonPatch> {
}
