package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.repository.CustomerRepository;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssemblerService;
import co.edu.uco.carpooling.service.usecase.user.DeleteCustomerCustomerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerImplService implements DeleteCustomerCustomerCase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityAssemblerService<CustomerEntity,CustomerDomain, CustomerDTO> assemblerService;
    @Override
    public void execute(CustomerDomain domain) {
        CustomerEntity customerEntity = assemblerService.assembleEntity(domain);
        customerRepository.deleteById(customerEntity.getId());
    }
}
