package co.edu.uco.carpooling.service.facade.vehicle;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.facade.PatchUseCaseFacade;

import javax.json.JsonPatch;
import java.util.UUID;

public interface UpdateVehicleUseCaseFacade extends PatchUseCaseFacade<UUID,JsonPatch, VehicleDTO> {
}
