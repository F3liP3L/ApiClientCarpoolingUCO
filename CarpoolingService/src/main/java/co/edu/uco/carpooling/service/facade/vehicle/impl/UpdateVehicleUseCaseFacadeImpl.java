package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.vehicle.UpdateVehicleUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UpdateVehicleUseCaseFacadeImpl implements UpdateVehicleUseCaseFacade {
    @Autowired
    private UpdateVehicleUseCase updateVehicleUseCase;
    @Autowired
    private DTOAssembler<VehicleDTO, VehicleDomain> dtoAssembler;
    @Override
    public void execute(UUID id, VehicleDTO dto) {
        VehicleDomain domain = dtoAssembler.assembleDomain(dto);
        updateVehicleUseCase.execute(id, domain);
    }
}
