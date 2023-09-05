package co.edu.uco.carpooling.service.specification.impl.vehicle;

import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;

public class VehicleNotDefaultSpecification extends CompositeSpecification<VehicleDomain> {
    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return false;
    }
}
