package co.edu.uco.carpooling.service.usecase.driverpervehicle.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.DriverPerVehicleRepository;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.FindDriverPerVehicleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class FindDriverPerVehicleUseCaseImpl implements FindDriverPerVehicleUseCase {
    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;
    @Autowired
    private EntityAssembler<DriverPerVehicleEntity, DriverPerVehicleDomain, DriverPerVehicleDTO> entityAssembler;
    @Override
    public DriverPerVehicleDTO execute(UUID id) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findDriverPerVehicleEntityById(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildUserException("The driver per vehicle with the sent id does not exist");
        }
        return entityAssembler.assembleDTO(response.get());
    }
}
