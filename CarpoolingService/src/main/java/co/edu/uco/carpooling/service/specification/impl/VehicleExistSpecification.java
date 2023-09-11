package co.edu.uco.carpooling.service.specification.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.VehicleEntity;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.port.repository.VehicleRepository;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class VehicleExistSpecification extends CompositeSpecification<VehicleDomain> {
    @Autowired
    private VehicleRepository repository;
    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return isExist(object);
    }

    private boolean isExist(VehicleDomain vehicle) {
        try {
            Optional<VehicleEntity> response = repository.findById(vehicle.getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The vehicle you are trying to register already exists.");
            }
                response = repository.findByPlate(vehicle.getPlate());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("A vehicle is already registered with the license plate entered.");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected exception occurred when registering the vehicle.", exception.getMessage(), exception);
        }
    }
}
