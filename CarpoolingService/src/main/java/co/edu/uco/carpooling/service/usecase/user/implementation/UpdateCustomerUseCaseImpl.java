package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.adapter.repository.CustomerRepository;
import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.usecase.user.UpdateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {

    @Autowired
    private EntityAssembler<CustomerEntity,CustomerDomain, CustomerDTO> assemblerService;
    @Autowired
    private CustomerRepository repository;
    @Override
    public void execute(CustomerDomain domain) {

    }
}
