package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverExistSpecification extends CompositeSpecification<DriverDomain> {
    @Autowired
    private DriverRepository repository;
    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        return isExist(object);
    }

    private boolean isExist(DriverDomain driver) {
        try {
            Optional<DriverEntity> response = repository.findById(driver.getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("The driver you are trying to register exists.");
            }
            return true;
        } catch (CarpoolingCustomException exception) {
            throw exception;
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.build("An unexpected exception occurred when registering the vehicle.", exception.getMessage(), exception);
        }
    }
}
