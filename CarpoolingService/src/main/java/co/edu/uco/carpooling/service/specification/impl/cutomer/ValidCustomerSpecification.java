package co.edu.uco.carpooling.service.specification.impl.cutomer;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidCustomerSpecification extends CompositeSpecification<CustomerDomain> {

    @Autowired
    CustomerDniValidSpecification dniValidSpecification;
    @Autowired
    CustomerIdValidSpecification idValidSpecification;
    @Autowired
    CustomerEmailValidSpecification emailValidSpecification;
    @Autowired
    CustomerPhoneValidSpecification phoneValidSpecification;

    @Override
    public boolean isSatisfyBy(CustomerDomain object) {
        try {
            return dniValidSpecification.and(idValidSpecification)
                    .and(emailValidSpecification).and(phoneValidSpecification)
                    .isSatisfyBy(object);
        } catch (CarpoolingCustomException exception) {
            throw exception;
        }
    }
}
