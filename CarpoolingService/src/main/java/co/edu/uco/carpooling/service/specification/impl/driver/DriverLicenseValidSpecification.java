package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class DriverLicenseValidSpecification extends CompositeSpecification<DriverDomain> {
    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        if (object.getLicenseNumber().length() < 6){
            throw CarpoolingCustomException.buildUserException("Please check the license number is to short, error try to add driver");
        }
        return true;
    }
}
