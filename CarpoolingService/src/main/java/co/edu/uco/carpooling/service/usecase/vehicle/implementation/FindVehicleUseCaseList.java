package co.edu.uco.carpooling.service.usecase.vehicle.implementation;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.usecase.UseCaseList;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FindVehicleUseCaseList implements UseCaseList<VehicleDTO> {
    @Override
    public List<VehicleDTO> execute(Optional<VehicleDTO> dto) {
        return null;
    }
}
