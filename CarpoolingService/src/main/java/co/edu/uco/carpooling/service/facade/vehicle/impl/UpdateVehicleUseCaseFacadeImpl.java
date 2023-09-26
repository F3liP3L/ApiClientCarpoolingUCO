package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.mapper.json.JsonPatchMapper;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import co.edu.uco.crosscutting.util.UtilNumeric;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonPatch;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
@Slf4j
public class UpdateVehicleUseCaseFacadeImpl implements UpdateVehicleUseCaseFacade {
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private JsonPatchMapper<VehicleEntity> jsonPatchMapper;
    @Autowired
    private EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> entityAssembler;

    @Override
    public void execute(UUID id, JsonPatch json, VehicleDTO dto) {
        Optional<VehicleEntity> response = vehicleRepository.findById(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("There is no vehicle with the submitted identifier.");
        }
        VehicleEntity vehicle = jsonPatchMapper.apply(response.get(), json);
        VehicleDTO vehicleDTO = entityAssembler.assembleDTO(vehicle);
        dto.setCapacity(vehicleDTO.getCapacity());
        isSatisfyBy(vehicle);
        vehicleRepository.save(vehicle);
    }

    private void isSatisfyBy(VehicleEntity vehicle) {
        if (!UtilNumeric.getUtilNumeric().isBetween(vehicle.getCapacity(), 1, 20, true, true)) {
            throw CarpoolingCustomException.buildUserException("The capacity of your vehicle exceeds the maximum amount allowed.");
        }
    }
}
