package co.edu.uco.carpooling.service.specification.impl.driver;

import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.carpooling.service.specification.impl.cutomer.ValidCustomerSpecification;
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
    @Autowired
    private ValidCustomerSpecification validCustomerSpecification;

    @Override
    public boolean isSatisfyBy(DriverDomain object) {
        return driverLicenseValidSpecification.and(driverIdValidaSpecification).and(driverCategoryValidSpecification)
                .isSatisfyBy(object) && validCustomerSpecification.isSatisfyBy(object.getCustomer());
    }
}
