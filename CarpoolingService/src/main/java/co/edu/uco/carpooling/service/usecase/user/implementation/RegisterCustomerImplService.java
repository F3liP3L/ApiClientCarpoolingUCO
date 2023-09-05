package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.adapter.repository.CustomerRepository;
import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.usecase.user.RegisterCustomerCustomerCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerImplService implements RegisterCustomerCustomerCase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityAssembler<CustomerEntity, CustomerDomain, CustomerDTO> assemblerService;

    @Override
    public void execute(CustomerDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        CustomerEntity customerEntity = assemblerService.assembleEntity(domain);
        customerRepository.save(customerEntity);
    }
}
