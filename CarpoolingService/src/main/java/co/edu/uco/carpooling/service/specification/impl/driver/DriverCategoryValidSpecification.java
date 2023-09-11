package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.adapter.repository.DriverRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DriverCategoryValidSpecification extends CompositeSpecification<DriverDomain> {
    @Autowired
    private DriverRepository repository;

    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        try {
            Optional<DriverEntity> response = repository.getDriverByCustomer(object.getUser().getId());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Error try add driver, customer already exist");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add driver, please try again");
        }
        return true;
    }
}
