package co.edu.uco.carpooling.service.facade.driverpervehicle;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.service.facade.PatchUseCaseFacade;

import javax.json.JsonPatch;
import java.util.UUID;

public interface UpdateDriverPerVehicleUseCaseFacade extends PatchUseCaseFacade<UUID, JsonPatch, DriverPerVehicleDTO> {
}
