package co.edu.uco.carpooling.service.facade.vehicle;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.facade.UpdateUseCaseFacade;

import java.util.UUID;

public interface UpdateVehicleUseCaseFacade extends UpdateUseCaseFacade<UUID, VehicleDTO> {
}
