package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.UserDomain;
import co.edu.uco.carpooling.service.facade.user.RegisterUserCustomerCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.user.RegisterCustomerCustomerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerUseCaseFacadeImpl implements RegisterUserCustomerCaseFacade {

    @Autowired
    private DTOAssembler<CustomerDTO, UserDomain> dtoAssembler;

    @Autowired
    private RegisterCustomerCustomerCase userUseCase;


    @Override
    public void execute(CustomerDTO dto) {
        UserDomain userDomain = dtoAssembler.assembleDomain(dto);
        userUseCase.execute(userDomain);
    }
}
