package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.adapter.repository.VehicleRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.mapper.json.JsonPatchMapper;
import co.edu.uco.carpooling.service.usecase.vehicle.UpdateVehicleUseCase;
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
    private UpdateVehicleUseCase updateVehicleUseCase;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private JsonPatchMapper<VehicleEntity> jsonPatchMapper;

    @Autowired
    private EntityAssembler<VehicleEntity,VehicleDomain, VehicleDTO> entityAssembler;

    @Override
    public void execute(UUID id, JsonPatch domain) {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(id);
        if (vehicle.isPresent()) {
            VehicleEntity vehiclePatch = jsonPatchMapper.apply(vehicle.get(), domain);
            log.info(vehiclePatch.toString());
            vehicleRepository.save(vehiclePatch);
        } else {
            throw CarpoolingCustomException.buildUserException("No se encontro vehiculo que actualizar.");
        }
        //vehicle.ifPresent(vehicleEntity -> updateVehicleUseCase.execute(id, entityAssembler.assembleDomain(patch(vehicleEntity, domain))));
    }

    /*
    private VehicleEntity applyPatch(JsonPatch patch, VehicleEntity vehicle) {
        try {
            var objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(vehicle, JsonNode.class));
            return objectMapper.treeToValue(patched, VehicleEntity.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw new RuntimeException("Error al aplicar el patch");
        }

    }*/

    /*
    private VehicleEntity patch(VehicleEntity vehicle, JsonPatch jsonPatch) {
        return UtilObjectMapper.getUtilObjectMapper().patch(jsonPatch, vehicle, VehicleEntity.class);
    }*/


}
