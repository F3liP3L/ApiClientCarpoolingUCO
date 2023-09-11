package co.edu.uco.carpooling.service.usecase.vehicle.implementation;

import co.edu.uco.carpooling.adapter.repository.VehicleRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.specification.impl.VehicleExistSpecification;
import co.edu.uco.carpooling.service.usecase.vehicle.DeleteVehicleUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteVehicleUseCaseImpl implements DeleteVehicleUseCase {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> entityAssembler;
    @Autowired
    private VehicleExistSpecification specification;
    @Override
    public void execute(VehicleDomain domain) {
        try {
            VehicleEntity entity = entityAssembler.assembleEntity(domain);
            if (repository.findById(entity.getId()).isEmpty()) {
                throw CarpoolingCustomException.buildUserException("The vehicle has already been removed.");
            }
            repository.deleteById(entity.getId());
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred when trying to delete a vehicle.", exception.getMessage(), exception);
        }
    }
}
