package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.facade.user.DeleteUserUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.user.DeleteCustomerCustomerCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteUserUseCaseFacadeImpl implements DeleteUserUseCaseFacade {

    @Autowired
    private DTOAssembler<CustomerDTO, CustomerDomain> dtoAssembler;

    @Autowired
    private DeleteCustomerCustomerCase userUseCase;

    @Override
    public void execute(CustomerDTO dto) {
        CustomerDomain customerDomain = dtoAssembler.assembleDomain(dto);
        userUseCase.execute(customerDomain);
    }
}
