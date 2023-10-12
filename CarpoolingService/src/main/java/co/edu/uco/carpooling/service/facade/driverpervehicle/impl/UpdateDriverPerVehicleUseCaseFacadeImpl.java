package co.edu.uco.carpooling.service.facade.driverpervehicle.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.DriverPerVehicleDTO;
import co.edu.uco.carpooling.entity.DriverPerVehicleEntity;
import co.edu.uco.carpooling.service.domain.DriverPerVehicleDomain;
import co.edu.uco.carpooling.service.facade.driverpervehicle.UpdateDriverPerVehicleUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.mapper.json.JsonPatchMapper;
import co.edu.uco.carpooling.service.port.repository.DriverPerVehicleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.json.JsonPatch;
import java.util.Optional;
import java.util.UUID;

@Component
@Transactional
@Slf4j
public class UpdateDriverPerVehicleUseCaseFacadeImpl implements UpdateDriverPerVehicleUseCaseFacade {
    @Autowired
    private DriverPerVehicleRepository driverPerVehicleRepository;
    @Autowired
    private JsonPatchMapper<DriverPerVehicleEntity> jsonPatchMapper;
    @Autowired
    private EntityAssembler<DriverPerVehicleEntity, DriverPerVehicleDomain,DriverPerVehicleDTO> entityAssembler;

    @Override
    public void execute(UUID id, JsonPatch json, DriverPerVehicleDTO dto) {
        Optional<DriverPerVehicleEntity> response = driverPerVehicleRepository.findDriverPerVehicleEntityById(id);
        if (response.isEmpty()) {
            throw CarpoolingCustomException.buildTechnicalException("Unexpect error try to find the information");
        }
        DriverPerVehicleEntity entity = jsonPatchMapper.apply(response.get(),json);
        driverPerVehicleRepository.save(entity);
    }
}
