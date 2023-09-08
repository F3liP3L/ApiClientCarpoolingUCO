package co.edu.uco.carpooling.service.facade.driver.impl;

import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.facade.driver.RegisterDriverUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.driver.RegisterDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDriverUseCaseFacadeImpl implements RegisterDriverUseCaseFacade {

    @Autowired
    private RegisterDriverUseCase registerDriverUseCase;

    @Autowired
    private DTOAssembler<DriverDTO, DriverDomain> dtoAssembler;

    @Override
    public void execute(DriverDTO dto) {
        DriverDomain driverDomain = dtoAssembler.assembleDomain(dto);
        registerDriverUseCase.execute(driverDomain);
    }
}
