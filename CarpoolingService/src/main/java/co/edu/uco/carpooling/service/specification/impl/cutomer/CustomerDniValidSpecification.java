package co.edu.uco.carpooling.service.specification.impl.cutomer;

import co.edu.uco.carpooling.adapter.repository.CustomerRepository;
import co.edu.uco.carpooling.crosscutting.exception.CarpoolingCustomException;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.specification.CompositeSpecification;
import co.edu.uco.crosscutting.exception.GeneralException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Optional;

@Component
public class CustomerDniValidSpecification extends CompositeSpecification<CustomerDomain> {

    @Autowired
    private CustomerRepository repository;

    @Override
    public boolean isSatisfyBy(CustomerDomain object) {
        try {
            Optional<CustomerEntity> response = repository.findDni(object.getDni());
            if (response.isPresent()){
                throw CarpoolingCustomException.buildUserException("Please check the dni number listed, the dni number has already been registered.");
            }
        } catch (GeneralException exception) {
            throw CarpoolingCustomException.buildUserException("Unexpect error try to add dni, please try again");
        }
        return true;
    }
}
