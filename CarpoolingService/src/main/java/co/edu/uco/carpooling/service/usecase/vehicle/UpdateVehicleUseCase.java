package co.edu.uco.carpooling.service.usecase.vehicle;

import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.usecase.UpdateUseCase;

import java.util.UUID;

public interface UpdateVehicleUseCase extends UpdateUseCase<UUID, VehicleDomain> {
}
