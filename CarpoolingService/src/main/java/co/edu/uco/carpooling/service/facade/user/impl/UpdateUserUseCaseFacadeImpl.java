package co.edu.uco.carpooling.service.facade.user.impl;

import co.edu.uco.carpooling.dto.CustomerDTO;
import co.edu.uco.carpooling.service.domain.CustomerDomain;
import co.edu.uco.carpooling.service.facade.user.UpdateUserFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.user.UpdateCustomerUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateUserUseCaseFacadeImpl implements UpdateUserFacade {
    @Autowired
    private DTOAssembler<CustomerDTO, CustomerDomain> dtoAssembler;
    @Autowired
    private UpdateCustomerUseCase customerUseCase;

    @Override
    public void execute(UUID uuid, CustomerDTO dto) {
        CustomerDomain customerDomain = dtoAssembler.assembleDomain(dto);
        customerUseCase.execute(uuid,customerDomain);
    }
}
