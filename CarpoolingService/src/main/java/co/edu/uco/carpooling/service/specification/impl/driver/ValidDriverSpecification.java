package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidDriverSpecification extends CompositeSpecification<DriverDomain> {
    @Autowired
    DriverLicenseValidSpecification driverLicenseValidSpecification;
    @Autowired
    DriverIdValidaSpecification driverIdValidaSpecification;
    @Autowired
    DriverCategoryValidSpecification driverCategoryValidSpecification;

    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        return driverLicenseValidSpecification.and(driverIdValidaSpecification).and(driverCategoryValidSpecification)
                .isSatisfyBy(object);
    }
}
