package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.dto.UserDTO;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.facade.user.RegisterUserUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.user.RegisterUserUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterCustomerUseCaseFacadeImpl implements RegisterUserUseCaseFacade {

    @Autowired
    private DTOAssembler<UserDTO, CustomerDomain> dtoAssembler;

    @Autowired
    private RegisterUserUseCase userUseCase;


    @Override
    public void execute(UserDTO dto) {
        CustomerDomain customerDomain = dtoAssembler.assembleDomain(dto);
        userUseCase.execute(customerDomain);
    }
}
