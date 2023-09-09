package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.mapper.json.JsonPatchMapper;
import co.edu.uco.carpooling.service.usecase.vehicle.UpdateVehicleUseCase;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonPatch;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UpdateVehicleUseCaseFacadeImpl implements UpdateVehicleUseCaseFacade {
    @Autowired
    private UpdateVehicleUseCase updateVehicleUseCase;
    @Autowired
    private JsonPatchMapper<VehicleDTO> jsonPatchMapper;
    @Autowired
    private DTOAssembler<VehicleDTO, VehicleDomain> dtoAssembler;

    @Override
    public void execute(UUID id, JsonPatch json, VehicleDTO dto) {
        VehicleDTO vehicle = jsonPatchMapper.apply(dto, json);
        updateVehicleUseCase.execute(id, dtoAssembler.assembleDomain(vehicle));
    }


}
