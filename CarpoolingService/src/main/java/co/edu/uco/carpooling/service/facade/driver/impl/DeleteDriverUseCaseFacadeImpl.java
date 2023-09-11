package co.edu.uco.carpooling.service.facade.driver.impl;

import co.edu.uco.carpooling.dto.DriverDTO;
import co.edu.uco.carpooling.service.domain.DriverDomain;
import co.edu.uco.carpooling.service.facade.driver.DeleteDriverUseCaseFacade;
import co.edu.uco.carpooling.service.mapper.dtoassembler.DTOAssembler;
import co.edu.uco.carpooling.service.usecase.driver.DeleteDriverUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteDriverUseCaseFacadeImpl implements DeleteDriverUseCaseFacade {

    @Autowired
    private DeleteDriverUseCase deleteDriverUseCase;
    @Autowired
    private DTOAssembler<DriverDTO, DriverDomain> dtoAssembler;

    @Override
    public void execute(DriverDTO dto) {
        DriverDomain driverDomain = dtoAssembler.assembleDomain(dto);
        deleteDriverUseCase.execute(driverDomain);
    }
}
