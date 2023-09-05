package co.edu.uco.carpooling.service.specification.impl.vehicle;

import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.stereotype.Component;

@Component
public class ValidVehicleSpecification extends CompositeSpecification<VehicleDomain> {
    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return false;
    }


}
