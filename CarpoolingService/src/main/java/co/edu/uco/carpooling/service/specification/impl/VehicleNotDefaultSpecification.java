package co.edu.uco.carpooling.service.specification.impl;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.stereotype.Component;

@Component
public class VehicleNotDefaultSpecification extends CompositeSpecification<VehicleDomain> {
    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return isValid(object);
    }

    private boolean isValid(VehicleDomain vehicle) {
        if (UtilUUID.getUtilUUID().getStringFromUUID(vehicle.getId()).equals(UtilUUID.DEFAULT_UUID_STRING)) {
            throw CarpoolingCustomException.buildUserException("The id of the vehicle you are trying to register is the default id.");
        }
        if (UtilNumeric.getUtilNumeric().isLessOrEqualThan(vehicle.getCapacity(), UtilNumeric.ZERO)) {
            throw CarpoolingCustomException.buildUserException("The capacity must be greater than zero");
        }
        if (UtilText.getUtilText().isEmpty(vehicle.getPlate())) {
            throw CarpoolingCustomException.buildUserException("The vehicle registration number cannot be an empty field.");
        }
        return true;
    }
}
