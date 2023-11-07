package co.edu.uco.carpooling.service.usecase.user.implementation;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.entity.CustomerEntity;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import co.edu.uco.carpooling.service.specification.impl.cutomer.ValidCustomerSpecification;
import co.edu.uco.carpooling.service.usecase.user.RegisterCustomerUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {
    @Autowired
    private EntityAssembler<CustomerEntity, CustomerDomain, CustomerDTO> assemblerService;
    @Autowired
    private ValidCustomerSpecification validCustomerSpecification;
    @Autowired
    private PortAuthentication portAuthentication;

    @Override
    public void execute(CustomerDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        validCustomerSpecification.isSatisfyBy(domain);
        CustomerEntity customerEntity = assemblerService.assembleEntity(domain);
        portAuthentication.signUp(customerEntity);
    }
}
