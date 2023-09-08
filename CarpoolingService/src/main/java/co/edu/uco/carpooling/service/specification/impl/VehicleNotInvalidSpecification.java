package co.edu.uco.carpooling.service.specification.impl;

import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VehicleNotInvalidSpecification extends CompositeSpecification<VehicleDomain> {
    @Autowired
    private VehicleNotDefaultSpecification notDefaultSpecification;
    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return notDefaultSpecification.isSatisfyBy(object);
    }

}
