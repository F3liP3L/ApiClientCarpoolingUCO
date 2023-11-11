package co.edu.uco.carpooling.service.usecase.driverpervehicle;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.service.usecase.FindUseCase;

import java.util.UUID;

public interface FindDriverPerVehicleUseCase extends FindUseCase<DriverPerVehicleDTO, UUID> {
}
