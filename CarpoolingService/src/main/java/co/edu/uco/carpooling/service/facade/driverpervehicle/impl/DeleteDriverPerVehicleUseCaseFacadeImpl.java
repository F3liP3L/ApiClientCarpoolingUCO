package co.edu.uco.carpooling.service.facade.driverpervehicle.impl;

import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.facade.driverpervehicle.DeleteDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.driverpervehicle.DeleteDriverPerVehicleUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDriverPerVehicleUseCaseFacadeImpl implements DeleteDriverPerVehicleUseCaseFacade {
    @Autowired
    private DTOAssembler<DriverPerVehicleDTO, DriverPerVehicleDomain> dtoAssembler;
    @Autowired
    private DeleteDriverPerVehicleUseCase driverPerVehicleUseCase;

    @Override
    public void execute(DriverPerVehicleDTO domain) {
        driverPerVehicleUseCase.execute(dtoAssembler.assembleDomain(domain));
    }
}
