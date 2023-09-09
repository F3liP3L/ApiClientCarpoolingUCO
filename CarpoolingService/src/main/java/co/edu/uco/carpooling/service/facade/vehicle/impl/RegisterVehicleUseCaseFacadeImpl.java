package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.RegisterVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.vehicle.RegisterVehicleUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterVehicleUseCaseFacadeImpl implements RegisterVehicleUseCaseFacade {
    @Autowired
    private RegisterVehicleUseCase registerVehicleUseCase;
    @Autowired
    private DTOAssembler<VehicleDTO, VehicleDomain> dtoAssembler;
    @Override
    public void execute(VehicleDTO dto) {
        try {
            dto.setId(UtilUUID.getNewUUID());
            VehicleDomain vehicle = dtoAssembler.assembleDomain(dto);
            registerVehicleUseCase.execute(vehicle);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        }
    }
}
