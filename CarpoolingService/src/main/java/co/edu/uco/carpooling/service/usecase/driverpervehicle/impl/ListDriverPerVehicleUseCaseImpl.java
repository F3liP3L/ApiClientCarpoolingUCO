package co.edu.uco.carpooling.service.usecase.driverpervehicle.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.DriverPerVehicleRepository;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.ListDriverPerVehicleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ListDriverPerVehicleUseCaseImpl implements ListDriverPerVehicleUseCase {
    @Autowired
    private EntityAssembler<DriverPerVehicleEntity, DriverPerVehicleDomain,DriverPerVehicleDTO> entityAssembler;
    @Autowired
    private DriverPerVehicleRepository repository;
    @Override
    public List<DriverPerVehicleDTO> execute(Optional<DriverPerVehicleDTO> dto) {
        if (dto.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Can not find the customer, please try again");
        }
        return repository.getVehicleByDriver(dto.get().getDriver().getId())
                .map(driverPerVehicleEntity -> entityAssembler.assembleDTO(driverPerVehicleEntity)).stream().toList();
    }
}
