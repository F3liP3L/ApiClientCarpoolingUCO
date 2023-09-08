package co.edu.uco.carpooling.service.specification.impl.cutomer;

import co.edu.uco.carpooling.adapter.repository.CustomerRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerEmailValidSpecification extends CompositeSpecification<CustomerDomain> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isSatisfyBy(CustomerDomain object) {
        try {
            Optional<CustomerEntity> response = repository.findEmail(object.getCompanyEmail());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Please check the email listed, the phone email has already been registered.");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add email, please try again");
        }
        return true;
    }
}
