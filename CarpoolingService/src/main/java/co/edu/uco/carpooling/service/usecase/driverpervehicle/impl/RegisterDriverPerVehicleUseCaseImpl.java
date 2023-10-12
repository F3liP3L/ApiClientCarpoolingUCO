package co.edu.uco.carpooling.service.usecase.driverpervehicle.impl;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.DriverPerVehicleRepository;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.RegisterDriverPerVehicleUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterDriverPerVehicleUseCaseImpl implements RegisterDriverPerVehicleUseCase {
    @Autowired
    private EntityAssembler<DriverPerVehicleEntity, DriverPerVehicleDomain, DriverPerVehicleDTO> entityAssembler;
    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;

    @Override
    public void execute(DriverPerVehicleDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        DriverPerVehicleEntity driverPerVehicleEntity = entityAssembler.assembleEntity(domain);
        driverPerVehicleRepository.save(driverPerVehicleEntity);
    }
}
