package co.edu.uco.carpooling.service.usecase.vehicle.implementation;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.dto.VehicleDTO;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.specification.impl.vehicle.ValidVehicleSpecification;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import co.edu.uco.carpooling.service.usecase.vehicle.RegisterVehicleUseCase;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterVehicleUseCaseImpl implements RegisterVehicleUseCase {
    @Autowired
    private VehicleRepository repository;
    @Autowired
    private EntityAssembler<VehicleEntity, VehicleDomain, VehicleDTO> entityAssembler;
    @Autowired
    private ValidVehicleSpecification specification;
    @Override
    public void execute(VehicleDomain domain) {
        try {
            VehicleEntity entity = entityAssembler.assembleEntity(domain);
            specification.isSatisfyBy(domain);
            repository.save(entity);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected error occurred when registering a vehicle.", exception.getMessage(), exception);
        }
    }
}
