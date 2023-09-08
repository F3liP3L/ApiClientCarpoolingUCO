package co.edu.uco.carpooling.service.specification.impl.cutomer;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilObject;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomerIdValidSpecification extends CompositeSpecification<CustomerDomain> {

    @Override
    public boolean isSatisfyBy(CustomerDomain object) {
        if (UtilObject.getUtilObject().isNull(object.getId())) {
            throw CarpoolingCustomException.buildUserException("Customer id can not be null");
        } else if (UtilUUID.getUtilUUID().getStringFromUUID(object.getId()).length() != 36 || Objects.equals(object.getId().toString(),UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("Invalid customer id");
        }
        return true;
    }
}
