package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.DeleteVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.vehicle.DeleteVehicleUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class DeleteVehicleUseCaseFacadeImpl implements DeleteVehicleUseCaseFacade {
    @Autowired
    private DeleteVehicleUseCase deleteVehicleUseCase;
    @Autowired
    private DTOAssembler<VehicleDTO, VehicleDomain> dtoAssembler;
    @Override
    public void execute(VehicleDTO dto) {
        deleteVehicleUseCase.execute(dtoAssembler.assembleDomain(dto));
    }


}
