package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.UserDomain;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.user.DeleteCustomerCustomerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCaseFacadeImpl implements DeleteUserUseCaseFacade {

    @Autowired
    private DTOAssembler<CustomerDTO, UserDomain> dtoAssembler;

    @Autowired
    private DeleteCustomerCustomerCase userUseCase;

    @Override
    public void execute(CustomerDTO dto) {
        UserDomain userDomain = dtoAssembler.assembleDomain(dto);
        userUseCase.execute(userDomain);
    }
}
