package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DriverIdValidaSpecification extends CompositeSpecification<DriverDomain> {
    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        if (UtilObject.getUtilObject().isNull(object.getId())) {
            throw CarpoolingCustomException.buildUserException("Driver id can not be null");
        } else if (UtilUUID.getUtilUUID().getStringFromUUID(object.getId()).length() != 36 || Objects.equals(object.getId().toString(),UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("Invalid driver id");
        }
        return true;
    }
}
