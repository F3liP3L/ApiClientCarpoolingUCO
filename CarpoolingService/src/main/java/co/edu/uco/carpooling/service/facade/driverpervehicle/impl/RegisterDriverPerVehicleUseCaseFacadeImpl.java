package co.edu.uco.carpooling.service.facade.driverpervehicle.impl;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.facade.driverpervehicle.RegisterDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.RegisterDriverPerVehicleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDriverPerVehicleUseCaseFacadeImpl implements RegisterDriverPerVehicleUseCaseFacade {

    @Autowired
    DTOAssembler<DriverPerVehicleDTO,DriverPerVehicleDomain> dtoAssembler;
    @Autowired
    RegisterDriverPerVehicleUseCase driverPerVehicleUseCase;

    @Override
    public void execute(DriverPerVehicleDTO dto) {
        DriverPerVehicleDomain domain = dtoAssembler.assembleDomain(dto);
        driverPerVehicleUseCase.execute(domain);
    }
}
