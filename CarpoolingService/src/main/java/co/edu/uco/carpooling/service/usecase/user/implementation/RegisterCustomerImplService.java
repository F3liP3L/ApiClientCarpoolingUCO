package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.repository.CustomerRepository;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssemblerService;
import co.edu.uco.carpooling.service.usecase.user.RegisterUserUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerImplService implements RegisterUserUseCase {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private EntityAssemblerService<CustomerEntity, CustomerDomain>  assemblerService;

    @Override
    public void execute(CustomerDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        CustomerEntity customerEntity = assemblerService.assembleEntity(domain);
        customerRepository.createCustomer(customerEntity.getId(), customerEntity.getDni(), customerEntity.getFirstName(),
                customerEntity.getSecondName(), customerEntity.getFirstSurname(),customerEntity.getSecondSurname()
                , customerEntity.getPassword(), customerEntity.getCompanyEmail(), customerEntity.getPhone(), customerEntity.getRol());
    }
}
