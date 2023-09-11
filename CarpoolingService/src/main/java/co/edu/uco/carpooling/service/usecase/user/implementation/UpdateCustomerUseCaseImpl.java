package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.repository.CustomerRepository;
import co.edu.uco.carpooling.service.usecase.user.UpdateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UpdateCustomerUseCaseImpl implements UpdateCustomerUseCase {
    @Autowired
    private EntityAssembler<CustomerEntity,CustomerDomain, CustomerDTO> assemblerService;
    @Autowired
    private CustomerRepository repository;
    @Override
    public void execute(UUID uuid, CustomerDomain domain) {
        Optional<CustomerEntity> customerEntity = repository.findById(uuid);
        CustomerEntity entity = assemblerService.assembleEntity(domain);
        customerEntity.ifPresent(customer -> {
            customer.setId(uuid);
            customer.setDni(entity.getDni());
            customer.setFirstName(entity.getFirstName());
            customer.setSecondName(entity.getSecondName());
            customer.setFirstSurname(entity.getFirstSurname());
            customer.setSecondSurname(entity.getSecondSurname());
            customer.setPassword(entity.getPassword());
            customer.setCompanyEmail(entity.getCompanyEmail());
            customer.setPhone(entity.getPhone());
            customer.setRol(entity.getRol());
            repository.save(customer);
        });
    }
}
