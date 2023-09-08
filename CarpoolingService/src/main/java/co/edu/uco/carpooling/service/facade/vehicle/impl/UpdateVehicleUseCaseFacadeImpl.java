package co.edu.uco.carpooling.service.facade.vehicle.impl;

import co.edu.uco.carpooling.adapter.repository.VehicleRepository;
import co.edu.uco.carpooling.crosscutting.util.UtilObjectMapper;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.facade.vehicle.UpdateVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.usecase.vehicle.UpdateVehicleUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.json.JsonPatch;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UpdateVehicleUseCaseFacadeImpl implements UpdateVehicleUseCaseFacade {
    @Autowired
    private UpdateVehicleUseCase updateVehicleUseCase;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private EntityAssembler<VehicleEntity,VehicleDomain, VehicleDTO> entityAssembler;
    @Override
    public void execute(UUID id, JsonPatch domain) {
        Optional<VehicleEntity> vehicle = vehicleRepository.findById(id);
        vehicle.ifPresent(vehicleEntity -> updateVehicleUseCase.execute(id, entityAssembler.assembleDomain(patch(vehicleEntity, domain))));
    }

    /*
    private VehicleDomain applyPatch(JsonPatch patch, VehicleDomain vehicle) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode patched = patch.apply(objectMapper.convertValue(vehicle, JsonNode.class));
            return objectMapper.treeToValue(patched, VehicleDomain.class);
        } catch (JsonPatchException | JsonProcessingException e) {
            throw CarpoolingCustomException.buildTechnicalException("");
        }
    }*/

    private VehicleEntity patch(VehicleEntity vehicle, JsonPatch jsonPatch) {
        return UtilObjectMapper.getUtilObjectMapper().patch(jsonPatch, vehicle, VehicleEntity.class);
    }


}
