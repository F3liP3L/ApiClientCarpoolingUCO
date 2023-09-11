package co.edu.uco.carpooling.service.usecase.vehicle.implementation;

import co.edu.uco.carpooling.adapter.repository.VehicleRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.specification.impl.VehicleNotInvalidSpecification;
import co.edu.uco.carpooling.service.usecase.vehicle.UpdateVehicleUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UpdateVehicleUseCaseImpl implements UpdateVehicleUseCase {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> entityAssembler;

    @Autowired
    private VehicleNotInvalidSpecification specification;

    @Override
    public void execute(UUID id, VehicleDomain domain) {
        try {
            VehicleEntity entity = entityAssembler.assembleEntity(domain);
            repository.save(entity);
        } catch (CarpoolingCustomException exception) {
             throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred while trying to update the vehicle information.", exception.getMessage(), exception);
        }
    }
}
