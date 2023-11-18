package co.edu.uco.carpooling.service.usecase.driver.impl;

import co.edu.uco.carpooling.dto.AuthorizedCategoryDTO;
import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.entity.AuthorizedCategoryEntity;
import co.edu.uco.carpooling.entity.DriverEntity;
import co.edu.uco.carpooling.service.domain.AuthorizedCategoryDomain;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.mapper.entityassembler.EntityAssembler;
import co.edu.uco.carpooling.service.port.jwt.PortAuthentication;
import co.edu.uco.carpooling.service.port.repository.AuthorizedCategoryRepository;
import co.edu.uco.carpooling.service.port.repository.DriverRepository;
import co.edu.uco.carpooling.service.specification.impl.driver.ValidDriverSpecification;
import co.edu.uco.carpooling.service.usecase.driver.RegisterDriverUseCase;
import co.edu.uco.carpooling.service.usecase.user.RegisterCustomerUseCase;
import co.edu.uco.crosscutting.util.UtilUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterDriverUseCaseImpl implements RegisterDriverUseCase {

    @Autowired
    private EntityAssembler<DriverEntity,DriverDomain, DriverDTO> driverEntityAssembler;
    @Autowired
    private DriverRepository driverRepository;
    @Autowired
    private ValidDriverSpecification validDriverSpecification;
    @Autowired
    private PortAuthentication portAuthentication;
    @Autowired
    private RegisterCustomerUseCase registerCustomerUseCase;


    @Override
    public void execute(DriverDomain domain) {
        domain.setId(UtilUUID.getNewUUID());
        CustomerDomain customer = domain.getCustomer();
        customer.setId(UtilUUID.getNewUUID());
        domain.setCustomer(customer);
        validDriverSpecification.isSatisfyBy(domain);
        DriverEntity driverEntity = driverEntityAssembler.assembleEntity(domain);
        portAuthentication.customerSignUp(driverEntity.getCustomer());
        driverRepository.save(driverEntity);
    }
}
