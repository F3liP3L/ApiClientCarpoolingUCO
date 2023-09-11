package co.edu.uco.carpooling.service.specification.impl.vehicle;

import co.edu.uco.carpooling.service.domain.VehicleDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.carpooling.service.specification.impl.driver.DriverExistSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidVehicleSpecification extends CompositeSpecification<VehicleDomain> {
    @Autowired
    private VehicleNotDefaultSpecification notDefaultSpecification;
    @Autowired
    private VehicleExistSpecification existSpecification;
    @Autowired
    private VehicleNotInvalidSpecification notInvalidSpecification;

    @Override
    public boolean isSatisfyBy(VehicleDomain object) {
        return notDefaultSpecification.and(notInvalidSpecification).andNot(existSpecification).isSatisfyBy(object);
    }

}
