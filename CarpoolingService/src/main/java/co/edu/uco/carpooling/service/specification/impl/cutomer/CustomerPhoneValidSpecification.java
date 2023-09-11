package co.edu.uco.carpooling.service.specification.impl.cutomer;

import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CustomerPhoneValidSpecification extends CompositeSpecification<CustomerDomain> {

    @Autowired
    private CustomerRepository repository;
    
    @Override
    public boolean isSatisfyBy(CustomerDomain object) {
        int count = 6;
        if (object.getPhone() < count) {
            throw CarpoolingCustomException.buildUserException("The size of the phone number is not allowed, it is too short");
        }
        try {
            Optional<CustomerEntity> response = repository.findPhone(object.getPhone());
            if (response.isPresent()) {
                throw CarpoolingCustomException.buildUserException("Please check the phone number listed, the phone number " +
                        "has already been registered.");
            }
        } catch (CarpoolingCustomException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add phone, please try again");
        }
        return true;
    }
}
