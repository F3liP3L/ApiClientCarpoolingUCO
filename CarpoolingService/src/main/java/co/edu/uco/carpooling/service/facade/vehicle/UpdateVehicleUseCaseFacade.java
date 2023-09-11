package co.edu.uco.carpooling.service.facade.vehicle;

import co.edu.uco.carpooling.service.facade.UpdateUseCaseFacade;

import javax.json.JsonPatch;
import java.util.UUID;

public interface UpdateVehicleUseCaseFacade extends UpdateUseCaseFacade<UUID,JsonPatch> {
}
