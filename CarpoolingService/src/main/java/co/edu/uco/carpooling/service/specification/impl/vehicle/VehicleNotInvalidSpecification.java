package co.edu.uco.carpooling.service.specification.impl.vehicle;

import co.edu.uco.carpooling.adapter.repository.DriverRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.crosscutting.util.ConstantsCarpooling;
import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.util.UtilNumeric;
import co.edu.uco.crosscutting.util.UtilText;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleNotInvalidSpecification extends CompositeSpecification<VehicleDomain> {
    private static final Integer CAPACITY_MIN = 1;
    private static final Integer CAPACITY_MAX = 50;
    @Autowired
    private DriverRepository driverRepository;

    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return isValid(object);
    }

    private boolean isValid(VehicleDomain vehicle) {
        if (!UtilText.getUtilText().validMatch(vehicle.getPlate(), ConstantsCarpooling.PLATE)) {
            throw CarpoolingCustomException.buildUserException("The plate entered does not comply with the appropriate characters.");
        }
        if (!UtilNumeric.getUtilNumeric().isBetween(vehicle.getCapacity(), CAPACITY_MIN, CAPACITY_MAX, true, true)) {
            throw CarpoolingCustomException.buildUserException("The capacity of your vehicle exceeds the maximum amount allowed.");
        }
        if (driverRepository.findById(vehicle.getOwner().getId()).isEmpty()) {
            throw CarpoolingCustomException.buildUserException("There is no driver with the identifier sent.");
        }
        return true;
    }

}
